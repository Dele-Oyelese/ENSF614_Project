package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @SequenceGenerator(name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private Long id;
    private Long seatId;
    private double pricePaid;
    private String buyerName;

    public Ticket(){}

    public Ticket(Long id, Long seatId, Double pricePaid, String buyerName){
        this.id = id;
        this.seatId = seatId;
        this.pricePaid = pricePaid;
        this.buyerName = buyerName;
    }

    public Ticket(Long seatId, Double pricePaid, String buyerName){
        this.seatId = seatId;
        this.pricePaid = pricePaid;
        this.buyerName = buyerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

}
