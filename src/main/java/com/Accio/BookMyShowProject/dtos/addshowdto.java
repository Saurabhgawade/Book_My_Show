package com.Accio.BookMyShowProject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class addshowdto {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private int theatreId;
}
