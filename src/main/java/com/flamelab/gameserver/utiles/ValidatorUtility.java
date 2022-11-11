package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.entities.CommonEntity;
import com.flamelab.gameserver.utiles.naming.DbCollectionNames;
import com.flamelab.gameserver.utiles.naming.FieldNames;

public interface ValidatorUtility<E extends CommonEntity> {

    void validateValueOnUniqueness(FieldNames key, Object value, Class<E> searchedClass, DbCollectionNames dbCollectionName);

    void validateIsValueCorrect(Object correctValue, Object checkedValue);
}
