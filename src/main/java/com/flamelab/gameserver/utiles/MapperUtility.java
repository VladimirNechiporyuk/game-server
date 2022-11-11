package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.utiles.data.ObjectWithData;

import java.util.List;

public interface MapperUtility<F extends ObjectWithData, T extends ObjectWithData> {

    T map(F from, Class<F> fromClass, Class<T> toClass);

    List<T> mapToList(List<F> from, Class<F> fromClass, Class<T> toClass);

}
