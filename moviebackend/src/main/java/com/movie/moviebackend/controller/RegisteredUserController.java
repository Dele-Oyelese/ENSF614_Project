package com.movie.moviebackend.controller;


import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class RegisteredUserController {

    private final RegisteredUserService userService;

    @Autowired
    public RegisteredUserController(RegisteredUserService userService)
    {
        this.userService = userService;
    }

    /* Get all registered users in the table */
    /* TODO: do NOT display their passwords */
    @GetMapping
    public List<RegisteredUser> getUsers()
    {
        return userService.getAllRegisteredUsers();
    }

    /* Get the user with the given ID */
    @GetMapping("/{userId}")
    public RegisteredUser getUser(@PathVariable(required = false) Long userId)
    {
        return userService.getUserById(userId);
    }

    /* Get the user with the given email */
    @GetMapping("Email/{email}")
    public RegisteredUser getUser(@PathVariable(required = false) String email)
    {
        return userService.getUserByEmail(email);
    }

    /* Add a new user by passing a JSON format user */
    @PostMapping
    public void registerNewUser(@RequestBody RegisteredUser user)
    {
        userService.addRegisteredUser(user);
    }

    /* Update a user by passing the required parameters */
    @PutMapping(path="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        userService.updateUser(userId,name,email);
    }
}
