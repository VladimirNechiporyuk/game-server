package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.entities.CommonEntity;
import com.flamelab.gameserver.utiles.naming.DbCollectionNames;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import org.bson.types.ObjectId;

public interface DbEntityUtilityBySeveralCollections<F extends CommonEntity, S extends CommonEntity> {

    F findFirstEntityWhichParameterLocatedInSecondDbEntityListParameter(ObjectId firstEntityId,
                                                                        Object firstEntitySearchedValue,
                                                                        Class<F> firstEntityClass,
                                                                        DbCollectionNames firstEntityDbCollectionName,
                                                                        ObjectId secondEntityId,
                                                                        FieldNames secondEntityFieldListName,
                                                                        Class<S> secondEntityClass,
                                                                        DbCollectionNames secondEntityDbCollectionName);

}
