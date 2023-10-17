package com.example.pinterest;

public class User {

    private String username;
    private String email;
    private String phnum;
    private String password;
    public User(String username,String email,String phnum,String password){
        this.username=username;
        this.email=email;
        this.phnum=phnum;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}