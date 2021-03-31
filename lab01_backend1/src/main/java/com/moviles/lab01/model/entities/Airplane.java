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

public class Airplane implements Serializable{
    private String id;
    private int year;
    private String model;
    private String brand;
    private boolean type;
    private int cant_max;

    public Airplane(String id, int year, String model, String brand, boolean type, int cant_max) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.cant_max = cant_max;
    }

    public Airplane() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getCant_max() {
        return cant_max;
    }

    public void setCant_max(int cant_max) {
        this.cant_max = cant_max;
    }

    @Override
    public String toString() {
        return "Airplane{" + "id=" + id + ", year=" + year + ", model=" + model + ", brand=" + brand + ", type=" + type + ", cant_max=" + cant_max + '}';
    }
    
    
}
