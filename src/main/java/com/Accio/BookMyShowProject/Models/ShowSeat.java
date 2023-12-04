package com.Accio.BookMyShowProject.Models;

import com.Accio.BookMyShowProject.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "showseat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean isAvailable;

    private boolean foodAttached;

    private int price;

    @ManyToOne
    @JoinColumn
    private Show show;

}
