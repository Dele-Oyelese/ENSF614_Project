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

//Service class to create functionality to controller Class
@Service
public class BoxOfficeService {

    //Create repo variables and Movie service object
    private final BoxOfficeRepo boxOfficeRepo;
    private final TicketRepo ticketRepo;
    private final MovieRepo movieRepo;
    private final MovieService movieService;


// Initate repos and services
    @Autowired
    public BoxOfficeService( BoxOfficeRepo boxOfficeRepo, TicketRepo ticketRepo, MovieRepo movieRepo, MovieService movieService){

        this.boxOfficeRepo =boxOfficeRepo;
        this.ticketRepo = ticketRepo;
        this. movieRepo = movieRepo;
        this.movieService = movieService;
    }

//List all boxOffice Objects
    public List<BoxOffice> getAllBoxOffice(){return boxOfficeRepo.findAll();}

// get one specific Ticket and its boxOffice object
    public BoxOffice getOneTicket (Long ticketId){
        Ticket ticket = ticketRepo.findById(ticketId).get();
        Long movieId = ticket.getmId();
        Movie movie = movieRepo.findById(movieId).get();


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

// Purchase a ticket based on Movie Id and Seat Number and buyer status
    public void purchaseTicketForMovie (Long ticketId, Long movieID, int seatId,int ruFlag){
        Movie movie = movieRepo.findById(movieID).get();
        Ticket ticket = ticketRepo.findById(ticketId).get();

        if (ticket.getMovieName() == null) {
            ticket.setMovieName(movie.getTitle());
            ticket.setmId(movie.getId());
        }


        switch(seatId){
            case 1:
                if(movie.isSeat1() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat1(false);
                break;
            case 2:
                if(movie.isSeat2() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat2(false);
                break;
            case 3:
                if(movie.isSeat3() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat3(false);
                break;
            case 4:
                if(movie.isSeat4() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat4(false);
                break;
            case 5:
                if(movie.isSeat5() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat5(false);
                break;
            case 6:
                if(movie.isSeat6() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat6(false);
                break;
            case 7:
                if(movie.isSeat7() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat7(false);
                break;
            case 8:
                if(movie.isSeat8() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat8(false);
                break;
            case 9:
                if(movie.isSeat9() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat9(false);
                break;
            case 10:
                if(movie.isSeat10() == false){
                    throw new IllegalStateException("Seat with id " + seatId + " is taken");
                }
                movie.setSeat10(false);
                break;
            default:
                throw new IllegalStateException("Seat with " + seatId + " does not exist.");
        }
        ticket.setSeatNum(seatId);
        if(ruFlag == 1){
           ticket.setBuyerStatus(true);
        }
        else{
            ticket.setBuyerStatus(false);
        }

        BoxOffice b = new BoxOffice(ticket,movie);
        b.setMovie(movie);
        b.setTicket(ticket);

        movie.addTicket(b);
        ticket.addMovie(b);
        boxOfficeRepo.save(b);
    }

    //Cancel Ticket for a movie based on the ticketId
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
        ticket.setMovieName("");
        ticket.setSeatNum(0);
        ticket.setmId(0L);
        ticket.setBuyerStatus(false);

        movieService.cancelSeat(movieId,seatNum);

    }


}
