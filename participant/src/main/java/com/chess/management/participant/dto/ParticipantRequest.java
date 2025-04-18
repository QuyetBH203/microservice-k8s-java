package com.chess.management.participant.dto;

import java.time.LocalDate;

public record ParticipantRequest( String note, Long playerId, Long sessionId) {
}
