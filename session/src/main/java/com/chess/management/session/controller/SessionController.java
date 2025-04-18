package com.chess.management.session.controller;


import com.chess.management.session.dto.SessionRequest;
import com.chess.management.session.dto.SessionResponse;
import com.chess.management.session.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponse createSession(@RequestBody  SessionRequest sessionRequest){
        return sessionService.createSession(sessionRequest);

    }


    @GetMapping("/available")
    public ResponseEntity<?> available(@RequestParam String sessionId){
        try{
            return ResponseEntity.ok(sessionService.isSessionAvailable(Long.parseLong(sessionId)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Session not found");

        }

    }
}
