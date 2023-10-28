package com.Accio.BookMyShowProject.Repositories;

import com.Accio.BookMyShowProject.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{
    Movie findMovieBymovieName(String movieName);
}
