package com.movie.moviebackend.service;

import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo)
    {
        this.ticketRepo = ticketRepo;
    }

    public List<Ticket> getAllTickets()
    {
        return ticketRepo.findAll();
    }

    public void  addNewTicket(Ticket ticket)
    {
        Optional<Ticket> ticketId = ticketRepo.findById(ticket.getId());

        if (ticketId.isPresent())
        {
            throw new IllegalStateException("Ticket already exists.");
        }

        ticketRepo.save(ticket);
        System.out.println("New ticket #" + ticket.getId() + " added.");
    }

    public Ticket getTicketById(Long ticketId)
    {
        Optional<Ticket> ticketById = ticketRepo.findById(ticketId);
        if (!ticketById.isPresent())
        {
            throw new IllegalStateException("Ticket #" + ticketId + " does not exist");
        }
        return ticketById.get();
    }
}
