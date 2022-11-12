package com.flamelab.gameserver.controllers;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.dtos.create.DoFightDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.managers.ArmiesManager;
import com.flamelab.gameserver.managers.FightManager;
import com.flamelab.gameserver.entities.Army;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final FightManager fightManager;
    private final ArmiesManager armiesManager;

    @PutMapping("/fight")
    public List<Score> fight(@RequestParam DoFightDto firstPlayer, @RequestParam DoFightDto secondPlayer) {
        return fightManager.fight(firstPlayer, secondPlayer);
    }

    @PutMapping("/addUnit")
    public TransferArmyDto addUnit(@RequestBody AddUnitDto addUnitDto) {
        return armiesManager.addUnit(addUnitDto);
    }

}
