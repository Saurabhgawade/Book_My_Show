package com.Accio.BookMyShowProject.Repositories;

import com.Accio.BookMyShowProject.Models.Movie;
import com.Accio.BookMyShowProject.Models.Show;
import com.Accio.BookMyShowProject.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheatre(LocalDate ShowDate, LocalTime ShowTime, Movie movie, Theatre theatre);
}
