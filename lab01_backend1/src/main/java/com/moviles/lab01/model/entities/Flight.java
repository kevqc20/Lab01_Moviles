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
public class Flight implements Serializable{
    String id;
    String route_id;
    String airplaine_id;
    String schedule_id;

    public Flight() {
    }

    public Flight(String id, String route_id, String airplaine_id, String schedule_id) {
        this.id = id;
        this.route_id = route_id;
        this.airplaine_id = airplaine_id;
        this.schedule_id = schedule_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getAirplaine_id() {
        return airplaine_id;
    }

    public void setAirplaine_id(String airplaine_id) {
        this.airplaine_id = airplaine_id;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", route_id=" + route_id + ", airplaine_id=" + airplaine_id + ", schedule_id=" + schedule_id + '}';
    }
    
    
}
