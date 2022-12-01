package com.movie.moviebackend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class TransactionKey implements Serializable {

        @Column(name = "ticket_id")
        Long ticketId;

        @Column(name = "movie_id")
        Long movieId;

        public TransactionKey(Long ticketId, Long movieId) {
            this.ticketId = ticketId;
            this.movieId = movieId;
        }

        public TransactionKey(){}
}
