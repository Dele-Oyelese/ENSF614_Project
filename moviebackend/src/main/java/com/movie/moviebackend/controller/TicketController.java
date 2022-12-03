package com.movie.moviebackend.controller;


import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.model.Seat;
import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.service.MovieService;
import com.movie.moviebackend.service.SeatService;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {

    /* Ticket service for accessing the table of tickets */
    private final TicketService ticketService;

    /* ? Seat service for accessing the seats */
    private final SeatService seatService;

    /* ? Movie service for accessing the movies */
    private final MovieService movieService;

    @Autowired
    public TicketController(
            TicketService ticketService,
            SeatService seatService,
            MovieService movieService
    )
    {
        this.ticketService = ticketService;
        this.seatService = seatService;
        this.movieService = movieService;
    }

    /* Show all tickets */
    @GetMapping
    public List<Ticket> getTickets()
    {
        return ticketService.getAllTickets();
    }

    /* Get the ticket with the given ID */
    @GetMapping("{id}")
    public Ticket getTicket(@PathVariable(required = false) Long id)
    {
        return ticketService.getTicketById(id);
    }

    /* Get the ticket for the given seat ID */
    @GetMapping("/seat/{seatId}")
    public Ticket getTicketBySeatId(@PathVariable("seatId") Long seatId)
    {
        return ticketService.getTicketBySeatId(seatId);
    }

    /* Find a ticket based on the buyer's email */
    @GetMapping("/buyer/{buyerEmail}")
    public Ticket getTicketByBuyerName(@PathVariable("buyerName") String buyerEmail)
    {
        return ticketService.getTicketByBuyerEmail(buyerEmail);
    }

    /* Delete ticket by id */
    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable("id") Long id)
    {
        ticketService.deleteTicket(id);
    }

    /* Delete ticket for the given seat ID */
    @DeleteMapping("/seat/{seatId}")
    public void deleteTicketBySeatId(@PathVariable("seatId") Long seatId)
    {
        ticketService.deleteTicketBySeatId(seatId);
    }

    /* Add a new ticket to the table by passing JSON format ticket object */
    @PostMapping("/add")
    public void registerNewTicket(@RequestBody Ticket ticket)
    {
        ticketService.addNewTicket(ticket);
    }

    /* Purchase a ticket based on the seat id and buyer name (infers the movie id) */
    @PostMapping("/purchase/{seatId}")
    public void purchaseTicket(
            @PathVariable("seatId") Long seatId,
            @RequestParam(required = true) String buyerEmail,
            @RequestParam(required = true) Long creditCard
            //@PathVariable("buyerName") String buyerEmail
    )
    {
        /* ERROR check: null buyer email? */
        /* TODO */

        /* Get the seat matching the id, if any */
        Seat seat = seatService.getSeatById(seatId);
        seat.setAvailable(false);

        /* Get the movie */
        Movie movie = movieService.getMovieById(seat.getMovieId());

        /* Create a new payment for the ticket */
        /* TODO: payment */

        /* What does a ticket need?
            -> id
            -> seat id
            -> payment id
            -> seatNum
            -> movieName
            -> movieTime
            -> pricePaid
            -> buyerEmail
         */
        Ticket newTicket = new Ticket(
                seat.getId(),
                0L, /* TODO: payment id */
                seat.getSeatNum(),
                movie.getTitle(),
                movie.getShowTime(),
                seat.getPrice(),
                buyerEmail
        );

        /* Save the ticket to the database */
        ticketService.addNewTicket(newTicket);
    }
}
