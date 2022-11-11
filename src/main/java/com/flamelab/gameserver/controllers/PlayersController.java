package com.flamelab.gameserver.controllers;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.managers.PlayersManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayersController {

    private final PlayersManager playersManager;

    @PostMapping
    public TransferPlayerDto createPlayer(CreatePlayerDto createPlayerDto) {
        return playersManager.createPlayer(createPlayerDto);
    }

    @GetMapping("/{id}")
    public TransferPlayerDto getPlayerById(@PathVariable("id") UUID playerId) {
        return playersManager.getPlayerById(playerId);
    }

    @GetMapping("/all")
    public List<TransferPlayerDto> getAllPlayers() {
        return playersManager.getAllPlayers();
    }

    @PutMapping("{id}")
    public TransferPlayerDto updatePlayer(@PathVariable("id") UUID playerId, UpdatePlayerDto updatePlayerDto) {
        return playersManager.updatePlayerById(playerId, updatePlayerDto);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable("id") UUID playerId) {
        playersManager.deletePlayerById(playerId);
    }

}
