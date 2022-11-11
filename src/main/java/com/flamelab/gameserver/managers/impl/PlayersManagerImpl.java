package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.managers.PlayersManager;
import com.flamelab.gameserver.services.PlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayersManagerImpl implements PlayersManager {

    private final PlayersService playersService;

    @Override
    public TransferPlayerDto createPlayer(CreatePlayerDto createPlayerDto) {
        return playersService.createEntity(createPlayerDto);
    }

    @Override
    public TransferPlayerDto getPlayerById(UUID playerId) {
        return null;
    }

    @Override
    public List<TransferPlayerDto> getAllPlayers() {
        return null;
    }

    @Override
    public TransferPlayerDto updatePlayerById(UUID playerId, UpdatePlayerDto updatePlayerDto) {
        return null;
    }

    @Override
    public void deletePlayerById(UUID playerId) {

    }

}
