package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.entities.Army;
import com.flamelab.gameserver.managers.UnitAddingManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UnitAddingManagerImpl implements UnitAddingManager {
    @Override
    public Army addUnit(AddUnitDto addUnitDto) {
        return null;
    }
}
