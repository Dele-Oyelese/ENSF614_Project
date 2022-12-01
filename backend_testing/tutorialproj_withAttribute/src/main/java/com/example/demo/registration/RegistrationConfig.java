package com.example.demo.registration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;

@Configuration
public class RegistrationConfig {

    @Bean
    CommandLineRunner commandLineRunner3(CourseRepository courseRepository, StudentRepository studentRepository, RegistrationRepository registrationRepository){
        return args -> {

            Course ensf609 = new Course("ENSF609");
            Course ensf608 = new Course("ENSF608");
            Course ensf610 = new Course("ENSF610");
            Course ensf611 = new Course("ENSF611");
            Course ensf612 = new Course("ENSF612");
            Course ensf614 = new Course("ENSF614");
            Course ensf613 = new Course("ENSF613");

            courseRepository.saveAll(List.of(ensf608,ensf609,ensf610,ensf611,ensf612,ensf613,ensf614));

            Student nick = new Student(
                "Nick",
                "testemail@gmail.com",
                LocalDate.of(2000,Month.JANUARY,5),"1234");

            Student alex = new Student(
                        "Alex",
                        "alex@gmail.com",
                        LocalDate.of(1990,Month.JANUARY,5),"5678");

            studentRepository.saveAll(List.of(nick, alex));


            Registration r1 = new Registration(new CourseGradeKey((long) 1, (long) 1), nick,ensf608,0);
            Registration r2 = new Registration(new CourseGradeKey((long) 2, (long) 1), nick,ensf609,0);            
            Registration r3 = new Registration(new CourseGradeKey((long) 3, (long) 1), nick,ensf610,0);
            Registration r4 = new Registration(new CourseGradeKey((long) 4, (long) 1), nick,ensf611,0);
            Registration r5 = new Registration(new CourseGradeKey((long) 5, (long) 1), nick,ensf612,0);
            Registration r6 = new Registration(new CourseGradeKey((long) 6, (long) 1), nick,ensf613,0);

            registrationRepository.saveAll(List.of(r1,r2,r3,r4,r5,r6));

        };
    }
    
}
