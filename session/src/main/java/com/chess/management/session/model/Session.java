package com.chess.management.session.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "mua_giai")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thoi_gian_bat_dau", nullable = false)
    private LocalDate startTime;

    @Column(name = "thoi_gian_ket_thuc", nullable = false)
    private LocalDate endTime;

    @Column(name = "ten_mua_giai", nullable = false)
    private String nameSession;

    @Column(name = "trang_thai", nullable = false)
    @Enumerated(EnumType.STRING)
    private TrangThai status;

    @Column(name = "mo_ta", nullable = false)
    private String description;

    @Column(name = "gia_tri_giai_thuong", nullable = false)
    private Long reward;

}
