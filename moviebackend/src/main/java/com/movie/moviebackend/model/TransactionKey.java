package com.movie.moviebackend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//Create an embeddable and Serializable class to be used as a key
@Embeddable
public class TransactionKey implements Serializable {

    // Create Ticket ID and Movie Id for key
        @Column(name = "ticket_id")
        Long ticketId;

        @Column(name = "movie_id")
        Long movieId;
//Constructor setting variables
        public TransactionKey(Long ticketId, Long movieId) {
            this.ticketId = ticketId;
            this.movieId = movieId;
        }
// default constructor
        public TransactionKey(){}
}
