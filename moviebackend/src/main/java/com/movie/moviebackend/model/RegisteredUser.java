package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

//Create registered entity table
@Entity
@Table(name ="user")
public class RegisteredUser {

    //Auto Generate ID
    @Id
    @SequenceGenerator(name = "RU_sequence",
            sequenceName = "RU_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RU_sequence"
    )
    private Long id;

    // Initiate String Variables
    private String name;
    private String address;
    private String email;

    //Initate Registration date using LocalDate to JSON
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate regDate;
// Add Password and CreditNum
    private String password;
    private int creditNum;

// Default Constructor
    RegisteredUser(){
    }
// Constructor with ID
    public RegisteredUser(Long id, String name, String address, int creditNum,  String email, String password ){
        this.id=id;
        this.address=address;
        this.name =name;
        this.creditNum=creditNum;
        this.email=email;
        this.password = password;
        this.regDate = LocalDate.now();
    }

    //Constructor without id and no reg date set to current date
    public RegisteredUser(String name, String address, int creditNum, String email, String password ){
        this.address=address;
        this.name =name;
        this.creditNum=creditNum;
        this.email=email;
        this.password = password;
        this.regDate = LocalDate.now();
    }
// Constructor no id With Registration date
    public RegisteredUser(String name, String address, int creditNum, String email, String password, LocalDate regDate ){
        this.address=address;
        this.name =name;
        this.creditNum=creditNum;
        this.email=email;
        this.password = password;
        this.regDate = regDate;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(int creditNum) {
        this.creditNum = creditNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
