package com.flamelab.gameserver.managers;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.entities.Army;

public interface UnitAddingManager {
    Army addUnit(AddUnitDto addUnitDto);
}
