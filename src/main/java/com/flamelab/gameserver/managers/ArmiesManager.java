package com.flamelab.gameserver.managers;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import com.flamelab.gameserver.entities.Army;
import org.bson.types.ObjectId;

public interface ArmiesManager {

    TransferArmyDto addUnit(AddUnitDto addUnitDto);

}
