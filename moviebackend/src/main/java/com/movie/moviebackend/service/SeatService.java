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
            /* TODO: delete all tickets for this seat */
            seatRepo.deleteById(id);
        }
    }





}