package com.flamelab.gameserver.managers;

import com.flamelab.gameserver.entities.Score;

import java.util.List;
import java.util.UUID;

public interface FightManager {
    List<Score> fight(UUID attackingPlayerId, UUID defendsPlayerId);
}
