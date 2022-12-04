package com.movie.moviebackend.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.moviebackend.extraCode.SeatRepo;
import com.movie.moviebackend.model.*;
import com.movie.moviebackend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

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
                RegisteredUser user5= new RegisteredUser("Dele", "WestBrook", 7787, "Dele@Daly.com","kskhdp", LocalDate.of(1990,Month.JANUARY,5));

                userRepo.saveAll(List.of(user1,user2,user3,user4,user5));

                Ticket ticket1 = new Ticket(0,10.00,false,null);
                Ticket ticket2 = new Ticket(0,10.00,false,null);
                Ticket ticket3 = new Ticket(0,10.00,false,null);
                Ticket ticket4 = new Ticket(0,10.00,false,null);
                Ticket ticket5 = new Ticket(0,10.00,false,null);
                Ticket ticket6 = new Ticket(0,10.00,false,null);

                ticketRepo.saveAll(List.of(ticket1,ticket2,ticket3,ticket4,ticket5,ticket6));

                LocalDateTime d1 =  LocalDateTime.now();

                Movie movie1 = new Movie("Black Adam", d1);
                Movie movie2 = new Movie("Black Adam", d1);
                Movie movie3 = new Movie("Black Adam", d1);
                Movie movie4 = new Movie("Avengers",d1);
                Movie movie5 = new Movie("Avengers",d1);
                Movie movie6 = new Movie("Avengers",d1);
                Movie movie7 = new Movie("Smile", d1);
                Movie movie8 = new Movie("Smile", d1);
                Movie movie9 = new Movie("Smile", d1);
                Movie movie10 = new Movie("Hannibal",d1);
                Movie movie11 = new Movie("Hannibal",d1);
                Movie movie12 = new Movie("Hannibal",d1);
                Movie movie13 = new Movie("Elf",d1);
                Movie movie14 = new Movie("Elf",d1);
                Movie movie15 = new Movie("Elf",d1);



//                Seat s2 = new Seat(new SeatKey((long)3), movie1);
//                seatRepo.saveAll(List.of(s2));

                movieRepo.saveAll(List.of(movie1,movie2,movie3,movie4,movie5, movie6,movie7,movie8,movie9,movie10,movie11, movie12,movie13,movie14,movie15));







//                BoxOffice b1 = new BoxOffice(new TransactionKey((long)1,(long)1),ticket1,movie1);
//                BoxOffice b2 = new BoxOffice(new TransactionKey((long)2,(long)2),ticket2,movie1);
////                new TransactionKey(1L,1L),
//
//                boxOfficeRepo.saveAll(List.of(b1,b2));





            };
        }



}
