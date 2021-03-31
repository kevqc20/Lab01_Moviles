/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author KEVIN
 */
public class Passanger implements Serializable{
    private String user_username;
    private String name;
    private String lastname;
    private String email;
    private Date dob;
    private String address;
    private int work_phone;
    private int cell_phone;
    private int ticket_id;

    public Passanger() {
    }

    public Passanger(String user_username, String name, String lastname, String email, Date dob, String address, int work_phone, int cell_phone, int ticket_id) {
        this.user_username = user_username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.work_phone = work_phone;
        this.cell_phone = cell_phone;
        this.ticket_id = ticket_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(int work_phone) {
        this.work_phone = work_phone;
    }

    public int getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(int cell_phone) {
        this.cell_phone = cell_phone;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    @Override
    public String toString() {
        return "Passanger{" + "user_username=" + user_username + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", dob=" + dob + ", address=" + address + ", work_phone=" + work_phone + ", cell_phone=" + cell_phone + ", ticket_id=" + ticket_id + '}';
    }
    
    
}
