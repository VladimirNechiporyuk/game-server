package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.managers.PlayersManager;
import com.flamelab.gameserver.services.ArmiesService;
import com.flamelab.gameserver.services.PlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayersManagerImpl implements PlayersManager {

    private final PlayersService playersService;
    private final ArmiesService armiesService;

    @Override
    public TransferPlayerDto createPlayer(CreatePlayerDto createPlayerDto) {
        TransferArmyDto army = armiesService.createArmy();
        TransferPlayerDto player = playersService.createEntity(createPlayerDto, army.getId());
        armiesService.setPlayerIdForArmy(army.getId(), player.getId());
        return player;
    }

    @Override
    public TransferPlayerDto getPlayerById(ObjectId playerId) {
        return playersService.getEntityById(playerId);
    }

    @Override
    public List<TransferPlayerDto> getAllPlayers() {
        return playersService.getAllEntities();
    }

    @Override
    public TransferPlayerDto updatePlayerById(ObjectId playerId, UpdatePlayerDto updatePlayerDto) {
        return playersService.updateEntityById(playerId, updatePlayerDto);
    }

    @Override
    public void deletePlayerById(ObjectId playerId) {
        playersService.deleteEntityById(playerId);
    }

}
