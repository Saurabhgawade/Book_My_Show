package com.Accio.BookMyShowProject.Services;

import com.Accio.BookMyShowProject.Models.*;
import com.Accio.BookMyShowProject.Repositories.*;
import com.Accio.BookMyShowProject.dtos.BookTicketdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    public String bookticket(BookTicketdto bookTicketdto){
        Show show=findrightshow(bookTicketdto);

        List<ShowSeat>showSeatList=show.getShowSeatList();

        int totalprice=0;
        for(ShowSeat showSeat:showSeatList){
            if(bookTicketdto.getBookticketlist().contains(showSeat.getSeatNo())){
                showSeat.setAvailable(false);

                totalprice=totalprice+showSeat.getPrice();
            }
        }
        User user=userRepository.findById(bookTicketdto.getUserId()).get();
        Ticket ticket=Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .theatreAddress(show.getTheatre().getAddress())
                .bookSeats(bookTicketdto.getBookticketlist().toString())
                .user(user)
                .show(show)
                .totalprice(totalprice)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRepository.save(ticket);

        return "Ticket has been added successfully";


    }
    public Show findrightshow(BookTicketdto bookTicketdto){
        Movie movie=movieRepository.findMovieBymovieName(bookTicketdto.getMovieName());

        Theatre theatre=theatreRepository.findById(bookTicketdto.getTheaterId()).get();

        Show show=showRepository.findShowByShowDateAndShowTimeAndMovieAndTheatre(bookTicketdto.getShowDate(),bookTicketdto.getShowTime(),movie,theatre);
        return show;
    }

}
