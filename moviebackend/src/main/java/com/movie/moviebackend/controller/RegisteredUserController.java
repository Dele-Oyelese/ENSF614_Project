package com.movie.moviebackend.controller;


import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Set pathing for registered users
@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class RegisteredUserController {

    private final RegisteredUserService userService;
    //Constructor set autowire and serivce object
    @Autowired
    public RegisteredUserController(RegisteredUserService userService) {
        this.userService = userService;
    }
//get mapping for all users
    @GetMapping
    public List<RegisteredUser> getUsers(){
        return userService.getAllRegisteredUsers();
    }
//  get users by ID
    @GetMapping("/{userId}")
    public RegisteredUser getUser(@PathVariable(required = false) Long userId) {
        return userService.getUserById(userId);
    }
//Get users by email
    @GetMapping("Email/{email}")
    public RegisteredUser getUser(@PathVariable(required = false) String email) {
        return userService.getUserByEmail(email);
    }
//Create a new user
    @PostMapping
    public void registerNewUser(@RequestBody RegisteredUser user){
        userService.addRegisteredUser(user);
    }

    // Update a users information
    @PutMapping(path="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userService.updateUser(userId,name,email);
    }

    @PutMapping(path="updateDate/{userId}")
    public void updateDate(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userService.updateDate(userId);
    }




}
