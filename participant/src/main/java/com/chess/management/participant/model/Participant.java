package com.chess.management.participant.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "tham_du")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "so_tran_dau", nullable = false)
    private Long numberOfMatches;

    @Column(name = "so_diem", nullable = false)
    private long points;

    @Column(name = "ngay_tham_du", nullable = false)
    private LocalDate dateAttend;

    @Column(name = "ghi_chu", nullable = false)
    private String note;

    @Column(name = "ki_thu_id", nullable = false)
    private Long playerId;


    @Column(name = "mua_giai_id", nullable = false)
    private Long sessionId;
}
