package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface ArmiesService {

    TransferArmyDto createArmy();

    void setPlayerIdForArmy(ObjectId armyId, ObjectId playerId);

    TransferArmyDto addUnit(AddUnitDto addUnitDto);

    TransferArmyDto getArmyData(ObjectId playerId);

    List<TransferArmyDto> getAllArmiesData();

}
