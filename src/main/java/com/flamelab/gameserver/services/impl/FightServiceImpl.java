package com.flamelab.gameserver.services.impl;

import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.enums.UnitTypes;
import com.flamelab.gameserver.services.FightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FightServiceImpl implements FightService {



    @Override
    public List<Score> fight(TransferPlayerDto firstPlayer, UnitTypes firstPlayerUnit, TransferPlayerDto secondPlayer, UnitTypes secondPlayerUnit) {
        return null;
    }
}
