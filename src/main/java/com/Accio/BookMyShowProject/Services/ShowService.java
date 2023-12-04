package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Enums.SeatType;
import com.Accio.BookMyShowProject.Models.*;
import com.Accio.BookMyShowProject.Repositories.MovieRepository;
import com.Accio.BookMyShowProject.Repositories.ShowRepository;
import com.Accio.BookMyShowProject.Repositories.ShowSeatSeats;
import com.Accio.BookMyShowProject.Repositories.TheatreRepository;
import com.Accio.BookMyShowProject.Transformer.showTransformer;
import com.Accio.BookMyShowProject.dtos.addshowdto;
import com.Accio.BookMyShowProject.dtos.addshowseatsdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowSeatSeats showSeatSeats;

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
    public String addshowseats(addshowseatsdto addshowseatsdto){
        Show show=showRepository.findById(addshowseatsdto.getShowId()).get();

        Theatre theatre=show.getTheatre();

        List<TheatreSeat>theatreSeatList=theatre.getTheatreSeatList();

        List<ShowSeat>showSeatList=new ArrayList<>();

        for(TheatreSeat theatreSeat:theatreSeatList) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theatreSeat.getSeatNo())
                    .seatType(theatreSeat.getSeatType())
                    .isAvailable(true)
                    .foodAttached(false)
                    .show(show)
                    .build();

            if (theatreSeat.getSeatType().equals(SeatType.Classic)) {
                showSeat.setPrice(addshowseatsdto.getPriceofclassicseat());
            }
            else showSeat.setPrice(addshowseatsdto.getPriceofpremiumseat());
            showSeatList.add(showSeat);

        }
        show.setShowSeatList(showSeatList);

        showSeatSeats.saveAll(showSeatList);
        return "added show seats";
    }
}
