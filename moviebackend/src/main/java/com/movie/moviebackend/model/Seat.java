package com.movie.moviebackend.model;


import javax.persistence.*;

@Entity
@Table
public class Seat {

    @Id
    @SequenceGenerator(name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;
    @Transient
    private boolean availability;



    public Seat(){
        this.availability= true;
    }
    public Seat(Long id, boolean aval){
        this.id =id;
        this.availability =aval;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }



}
