package com.chess.management.participant.dto;

import java.time.LocalDate;

public record ParticipantResponse(LocalDate dateAttend, Long numberOfMatches, Long point, String note) {
}
