package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Initiate Repository as JPA Repositoru
@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
