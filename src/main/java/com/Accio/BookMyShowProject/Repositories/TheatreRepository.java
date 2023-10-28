package com.Accio.BookMyShowProject.Repositories;

import com.Accio.BookMyShowProject.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
}
