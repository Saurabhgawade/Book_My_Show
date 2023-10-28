package com.Accio.BookMyShowProject.Transformer;

import com.Accio.BookMyShowProject.Models.Movie;
import com.Accio.BookMyShowProject.dtos.addmoviedto;

public class MovieTransformer {
    public static Movie moviedtoToMovie(addmoviedto addmoviedto){
        Movie movie=Movie.builder()
                .movieName(addmoviedto.getMovieName())
                .rating(addmoviedto.getRating())
                .releaseDate(addmoviedto.getReleaseDate())
                .genre(addmoviedto.getGenre())
                .build();
        return movie;
    }

}
