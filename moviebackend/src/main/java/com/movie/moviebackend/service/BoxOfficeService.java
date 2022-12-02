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
    private final MovieService movieService;



    @Autowired
    public BoxOfficeService( BoxOfficeRepo boxOfficeRepo, TicketRepo ticketRepo, MovieRepo movieRepo, MovieService movieService){

        this.boxOfficeRepo =boxOfficeRepo;
        this.ticketRepo = ticketRepo;
        this. movieRepo = movieRepo;
        this.movieService = movieService;
    }


    public List<BoxOffice> getAllBoxOffice(){return boxOfficeRepo.findAll();}


    public BoxOffice getOneTicket (Long ticketId, Long movieID){

        Movie movie = movieRepo.findById(movieID).get();
        Ticket ticket = ticketRepo.findById(ticketId).get();

        Set<BoxOffice> boxo = new HashSet<BoxOffice>();


        for(BoxOffice b:ticket.getBoxOffices()){
            boxo.add(b);
        }
        boolean ticketFound = false;

        for(BoxOffice b: boxo){
            if(b.getMovie().equals(movie)){
                return b;
            }
        }
        if(!ticketFound){
            throw new IllegalStateException("Ticket doesn't exist");
        }
        return null;
    }


    public void purchaseTicketForMovie (Long ticketId, Long movieID, int seatId){

        Movie movie = movieRepo.findById(movieID).get();
        Ticket ticket = ticketRepo.findById(ticketId).get();

        if (ticket.getMovieName() == null) {
            ticket.setMovieName(movie.getTitle());
            ticket.setmId(movie.getId());
        }


        switch(seatId){
            case 1:
                movie.setSeat1(false);
                break;
            case 2:
                movie.setSeat2(false);
                break;
            case 3:
                movie.setSeat3(false);
                break;
            case 4:
                movie.setSeat4(false);
                break;
            case 5:
                movie.setSeat5(false);
                break;
            case 6:
                movie.setSeat6(false);
                break;
            case 7:
                movie.setSeat7(false);
                break;
            case 8:
                movie.setSeat8(false);
                break;
            case 9:
                movie.setSeat9(false);
                break;
            case 10:
                movie.setSeat10(false);
                break;
            default:
                throw new IllegalStateException("Seat with " + seatId + " does not exist.");
        }
        ticket.setSeatNum(seatId);
        BoxOffice b = new BoxOffice(ticket,movie);
        b.setMovie(movie);
        b.setTicket(ticket);

        movie.addTicket(b);
        ticket.addMovie(b);
        boxOfficeRepo.save(b);
    }

    public void cancelTicketForMovie (Long ticketId){
        Ticket ticket = ticketRepo.findById(ticketId).get();
        int seatNum = ticket.getSeatNum();
        Long movieId = ticket.getmId();
        Movie movie = movieRepo.findById(movieId).get();
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
                ticket.setMovieName(null);
                ticket.setmId(null);
            }
        }
        if(!ticketFound){
            throw new IllegalStateException("Ticket doesn't exist");
        }
        movieService.cancelSeat(movieId,seatNum);

    }


}
