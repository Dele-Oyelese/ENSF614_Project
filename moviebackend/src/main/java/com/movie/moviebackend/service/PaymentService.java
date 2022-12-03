package com.movie.moviebackend.service;

import com.movie.moviebackend.model.Payment;
import com.movie.moviebackend.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    /* Get all movies in the database */
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }
}