package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.utiles.data.ObjectWithData;

public interface CopyUtility<C extends ObjectWithData> {

    C copy(C original, Class<C> copiedClass);

}
