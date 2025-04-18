package com.chess.management.participant.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface SessionClient {
    @GetExchange("/api/session/available")
    boolean isSessionAvailable(@RequestParam("sessionId") Long sessionId);
}
