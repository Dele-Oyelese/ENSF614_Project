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
    public RegisteredUserController(RegisteredUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<RegisteredUser> getUsers(){
        return userService.getAllRegisteredUsers();
    }

    @GetMapping("/{userId}")
    public RegisteredUser getUser(@PathVariable(required = false) Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("Email/{email}")
    public RegisteredUser getUser(@PathVariable(required = false) String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void registerNewUser(@RequestBody RegisteredUser user){
        userService.addRegisteredUser(user);
    }

    @PutMapping(path="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userService.updateUser(userId,name,email);
    }




}
