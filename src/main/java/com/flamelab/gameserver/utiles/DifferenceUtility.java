package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.utiles.data.ObjectWithData;
import com.flamelab.gameserver.utiles.naming.FieldNames;

import java.util.Map;

public interface DifferenceUtility<B extends ObjectWithData> {

    Map<FieldNames, Object> getChanges(B objectBeforeChanges, B updatedObject, Class<B> objectBeforeChangesClass);

}
