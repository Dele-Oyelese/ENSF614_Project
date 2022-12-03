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

    /* Define this as a foreign key */
    /* TODO: cascade delete */
    private Long seatId;

    /* Define this as a foreign key */
    /* TODO: cascade delete */
    private long paymentId;
    private String seatNum;
    private String movieName;
    private String movieTime;
    private double pricePaid;
    private String buyerEmail;

    public Ticket(){}

    public Ticket(
            Long id,
            Long seatId,
            Long paymentId,
            String seatNum,
            String movieName,
            String movieTime,
            double pricePaid,
            String buyerEmail
    )
    {
        this.id = id;
        this.seatId = seatId;
        this.paymentId = paymentId;
        this.seatNum = seatNum;
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.pricePaid = pricePaid;
        this.buyerEmail = buyerEmail;
    }

    public Ticket(
            Long seatId,
            Long paymentId,
            String seatNum,
            String movieName,
            String movieTime,
            double pricePaid,
            String buyerEmail
    )
    {
        this.seatId = seatId;
        this.paymentId = paymentId;
        this.seatNum = seatNum;
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.pricePaid = pricePaid;
        this.buyerEmail = buyerEmail;
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

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }
}
