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
public class Ticket implements Serializable{
    private String id;
    private String flight_id;
    private double price;
    private double discount;
    private int seat;
    private String user_username;

    public Ticket() {
    }

    public Ticket(String id, String flight_id, double price, double discount, int seat, String user_username) {
        this.id = id;
        this.flight_id = flight_id;
        this.price = price;
        this.discount = discount;
        this.seat = seat;
        this.user_username = user_username;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }



    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", flight_id=" + flight_id + ", price=" + price + ", discount=" + discount + ", seat=" + seat + "username"+user_username+ '}';
    }
    
    
}
