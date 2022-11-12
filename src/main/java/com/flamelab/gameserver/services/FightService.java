package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.enums.UnitTypes;

import java.util.List;

public interface FightService {

    List<Score> fight(TransferPlayerDto firstPlayer, UnitTypes firstPlayerUnit, TransferPlayerDto secondPlayer, UnitTypes secondPlayerUnit);

}
