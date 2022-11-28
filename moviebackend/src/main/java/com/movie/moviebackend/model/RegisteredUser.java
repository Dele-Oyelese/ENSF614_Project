package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name ="user")
public class RegisteredUser {
    @Id
    @SequenceGenerator(name = "RU_sequence",
            sequenceName = "RU_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RU_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String email;
    private int creditNum;


    RegisteredUser(){
    }

    public RegisteredUser(Long id, String name, String address, int creditNum,  String email ){
        this.id=id;
        this.address=address;
        this.name =name;
        this.creditNum=creditNum;
        this.email=email;
    }
    public RegisteredUser(String name, String address, int creditNum, String email ){
        this.address=address;
        this.name =name;
        this.creditNum=creditNum;
        this.email=email;
    }

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
}
