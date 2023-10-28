package com.Accio.BookMyShowProject.dtos;

import com.Accio.BookMyShowProject.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class addmoviedto {
    private String movieName;


    private Genre genre;

    private double rating;

    private LocalDate releaseDate;

}
