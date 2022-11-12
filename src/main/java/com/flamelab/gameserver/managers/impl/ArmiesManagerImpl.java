package com.flamelab.gameserver.managers.impl;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import com.flamelab.gameserver.entities.Army;
import com.flamelab.gameserver.managers.ArmiesManager;
import com.flamelab.gameserver.services.ArmiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArmiesManagerImpl implements ArmiesManager {

    private ArmiesService armiesService;

    @Override
    public TransferArmyDto addUnit(AddUnitDto addUnitDto) {
        return armiesService.addUnit(addUnitDto);
    }

}
