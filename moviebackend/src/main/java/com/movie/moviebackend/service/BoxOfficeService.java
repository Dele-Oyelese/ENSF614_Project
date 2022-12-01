package com.movie.moviebackend.service;

import com.movie.moviebackend.model.BoxOffice;
import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.repository.BoxOfficeRepo;
import com.movie.moviebackend.repository.MovieRepo;
import com.movie.moviebackend.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BoxOfficeService {

    private final BoxOfficeRepo boxOfficeRepo;
    private final TicketRepo ticketRepo;
    private final MovieRepo movieRepo;



    @Autowired
    public BoxOfficeService( BoxOfficeRepo boxOfficeRepo, TicketRepo ticketRepo, MovieRepo movieRepo){

        this.boxOfficeRepo =boxOfficeRepo;
        this.ticketRepo = ticketRepo;
        this. movieRepo = movieRepo;
    }


    public List<BoxOffice> getAllBoxOffice(){return boxOfficeRepo.findAll();}

    public void purchaseTicketForMovie (Long ticketId, Long movieID){

        Movie movie = movieRepo.findById(movieID).get();
        Ticket ticket = ticketRepo.findById(ticketId).get();

//        if (ticket.getMovieName() == null) {
//            ticket.setMovieName(movie.getTitle());
//        }

        BoxOffice b = new BoxOffice(ticket,movie);
        b.setMovie(movie);
        b.setTicket(ticket);

        movie.addTicket(b);
        ticket.addMovie(b);
        boxOfficeRepo.save(b);
    }

    public void cancelTicketForMovie (Long ticketId, Long movieID){

        Movie movie = movieRepo.findById(movieID).get();
        Ticket ticket = ticketRepo.findById(ticketId).get();

        Set<BoxOffice> boxo = new HashSet<BoxOffice>();


        for(BoxOffice b:ticket.getBoxOffices()){
            boxo.add(b);
        }
        boolean ticketFound = false;

        for(BoxOffice b: boxo){
            if(b.getMovie().equals(movie)){
                ticket.removeMovie(b);
                movie.removeTicket(b);
                ticketFound = true;
                boxOfficeRepo.delete(b);
            }
        }
        if(!ticketFound){
            throw new IllegalStateException("Ticket doesn't exist");
        }
    }


}
