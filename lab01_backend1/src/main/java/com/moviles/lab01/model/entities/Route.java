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
public class Route implements Serializable{
    private String id;
    private String origin;
    private String destination;
    private String duration;

    public Route() {
    }

    public Route(String id, String origin, String destination, String duration) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Route{" + "id=" + id + ", origin=" + origin + ", destination=" + destination + ", duration=" + duration + '}';
    }
    
    
}
