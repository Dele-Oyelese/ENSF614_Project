package com.movie.moviebackend.config;

import com.movie.moviebackend.model.*;
import com.movie.moviebackend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Configuration
public class EntityConfig {




        @Bean
        CommandLineRunner commandLineRunner3(RegisteredUserRepo userRepo, TicketRepo ticketRepo, MovieRepo movieRepo,
                                             BoxOfficeRepo boxOfficeRepo, SeatRepo seatRepo){
            return args -> {

                RegisteredUser user1= new RegisteredUser("John", "Uni Ave", 1231, "John@Daly.com", "123er5");
                RegisteredUser user2= new RegisteredUser("Andrew", "Airdire", 1212231, "Andrew@Daly.com", "abcd");
                RegisteredUser user3= new RegisteredUser("Dhruvi", "Crowfoot", 44423, "Dhruvi@Daly.com", "bhdft");
                RegisteredUser user4= new RegisteredUser("Ryan", "Okotoks", 121231, "Ryan@Daly.com","lopsrtgy");
                RegisteredUser user5= new RegisteredUser("Dele", "WestBrook", 7787, "Dele@Daly.com","kskhdp");

                userRepo.saveAll(List.of(user1,user2,user3,user4,user5));

                Ticket ticket1 = new Ticket("1",10.00,true,null);
                Ticket ticket2 = new Ticket("2",10.00,true,null);
                Ticket ticket3 = new Ticket("3",10.00,true,null);
                Ticket ticket4 = new Ticket("4",10.00,true,null);
                Ticket ticket5 = new Ticket("5",10.00,true,null);
                Ticket ticket6 = new Ticket("6",10.00,true,null);

                ticketRepo.saveAll(List.of(ticket1,ticket2,ticket3,ticket4,ticket5,ticket6));

                Movie movie1 = new Movie("Black Adam", "12:00");
                Movie movie2 = new Movie("Black Adam", "18:00");
                Movie movie3 = new Movie("Black Adam", "20:00");
                Movie movie4 = new Movie("Avengers","12:00");
                Movie movie5 = new Movie("Avengers","16:00");
                Movie movie6 = new Movie("Avengers","20:00");
                Movie movie7 = new Movie("Smile", "12:00");
                Movie movie8 = new Movie("Smile", "18:00");
                Movie movie9 = new Movie("Smile", "20:00");
                Movie movie10 = new Movie("Hannibal","12:00");
                Movie movie11 = new Movie("Hannibal","18:00");
                Movie movie12 = new Movie("Hannibal","20:00");
                Movie movie13 = new Movie("Elf","12:00");
                Movie movie14 = new Movie("Elf","18:00");
                Movie movie15 = new Movie("Elf","20:00");



//                Seat s2 = new Seat(new SeatKey((long)3), movie1);
//                seatRepo.saveAll(List.of(s2));

                movieRepo.saveAll(List.of(movie1,movie2,movie3,movie4,movie5, movie6,movie7,movie8,movie9,movie10,movie11, movie12,movie13,movie14,movie15));







                BoxOffice b1 = new BoxOffice(new TransactionKey((long)1,(long)1),ticket1,movie1);
//
//                new TransactionKey(1L,1L),

                boxOfficeRepo.saveAll(List.of(b1));





            };
        }



}
