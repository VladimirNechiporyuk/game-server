package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.managers.FightManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FightManagerImpl implements FightManager {
    @Override
    public List<Score> fight(UUID attackingPlayerId, UUID defendsPlayerId) {
        return null;
    }
}
