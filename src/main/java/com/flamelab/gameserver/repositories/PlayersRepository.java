package com.flamelab.gameserver.repositories;

import com.flamelab.gameserver.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayersRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findPlayerById(UUID id);

}
