/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author KEVIN
 */
public class Schedule implements Serializable{
    private String id;
    private Timestamp date_time;

    public Schedule() {
    }

    public Schedule(String id, Timestamp date_time) {
        this.id = id;
        this.date_time = date_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", date_time=" + date_time + '}';
    }
    
    
}
