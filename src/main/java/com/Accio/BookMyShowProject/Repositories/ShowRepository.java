package com.Accio.BookMyShowProject.Repositories;

import com.Accio.BookMyShowProject.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
}
