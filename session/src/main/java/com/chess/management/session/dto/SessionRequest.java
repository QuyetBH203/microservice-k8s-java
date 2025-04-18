package com.chess.management.session.dto;

import com.chess.management.session.model.TrangThai;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record SessionRequest(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate startTime,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate endTime,
        String nameSession,
        TrangThai status,
        String description,
        Long reward) {
}
