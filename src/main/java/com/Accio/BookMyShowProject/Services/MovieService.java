package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Models.Movie;
import com.Accio.BookMyShowProject.Repositories.MovieRepository;
import com.Accio.BookMyShowProject.Transformer.MovieTransformer;
import com.Accio.BookMyShowProject.dtos.addmoviedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(addmoviedto addmoviedto)throws Exception{
        Movie movie= MovieTransformer.moviedtoToMovie(addmoviedto);

        movieRepository.save(movie);
        return "movie added successfully";
    }
}
