package com.chess.management.participant.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface PlayerClient {

    @GetExchange("/api/player/available")
    boolean isPlayerAvailable(@RequestParam Long playerId);
}
