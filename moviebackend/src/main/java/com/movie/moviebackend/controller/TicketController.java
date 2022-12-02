package com.movie.moviebackend.controller;



import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Set Ticket controller pathing
@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    //Constructor. Set autowired and set ticket service
    @Autowired
    public TicketController(TicketService ticketService){this.ticketService=ticketService;}

    //get all tickets in system
    @GetMapping
    public List<Ticket> getTickets()
    {
        return ticketService.getAllTickets();
    }
    //get ticket by id
    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable(required = false) Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }
    //create a new ticket
    @PostMapping
    public void registerNewTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }




}
