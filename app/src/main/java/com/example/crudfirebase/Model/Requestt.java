package com.example.crudfirebase.Model;

import java.io.Serializable;

public class Requestt implements Serializable {
    public String username;
    public String password;
    public String nomor;

    private String key;

    public Requestt() {
    }

    public Requestt(String username, String password, String nomor ) {
        this.username = username;
        this.password = password;
        this.nomor = nomor;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toString(){
        return " " + username + "\n" +
                " "+ password + "\n" +
                " "+nomor;
    }
}
