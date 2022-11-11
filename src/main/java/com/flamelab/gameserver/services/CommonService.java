package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.create.CommonCreateDto;
import com.flamelab.gameserver.dtos.transcfer.CommonTransferDto;
import com.flamelab.gameserver.dtos.update.CommonUpdateDto;

import java.util.List;
import java.util.UUID;

public interface CommonService<
        C extends CommonCreateDto,
        T extends CommonTransferDto,
        U extends CommonUpdateDto
        > {
    T createEntity(C createDto);

    T getEntityById(UUID id);

    List<T> getAllEntities();

    T updateEntity(UUID id, U updateDto);

    void deleteEntityById(UUID id);
}
