package com.chess.management.player.repository;

import com.chess.management.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByUsername(String username);
}
