package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Models.Movie;
import com.Accio.BookMyShowProject.Models.Show;
import com.Accio.BookMyShowProject.Models.Theatre;
import com.Accio.BookMyShowProject.Repositories.MovieRepository;
import com.Accio.BookMyShowProject.Repositories.ShowRepository;
import com.Accio.BookMyShowProject.Repositories.TheatreRepository;
import com.Accio.BookMyShowProject.Transformer.showTransformer;
import com.Accio.BookMyShowProject.dtos.addshowdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public String addshow(addshowdto addshowdto){
        Show show= showTransformer.showdtoToShow(addshowdto);

        Movie movie=movieRepository.findMovieBymovieName(addshowdto.getMovieName());

        Optional<Theatre>optionalTheatre=theatreRepository.findById(addshowdto.getTheatreId());
        Theatre theatre=optionalTheatre.get();

        show.setMovie(movie);
        show.setTheatre(theatre);

        movie.getShowList().add(show);
        theatre.getShowList().add(show);

        showRepository.save(show);
        return "show is added with showId";
    }
}
