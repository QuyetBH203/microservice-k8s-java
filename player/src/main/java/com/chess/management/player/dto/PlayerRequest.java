package com.chess.management.player.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PlayerRequest(String username,
                            String fullName,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
                            LocalDate dateOfBirth, String nationality, Long elo, String rankElo) {
}
