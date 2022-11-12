package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface PlayersService {

    TransferPlayerDto createEntity(CreatePlayerDto createDto, ObjectId armyId);

    TransferPlayerDto getEntityById(ObjectId id);

    List<TransferPlayerDto> getAllEntities();

    List<String> getAvailableParametersNameOfEntity();

    TransferPlayerDto updateEntityById(ObjectId id, UpdatePlayerDto updatedDto);

    void deleteEntityById(ObjectId id);

    boolean isPlayerExists(ObjectId playerId);

}
