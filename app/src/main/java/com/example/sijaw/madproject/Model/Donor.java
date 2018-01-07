package com.example.sijaw.madproject.Model;

/**
 * Created by Ameer Hamza on 11/21/2017.
 */

public class Donor {
    String name;
    String email;
    String password;
    String token;

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setToken(String token) {
        this.token = token;
    }

    public Donor(String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;
    }
}