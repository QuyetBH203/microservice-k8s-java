package com.chess.management.session.dto;

import com.chess.management.session.model.TrangThai;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record SessionResponse(LocalDate startDate, LocalDate endDate, String nameSession, TrangThai status, String description, Long reward) {

}
