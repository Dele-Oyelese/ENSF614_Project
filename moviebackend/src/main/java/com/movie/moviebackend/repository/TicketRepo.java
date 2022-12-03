package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository <Ticket,Long> {

    @Query("SELECT ticket FROM Ticket ticket WHERE ticket.seatId = ?1")
    Optional<Ticket> findTicketBySeatId(Long seatId);

    //@Query("SELECT ticket FROM Ticket ticket WHERE ticket.buyerEmail = ?1")
    Optional<Ticket> findTicketByBuyerEmail(String buyerEmail);
}
