package com.Accio.BookMyShowProject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookTicketdto {
    private String movieName;

    private int theaterId;

    private LocalDate showDate;

    private LocalTime showTime;

    List<String>bookticketlist;

    private int userId;
}
