package com.flamelab.gameserver.managers;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public interface PlayersManager {

    TransferPlayerDto createPlayer(CreatePlayerDto createPlayerDto);

    TransferPlayerDto getPlayerById(ObjectId playerId);

    List<TransferPlayerDto> getAllPlayers();

    TransferPlayerDto updatePlayerById(ObjectId playerId, UpdatePlayerDto updatePlayerDto);

    void deletePlayerById(ObjectId playerId);
}
