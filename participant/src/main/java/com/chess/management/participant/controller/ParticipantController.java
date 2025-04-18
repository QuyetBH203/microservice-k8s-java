package com.chess.management.participant.controller;

import com.chess.management.participant.dto.ParticipantRequest;
import com.chess.management.participant.dto.ParticipantResponse;
import com.chess.management.participant.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participant")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponse participateInSession(@RequestBody ParticipantRequest participantRequest) {
        return participantService.joinSession(participantRequest);

    }
}
