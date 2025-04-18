package com.chess.management.session.service;


import com.chess.management.session.dto.SessionRequest;
import com.chess.management.session.dto.SessionResponse;
import com.chess.management.session.model.Session;
import com.chess.management.session.model.TrangThai;
import com.chess.management.session.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionResponse createSession(SessionRequest sessionRequest){
        Session session = Session.builder()
                .startTime(sessionRequest.startTime())
                .endTime(sessionRequest.endTime())
                .nameSession(sessionRequest.nameSession())
                .status(sessionRequest.status())
                .description(sessionRequest.description())
                .reward(sessionRequest.reward())
                .build();
        Session savedSession = sessionRepository.save(session);
        return new SessionResponse(
                savedSession.getStartTime(),
                savedSession.getEndTime(),
                savedSession.getNameSession(),
                savedSession.getStatus(),
                savedSession.getDescription(),
                savedSession.getReward()
        );
    }

    public boolean isSessionAvailable(Long sessionId) {
        Optional<Session> session = sessionRepository.findById(sessionId);
        if(session.isEmpty()){
           throw new IllegalArgumentException("Session not found");
        }
        Session session1 = session.get();
        return session1.getStatus() == TrangThai.DANG_DIEN_RA;
    }
}
