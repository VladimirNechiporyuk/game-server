package com.flamelab.gameserver.utiles.impl;

import com.flamelab.gameserver.entities.CommonEntity;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.enums.SideOfValue;
import com.flamelab.gameserver.exceptions.MoreThanOneEntityExistsByQueryException;
import com.flamelab.gameserver.exceptions.NoExistentEntityException;
import com.flamelab.gameserver.utiles.ClassUtility;
import com.flamelab.gameserver.utiles.DbEntityUtility;
import com.flamelab.gameserver.utiles.naming.DbCollectionNames;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.flamelab.gameserver.utiles.naming.FieldNames.ID__FIELD_APPELLATION;

@Component
@RequiredArgsConstructor
@Slf4j
public class MongoDbEntityUtilityImpl<E extends CommonEntity> implements DbEntityUtility<E> {

    private final MongoTemplate mongoTemplate;
    private final ClassUtility<E> classUtility;
    private final String separateSymbol = ",";

    public E saveEntity(E entityForSaving, Class<E> targetClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.save(entityForSaving, dbCollectionName.name());
    }

    public E findOneByOrThrow(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName) {
        E entity;
        try {
            entity = findOneBy(criterias, searchedClass, dbCollectionName);
        } catch (MoreThanOneEntityExistsByQueryException e) {
            throw new MoreThanOneEntityExistsByQueryException(String.format(
                    "More than one entity found by query with criterias: %s." +
                            "\nPlease try to find needed entity using id or several criterias", criterias));
        }
        if (entity == null) {
            throw new NoExistentEntityException(String.format("No entity found in collection '%s' by class %s and criterias %s.",
                    dbCollectionName, searchedClass, criterias));
        }
        return entity;
    }

    public E findOneBy(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName) {
        Query query = buildQuery(criterias);
        List<E> entitiesFoundFromDb = mongoTemplate.find(query, searchedClass, dbCollectionName.name());
        if (entitiesFoundFromDb.size() == 1) {
            return entitiesFoundFromDb.stream().findFirst().get();
        } else {
            return null;
        }
    }

    public E findOneById(ObjectId id, Class<E> searchedClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.findById(id, searchedClass, dbCollectionName.name());
    }

    public List<E> findAllBy(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.find(buildQuery(criterias), searchedClass, dbCollectionName.name());
    }

    public List<E> findAllWhichContainsAnyOfCriteria(Map<FieldNames, Object> criterias, List<Class<E>> searchedClasses, DbCollectionNames dbCollectionName) {
        List<E> entities = new ArrayList<>();
        for (Map.Entry<FieldNames, Object> entry : criterias.entrySet()) {
            if (entry.getValue() == null) {
                log.error("No provided value for criteria {}", entry.getKey());
            } else {
                List<E> allInCollection = findAllInCollection(searchedClasses, dbCollectionName);
                for (Class<E> targetClass : searchedClasses) {
                    if (classUtility.isParameterAsList(entry.getValue())) {
                        Object[] criteriaValues = String.valueOf(entry.getValue()).split(separateSymbol);
                        for (Object criteriaValue : criteriaValues) {
                            entities.addAll(searchEntitiesByCriteria(entry.getKey(), String.valueOf(criteriaValue), targetClass, allInCollection));
                        }
                    }
                    entities.addAll(searchEntitiesByCriteria(entry.getKey(), String.valueOf(entry.getValue()), targetClass, allInCollection));
                }
            }
        }
        return entities;
    }

    public List<E> findAllWhichContainsPartOfParameterFromTheSide(Map<FieldNames, Object> criterias, SideOfValue side, Class<E> searchedClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.find(buildQueryWithAnyValueFromSide(criterias, side), searchedClass, dbCollectionName.name());
    }

    public List<E> findAllByClass(Class<E> entityClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.findAll(entityClass, dbCollectionName.name());
    }

    public List<E> findAllInCollection(List<Class<E>> entityClassList, DbCollectionNames dbCollectionName) {
        List<E> resultList = new ArrayList<>();
        for (Class<E> entityClass : entityClassList) {
            resultList.addAll(findAllByClass(entityClass, dbCollectionName));
        }
        return resultList;
    }

    public E updateEntity(E entity, Class<E> entityClass, Map<FieldNames, Object> fieldsWithNewData, DbCollectionNames dbCollectionName) {
        entity = classUtility.setValuesForFields(entity, entityClass, fieldsWithNewData);
        return mongoTemplate.save(entity, dbCollectionName.name());
    }

