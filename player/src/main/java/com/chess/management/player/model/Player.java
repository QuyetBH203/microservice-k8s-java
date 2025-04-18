package com.chess.management.player.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "ki_thu")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_dang_nhap", nullable = false)
    private String username;

    @Column(name = "ho_ten", nullable = false)
    private String fullname;

    @Column(name = "ngay_sinh", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name="quoc_tich", nullable = false)
    private String nationality;

    @Column(name = "so_diem_elo", nullable = false)
    private Long elo;

    @Column(name = "hang_elo", nullable = false)
    private String rankElo;

}
