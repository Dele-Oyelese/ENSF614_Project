package com.movie.moviebackend.service;

import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.repository.RegisteredUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RegisteredUserService {

    private final RegisteredUserRepo registeredUserRepo;

    @Autowired
    public RegisteredUserService(RegisteredUserRepo registeredUserRepo) {
        this.registeredUserRepo = registeredUserRepo;
    }

    public List<RegisteredUser> getAllRegisteredUsers() {
        return registeredUserRepo.findAll();
    }

    public void addRegisteredUser(RegisteredUser registeredUser) {

        Optional<RegisteredUser> userEmail = registeredUserRepo.findUserByEmail(registeredUser.getEmail());
        if (userEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        registeredUserRepo.save(registeredUser);
        System.out.println("User Added");

    }


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

//    public RegisteredUserRepo getUserByEmail(String email) {
//        Optional<RegisteredUser> userByEmail = registeredUserRepo.findUserByEmail(email);
//        if (!userByEmail.isPresent()) {
//            throw new IllegalStateException("User does not exist");
//        }
//        return (RegisteredUserRepo) userByEmail.get();
//    }

    public RegisteredUser getUserById(Long userID) {
        Optional<RegisteredUser> userById = registeredUserRepo.findById(userID);
        if (!userById.isPresent()) {
            throw new IllegalStateException("User ID does not exist");
        }
        return userById.get();
    }

    public RegisteredUser getUserByEmail(String email) {
        Optional<RegisteredUser> userByEmail = registeredUserRepo.findUserByEmail(email);
        if (!userByEmail.isPresent()) {
            throw new IllegalStateException("User does not exist");
        }
        return userByEmail.get();
    }
}