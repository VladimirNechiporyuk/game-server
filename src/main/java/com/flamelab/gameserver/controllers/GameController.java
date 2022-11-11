package com.flamelab.gameserver.controllers;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.entities.Score;
import com.flamelab.gameserver.managers.FightManager;
import com.flamelab.gameserver.managers.UnitAddingManager;
import com.flamelab.gameserver.entities.Army;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final FightManager fightManager;
    private final UnitAddingManager unitAddingManager;

    @PutMapping("/fight")
    public List<Score> fight(@RequestParam UUID attackingPlayerId, @RequestParam UUID defendsPlayerId) {
        return fightManager.fight(attackingPlayerId, defendsPlayerId);
    }

    @PutMapping("/addUnit")
    public Army addUnit(@RequestBody AddUnitDto addUnitDto) {
        return unitAddingManager.addUnit(addUnitDto);
    }

}
