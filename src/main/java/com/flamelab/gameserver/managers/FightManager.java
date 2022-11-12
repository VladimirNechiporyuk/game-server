package com.flamelab.gameserver.managers;

import com.flamelab.gameserver.dtos.create.DoFightDto;
import com.flamelab.gameserver.entities.Score;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public interface FightManager {

    List<Score> fight(DoFightDto firstPlayerFightData, DoFightDto secondPlayerFightData);

}
