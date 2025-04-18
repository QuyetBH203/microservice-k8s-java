package com.chess.management.player.dto;

import java.time.LocalDate;

public record PlayerResponse(String username, LocalDate dateOfBirth, String nationality, Long elo, String rankElo) {
}
