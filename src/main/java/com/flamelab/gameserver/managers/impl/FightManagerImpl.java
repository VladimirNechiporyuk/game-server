package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.dtos.create.DoFightDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.managers.FightManager;
import com.flamelab.gameserver.services.FightService;
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
public class FightManagerImpl implements FightManager {

    private final FightService fightService;
    private final PlayersService playersService;

    @Override
    public List<Score> fight(DoFightDto firstPlayerFightData, DoFightDto secondPlayerFightData) {
        TransferPlayerDto firstPlayer = playersService.getEntityById(firstPlayerFightData.getPlayerId());
        TransferPlayerDto secondPlayer = playersService.getEntityById(secondPlayerFightData.getPlayerId());
        return fightService.fight(firstPlayer, firstPlayerFightData.getUnitType(), secondPlayer, secondPlayerFightData.getUnitType());
    }
}
