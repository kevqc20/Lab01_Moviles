/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model;

import com.moviles.lab01.dao.services.serviceInsert;
import com.moviles.lab01.dao.services.serviceList;
import com.moviles.lab01.dao.services.serviceLogginUser;
import com.moviles.lab01.dao.services.serviceSearch;
import com.moviles.lab01.dao.services.serviceUpdate;
import java.io.Serializable;

/**
 *
 * @author KEVIN
 */
public class Model implements Serializable{
    /*Todos los services*/
    private final serviceList serviceList;
    private final serviceLogginUser serviceLogginUser;
    private final serviceSearch serviceSearch;
    private final serviceUpdate serviceUpdate;
    private final serviceInsert serviceInsert;
    
    private static Model model_instance = null;

    public Model() {
        /*Todos los services*/
        serviceList = new serviceList();
        serviceLogginUser = new serviceLogginUser();
        serviceSearch = new serviceSearch();
        serviceUpdate = new serviceUpdate();
        serviceInsert = new serviceInsert();
    }
    
    public static Model getInstance(){
        if(model_instance == null)
            model_instance = new Model();
        return model_instance;
    }
    
    
}
