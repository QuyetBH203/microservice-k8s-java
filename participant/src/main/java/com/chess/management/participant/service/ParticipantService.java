package com.chess.management.participant.service;


import com.chess.management.participant.client.PlayerClient;
import com.chess.management.participant.client.SessionClient;
import com.chess.management.participant.dto.ParticipantRequest;
import com.chess.management.participant.dto.ParticipantResponse;
import com.chess.management.participant.model.Participant;
import com.chess.management.participant.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final PlayerClient playerClient;

    private final ParticipantRepository participantRepository;
    private final SessionClient sessionClient;

    public ParticipantResponse joinSession(ParticipantRequest participantRequest) {
        var isPlayerAvailable = playerClient.isPlayerAvailable(participantRequest.playerId());
        var isSessionAvailable = sessionClient.isSessionAvailable(participantRequest.sessionId());
        if (!isPlayerAvailable || !isSessionAvailable) {
            throw new IllegalArgumentException("Service is not available");
        }
        Participant participant = Participant.builder()
                .note(participantRequest.note())
                .dateAttend(LocalDate.now())
                .numberOfMatches(0L)
                .points(0L)
                .playerId(participantRequest.playerId())
                .sessionId(participantRequest.sessionId())
                .build();
        Participant savedParticipant = participantRepository.save(participant);
        return  new ParticipantResponse(
                savedParticipant.getDateAttend(),
                savedParticipant.getNumberOfMatches(),
                savedParticipant.getPoints(),
                savedParticipant.getNote()
        );
    }
}
