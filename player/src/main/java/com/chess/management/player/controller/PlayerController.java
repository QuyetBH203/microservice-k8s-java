package com.chess.management.player.controller;

import com.chess.management.player.dto.PlayerRequest;
import com.chess.management.player.dto.PlayerResponse;
import com.chess.management.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.createPlayer(playerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public boolean isPlayerAvailable(@RequestParam String playerId) {
        return playerService.isPlayerAvailable(Long.parseLong(playerId));
    }


}
