package com.flamelab.gameserver.utiles.impl;

import com.flamelab.gameserver.entities.CommonEntity;
import com.flamelab.gameserver.exceptions.EntityListDoesNotContainsProvidedValueException;
import com.flamelab.gameserver.utiles.DbEntityUtility;
import com.flamelab.gameserver.utiles.DbEntityUtilityBySeveralCollections;
import com.flamelab.gameserver.utiles.naming.DbCollectionNames;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.flamelab.gameserver.utiles.naming.FieldNames.ID__FIELD_APPELLATION;

@Component
@RequiredArgsConstructor
public class DbEntityUtilityBySeveralCollectionsImpl<F extends CommonEntity, S extends CommonEntity> implements DbEntityUtilityBySeveralCollections<F, S> {

    private final DbEntityUtility<F> firstDbEntityUtility;
    private final DbEntityUtility<S> secondDbEntityUtility;

    public F findFirstEntityWhichParameterLocatedInSecondDbEntityListParameter(ObjectId firstEntityId,
                                                                               Object firstEntitySearchedValue,
                                                                               Class<F> firstEntityClass,
                                                                               DbCollectionNames firstEntityDbCollectionName,
                                                                               ObjectId secondEntityId,
                                                                               FieldNames secondEntityFieldListName,
                                                                               Class<S> secondEntityClass,
                                                                               DbCollectionNames secondEntityDbCollectionName) {

        boolean secondEntityParameterListContainsFirstEntityParameterValue =
                secondDbEntityUtility.isDbEntityListParameterContainsValue(
                        secondEntityId,
                        secondEntityFieldListName,
                        firstEntitySearchedValue,
                        secondEntityClass,
                        secondEntityDbCollectionName);
        if (secondEntityParameterListContainsFirstEntityParameterValue) {
            return firstDbEntityUtility.findOneBy(Map.of(ID__FIELD_APPELLATION, firstEntityId), firstEntityClass, firstEntityDbCollectionName);
        } else {
            throw new EntityListDoesNotContainsProvidedValueException(
                    String.format("Entity from collection '%s' with id '%s' parameter list '%s' does not contains value '%s' from entity with id '%s' from collection '%s'.",
                            secondEntityDbCollectionName, secondEntityId, secondEntityFieldListName, firstEntitySearchedValue, firstEntityId, firstEntityDbCollectionName));
        }
    }

}
