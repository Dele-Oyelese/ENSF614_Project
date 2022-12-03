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
        if(ticket.getBuyerEmail() == null)
        {
            throw new IllegalStateException("No buyer name specified.");
        }

        ticketRepo.save(ticket);
        System.out.println("New ticket #" + ticket.getId() + " added.");
    }

    public Ticket getTicketById(Long ticketId)
    {
        Optional<Ticket> ticket = ticketRepo.findById(ticketId);
        if (ticket.isEmpty())
        {
            throw new IllegalStateException("Ticket #" + ticketId + " does not exist");
        }
        return ticket.get();
    }

    public Ticket getTicketBySeatId(Long seatId)
    {
        Optional<Ticket> ticket = ticketRepo.findTicketBySeatId(seatId);
        if (ticket.isEmpty())
        {
            throw new IllegalStateException("Ticket for seat #" + seatId + " does not exist");
        }
        return ticket.get();
    }

    public Ticket getTicketByBuyerEmail(String buyerEmail)
    {
        Optional<Ticket> ticket = ticketRepo.findTicketByBuyerEmail(buyerEmail);
        if (ticket.isEmpty())
        {
            throw new IllegalStateException("Ticket for email \"" + buyerEmail + "\" does not exist");
        }
        return ticket.get();
    }

    public void deleteTicket(Long id)
    {
        boolean exists = ticketRepo.existsById(id);
        if(!exists)
        {
            throw new IllegalStateException("Ticket #" + id + " does not exist.");
        }
        else
        {
            ticketRepo.deleteById(id);
        }
    }

    public void deleteTicketBySeatId(Long seatId)
    {
        Optional<Ticket> ticket = ticketRepo.findTicketBySeatId(seatId);
        if (ticket.isEmpty())
        {
            throw new IllegalStateException("Ticket for seat #" + seatId + " does not exist");
        }
        else
        {
            ticketRepo.deleteById(ticket.get().getId());
        }
    }
}
