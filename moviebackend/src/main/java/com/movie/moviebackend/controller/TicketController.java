package com.movie.moviebackend.controller;


import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    /* Show all tickets */
    @GetMapping("/getAll")
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

    /* Find a ticket based on the buyer's name */
    @GetMapping("/buyer/{buyerName}")
    public Ticket getTicketByBuyerName(@PathVariable("buyerName") String buyerName)
    {
        return ticketService.getTicketByBuyerName(buyerName);
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
}
