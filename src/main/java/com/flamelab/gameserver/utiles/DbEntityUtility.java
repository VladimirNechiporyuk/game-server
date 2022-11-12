package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.entities.CommonEntity;
import com.flamelab.gameserver.enums.SideOfValue;
import com.flamelab.gameserver.utiles.naming.DbCollectionNames;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface DbEntityUtility <E extends CommonEntity> {

    E saveEntity(E entityForSaving, Class<E> targetClass, DbCollectionNames dbCollectionName);

    E findOneByOrThrow(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    E findOneBy(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    E findOneById(ObjectId id, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    List<E> findAllBy(Map<FieldNames, Object> criterias, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    List<E> findAllWhichContainsAnyOfCriteria(Map<FieldNames, Object> criterias, List<Class<E>> searchedClasses, DbCollectionNames dbCollectionName);

    List<E> findAllWhichContainsPartOfParameterFromTheSide(Map<FieldNames, Object> criterias, SideOfValue side, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    List<E> findAllByClass(Class<E> entityClass, DbCollectionNames dbCollectionName);

    List<E> findAllInCollection(List<Class<E>> entityClassList, DbCollectionNames dbCollectionName);

    E updateEntity(E entity, Class<E> entityClass, Map<FieldNames, Object> fieldsWithNewData, DbCollectionNames collectionName);

    E updateOneFieldForEntity(Map<FieldNames, Object> criterias, FieldNames fieldName, Object updatedValue, Class<E> entityClass, DbCollectionNames collectionName);

    boolean isDbEntityListParameterContainsValue(ObjectId entityId, FieldNames entityFieldListName, Object searchedValue, Class<E> targetClass, DbCollectionNames dbCollectionName);

    boolean isEntityExistsBy(Map<FieldNames, Object> criterias, Class<E> targetClass, DbCollectionNames dbCollectionName);

    void deleteEntityBy(Map<FieldNames, Object> criterias, Class<E> targetClass, DbCollectionNames dbCollectionName);

}
