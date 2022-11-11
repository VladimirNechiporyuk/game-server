package com.flamelab.gameserver.utiles;

import com.flamelab.gameserver.dtos.create.CommonCreateDto;
import com.flamelab.gameserver.entities.CommonEntity;

public interface EntityBuilder<E extends CommonEntity, D extends CommonCreateDto> {

    E buildEntityFromDto(D createDto, Class<D> createDtoClass, Class<E> entityClass);

}
