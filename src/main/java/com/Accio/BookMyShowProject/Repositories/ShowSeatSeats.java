package com.Accio.BookMyShowProject.Repositories;

import com.Accio.BookMyShowProject.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatSeats extends JpaRepository<ShowSeat,Integer> {
}
