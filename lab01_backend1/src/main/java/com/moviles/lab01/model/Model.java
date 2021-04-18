/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model;

import java.io.Serializable;

/**
 *
 * @author KEVIN
 */
public class Model implements Serializable{
    /*Todos los DAOs*/
    
    private static Model model_instance = null;

    public Model() {
        /*Todos los DAOs*/
        
    }
    
    public static Model getInstance(){
        if(model_instance == null)
            model_instance = new Model();
        return model_instance;
    }
    
    
    
}
