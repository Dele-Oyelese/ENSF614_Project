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
    public TicketController(TicketService ticketService){this.ticketService=ticketService;}

    @GetMapping("/getAll")
    public List<Ticket> getTickets()
    {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable(required = false) Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @PostMapping
    public void registerNewTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }




}
