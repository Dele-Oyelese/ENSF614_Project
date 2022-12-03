package com.movie.moviebackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    @Id
    @SequenceGenerator(name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long id;

    private String description;
    private Integer creditCard;
    private String timeDate;
    private String buyerEmail;
    private Double amount;
    private String type;
}
