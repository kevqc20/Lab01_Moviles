/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model.entities;

import java.io.Serializable;

/**
 *
 * @author KEVIN
 */
public class User implements Serializable{
    private String username;
    private String password;
    private boolean rol;

    public User() {
    }

    public User(String username, String password, boolean rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
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

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", rol=" + rol + '}';
    }
    
    
}
