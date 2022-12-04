package com.movie.moviebackend.service;

import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.repository.RegisteredUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service class to create functionality to controller Class
@Service
public class RegisteredUserService {
// set a repo variable
    private final RegisteredUserRepo registeredUserRepo;

    //constructor to initiate repo object
    @Autowired
    public RegisteredUserService(RegisteredUserRepo registeredUserRepo) {
        this.registeredUserRepo = registeredUserRepo;
    }
//Get all registered users in the DB
    public List<RegisteredUser> getAllRegisteredUsers() {
        return registeredUserRepo.findAll();
    }

    // add a Registered user to Database and check if the email is taken
    public void addRegisteredUser(RegisteredUser registeredUser) {

        Optional<RegisteredUser> userEmail = registeredUserRepo.findUserByEmail(registeredUser.getEmail());
        if (userEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        registeredUserRepo.save(registeredUser);
        System.out.println("User Added");

    }

// Update a users information
    @Transactional
    public void updateUser(Long userId, String name, String email) {

        // Check if user exists
        RegisteredUser user = registeredUserRepo.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));

        // make sure name is not null, > 0, and not the same as before
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        // make sure email is not null, >0, and not already in db
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<RegisteredUser> userOptional = registeredUserRepo.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
        registeredUserRepo.save(user);

    }

// Get a user information based on their ID
    public RegisteredUser getUserById(Long userID) {
        Optional<RegisteredUser> userById = registeredUserRepo.findById(userID);
        if (!userById.isPresent()) {
            throw new IllegalStateException("User ID does not exist");
        }
        return userById.get();
    }
// Get user information based on email. involves an existance check.
    public RegisteredUser getUserByEmail(String email) {
    Optional<RegisteredUser> userByEmail = registeredUserRepo.findUserByEmail(email);
    if (!userByEmail.isPresent()) {
        throw new IllegalStateException("User does not exist");
    }
    return userByEmail.get();
}

    public void updateDate(Long userId) {

        // Check if user exists
        RegisteredUser user = registeredUserRepo.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));

        user.setRegDate(LocalDate.now());

        registeredUserRepo.save(user);

    }

    public void deleteUser(Long userId) {
        boolean exists = registeredUserRepo.existsById(userId);
        if(!exists){
            throw new IllegalStateException("userId with id " + userId + " does not exist!");

        }
        registeredUserRepo.deleteById(userId);

    }


}