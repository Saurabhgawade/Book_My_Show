package com.Accio.BookMyShowProject.Models;

import com.Accio.BookMyShowProject.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theatreseat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theatreSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