    public E updateOneFieldForEntity(Map<FieldNames, Object> criterias, FieldNames fieldName, Object updatedValue, Class<E> entityClass, DbCollectionNames collectionName) {
        Update updateRequest = new Update();
        updateRequest.addToSet(fieldName.name(), updatedValue);
        return mongoTemplate.findAndModify(
                buildQuery(criterias),
                updateRequest,
                FindAndModifyOptions.options().upsert(true),
                entityClass,
                collectionName.name());
    }

    public boolean isDbEntityListParameterContainsValue(ObjectId entityId, FieldNames entityFieldListName, Object searchedValue, Class<E> targetClass, DbCollectionNames dbCollectionName) {
        E entityFromDb = findOneBy(Map.of(ID__FIELD_APPELLATION, entityId), targetClass, dbCollectionName);
        return isListContainsValue(entityFieldListName, targetClass, entityFromDb, searchedValue);
    }

    public boolean isEntityExistsBy(Map<FieldNames, Object> criterias, Class<E> targetClass, DbCollectionNames dbCollectionName) {
        return mongoTemplate.exists(buildQuery(criterias), targetClass, dbCollectionName.name());
    }

    @Override
    public void deleteEntityBy(Map<FieldNames, Object> criterias, Class<E> targetClass, DbCollectionNames dbCollectionName) {
        mongoTemplate.remove(buildQuery(criterias), Player.class, dbCollectionName.name());
    }

    private List<E> searchEntitiesByCriteria(FieldNames fieldName, String criteriaValue, Class<E> targetClass, List<E> allInCollection) {
        return allInCollection.stream()
                .filter(object ->
                        classUtility.isFieldValueEqualsToCriteria(
                                classUtility.findFieldFromClass(fieldName, targetClass),
                                criteriaValue,
                                object))
                .collect(Collectors.toList());
    }

    private boolean isListContainsValue(FieldNames entityFieldListName, Class<E> targetClass, E entityFromDb, Object searchedValue) {
        Field entityCollectionField = classUtility.findFieldFromClass(entityFieldListName, targetClass);
        List dbEntityParameterList;
        try {
            dbEntityParameterList = (List) entityCollectionField.get(entityFromDb);
            if (classUtility.isParameterAsList(dbEntityParameterList)) {
                throw new RuntimeException(String.format(String.format("Parameter '%s' is not a list", entityFieldListName)));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(String.format("Something went wrong during getting values of list from db entity '%s' by field '%s'", entityFromDb, entityFieldListName));
        }

        return dbEntityParameterList.contains(searchedValue);
    }

    private Query buildQuery(Map<FieldNames, Object> criterias) {
        Query query = new Query();
        for (Map.Entry<FieldNames, Object> entry : criterias.entrySet()) {
            if (classUtility.isParameterAsList(entry.getValue())) {
                List<Object> values = Arrays.asList(String.valueOf(entry.getValue()).split(separateSymbol));
                values.forEach(value -> addCriteria(entry.getKey(), value, query));
            }
            query.addCriteria(Criteria.where(entry.getKey().getField()).is(entry.getValue()));
        }
        return query;
    }

    private Query buildQueryWithAnyValueFromSide(Map<FieldNames, Object> criterias, SideOfValue sideOfValue) {
        Query query = new Query();
        for (Map.Entry<FieldNames, Object> entry : criterias.entrySet()) {
            if (classUtility.isParameterAsList(entry.getValue())) {
                List<Object> values = Arrays.asList(String.valueOf(entry.getValue()).split(separateSymbol));
                switch (sideOfValue) {
                    case BOTH ->
                            values.forEach(value -> addCriteriaAndAnyValueFromBothSides(entry.getKey(), value, query));
                    case RIGHT ->
                            values.forEach(value -> addCriteriaAndAnyValueFromRightSide(entry.getKey(), value, query));
                    case LEFT ->
                            values.forEach(value -> addCriteriaAndAnyValueFromLeftSide(entry.getKey(), value, query));
                }
            }
            query.addCriteria(Criteria.where(String.valueOf(entry.getKey().getField())).is(entry.getValue()));
        }
        return query;
    }

    private void addCriteria(FieldNames fieldName, Object value, Query query) {
        query.addCriteria(Criteria.where(fieldName.getField()).is(value));
    }

    private void addCriteriaAndAnyValueFromBothSides(FieldNames fieldName, Object value, Query query) {
        query.addCriteria(Criteria.where(fieldName.getField()).is("/" + value + "/"));
    }

    private void addCriteriaAndAnyValueFromRightSide(FieldNames fieldName, Object value, Query query) {
        query.addCriteria(Criteria.where(fieldName.getField()).is("^" + value + "/"));
    }

    private void addCriteriaAndAnyValueFromLeftSide(FieldNames fiendName, Object value, Query query) {
        query.addCriteria(Criteria.where(fiendName.getField()).is("/" + value + "$"));
    }

}
