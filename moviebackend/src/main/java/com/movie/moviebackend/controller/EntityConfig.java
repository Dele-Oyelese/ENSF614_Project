package com.movie.moviebackend.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.Seat;
import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.repository.MovieRepo;
import com.movie.moviebackend.repository.RegisteredUserRepo;
import com.movie.moviebackend.repository.SeatRepo;
import com.movie.moviebackend.repository.TicketRepo;



@Configuration
public class EntityConfig {




        @Bean
        CommandLineRunner commandLineRunner3(RegisteredUserRepo userRepo){
            return args -> {

                RegisteredUser user1= new RegisteredUser("John", "Uni Ave", 1231, "John@Daly.com");
                RegisteredUser user2= new RegisteredUser("Andrew", "Airdire", 1212231, "Andrew@Daly.com");
                RegisteredUser user3= new RegisteredUser("Dhruvi", "Crowfoot", 44423, "Dhruvi@Daly.com");
                RegisteredUser user4= new RegisteredUser("Ryan", "Okotoks", 121231, "Ryan@Daly.com");
                RegisteredUser user5= new RegisteredUser("Dele", "WestBrook", 7787, "Dele@Daly.com");

                userRepo.saveAll(List.of(user1,user2,user3,user4,user5));




            };
        }



}
