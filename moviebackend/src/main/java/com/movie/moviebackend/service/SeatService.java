package com.movie.moviebackend.service;

import com.movie.moviebackend.model.Seat;
import com.movie.moviebackend.repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepo seatRepo;

    @Autowired
    public SeatService(SeatRepo seatRepo)
    {
        this.seatRepo = seatRepo;
    }

    /* Get all seats in the database */
    public List<Seat> getAllSeats()
    {
        return seatRepo.findAll();
    }

    /* Get all seats for a given movie */
    /* TODO: do dis */

    /* Add a new seat */
    public void addNewSeat(Seat seat)
    {
        /* Forbidden to add a seat with identical ID */
        Optional<Seat> seatById = seatRepo.findById(seat.getId());

        if(seatById.isPresent())
        {
            throw new IllegalStateException("Seat already exists.");
        }

        seatRepo.save(seat);
    }

    /* Delete a seat from the database */
    /* Not intended to be called from the seat API */
    public void deleteSeat(Long id)
    {
        boolean exists = seatRepo.existsById(id);
        if(!exists)
        {
            throw new IllegalStateException("Seat with id " + id + " does not exist.");
        }
        else
        {
            seatRepo.deleteById(id);
        }
    }

    @Transactional
    public void updateSeat(Long id, Long movieId, String seatNum, double price, boolean available)
    {
        Seat seat = seatRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("Seat with id " + id + " does not exist.")
        );

        /* Reassign the seat to a new movie ID (reschedule, etc) */
        if(movieId != null && !Objects.equals(seat.getMovieId(), movieId))
        {
            /* TODO: check to see if the movie exists in the movie table */
            /* Throw error if so */
            seat.setMovieId(movieId);
        }

        /* Change the seat number */
        if(seatNum != null && seatNum.length() > 0 && !Objects.equals(seat.getSeatNum(), seatNum))
        {
            /* TODO: check to see if this seat already exists */
            /* Throw error if so */
            seat.setSeatNum(seatNum);
        }

        /* Change the price of the seat (hand rubbing intensifies) */
        if(price != 0 && !Objects.equals(seat.getPrice(), price))
        {
            /* TODO: check to see if this seat already exists */
            /* Throw error if so */
            seat.setPrice(price);
        }

        /* Change the availability of the seat (booked, etc.) */
        if(!Objects.equals(seat.isAvailable(), available))
        {
            seat.setAvailable(available);
        }
    }
}