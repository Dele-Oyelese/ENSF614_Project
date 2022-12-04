package com.movie.moviebackend.service;

import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service class to create functionality to controller Class
@Service
public class MovieService {

    //Create athe Movie Repositry for services
    private final MovieRepo movieRepo;

    //Constructor to and assign repository
    @Autowired
    public MovieService(MovieRepo movieRepo)
    {
        this.movieRepo = movieRepo;
    }

    /* Get all movies in the database */
    public List<Movie> getAllMovies()
    {
        return movieRepo.findAll();
    }


    /* Add a new movie to the database */
    public void addNewMovie(Movie movie)
    {
        Optional<Movie> movieById = movieRepo.findById(movie.getId());

        if(movieById.isPresent())
        {
            throw new IllegalStateException("Movie already exists.");
        }

        movieRepo.save(movie);
    }

    /* Delete a movie from the database */
    public void deleteMovie(Long id)
    {
        boolean exists = movieRepo.existsById(id);
        if(!exists)
        {
            throw new IllegalStateException("Movie with id " + id + " does not exist.");
        }
        else
        {
            movieRepo.deleteById(id);
        }
    }

    //Switch availabilty to unavailable when purchased
    @Transactional
    public void purchaseSeat(Long id, int seatNum) {

        boolean exists = movieRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Movie with id " + id + " does not exist.");
        } else {
            Movie movie = movieRepo.findById(id).get();


            switch(seatNum){
                case 1:
                    if(movie.isSeat1() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat1(false);
                    break;
                case 2:
                    if(movie.isSeat2() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat2(false);
                    break;
                case 3:
                    if(movie.isSeat3() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat3(false);
                    break;
                case 4:
                    if(movie.isSeat4() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat4(false);
                    break;
                case 5:
                    if(movie.isSeat5() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat5(false);
                    break;
                case 6:
                    if(movie.isSeat6() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat6(false);
                    break;
                case 7:
                    if(movie.isSeat7() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat7(false);
                    break;
                case 8:
                    if(movie.isSeat8() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat8(false);
                    break;
                case 9:
                    if(movie.isSeat9() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat9(false);
                    break;
                case 10:
                    if(movie.isSeat10() == false){
                        throw new IllegalStateException("Seat with id " + seatNum + " is taken");
                    }
                    movie.setSeat10(false);
                    break;
                default:
                    throw new IllegalStateException("Seat with " + seatNum + " does not exist.");
            }


        }
    }
    //Switch availabilty to available when cancelled
    @Transactional
    public void cancelSeat(Long id, int seatNum) {

        boolean exists = movieRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Movie with id " + id + " does not exist.");
        } else {
            Movie movie = movieRepo.findById(id).get();


            switch(seatNum){
                case 1:
                    movie.setSeat1(true);
                    break;
                case 2:
                    movie.setSeat2(true);
                    break;
                case 3:
                    movie.setSeat3(true);
                    break;
                case 4:
                    movie.setSeat4(true);
                    break;
                case 5:
                    movie.setSeat5(true);
                    break;
                case 6:
                    movie.setSeat6(true);
                    break;
                case 7:
                    movie.setSeat7(true);
                    break;
                case 8:
                    movie.setSeat8(true);
                    break;
                case 9:
                    movie.setSeat9(true);
                    break;
                case 10:
                    movie.setSeat10(true);
                    break;
                default:
                    throw new IllegalStateException("Seat " + seatNum + " does not exist.");
            }


        }
    }

    /* Update a movie in the database */
    @Transactional
    public void updateMovie(Long id, String title, String showTime)
    {
        Movie movie = movieRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("Movie with id " + id + " does not exist.")
        );

        /* Check to see if the title is acceptable */
        /* All movies with this title will be changed. */
        if(title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title) )
        {
            movie.setTitle(title);
        }

        /* Check to see if the show time is acceptable */
        /* Only the movie with matching title and showtime will be changed. */

    }

    //get the movie by title
    public Movie getMovieByTitle(String title) {
        Optional<Movie> movieTile = movieRepo.findMovieByTitle(title);
        if (!movieTile.isPresent()) {
            throw new IllegalStateException("Title does not exist");
        }
        return movieTile.get();
    }

}
