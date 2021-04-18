/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.model;

import com.moviles.lab01.dao.services.serviceDelete;
import com.moviles.lab01.dao.services.serviceInsert;
import com.moviles.lab01.dao.services.serviceList;
import com.moviles.lab01.dao.services.serviceSearch;
import com.moviles.lab01.dao.services.serviceUpdate;
import com.moviles.lab01.model.entities.User;
import java.io.Serializable;

/**
 *
 * @author KEVIN
 */
public class Model implements Serializable {

    /*Todos los DAOs*/
    private static serviceInsert servInsert = null;
    private static serviceDelete servDelete = null;
    private static serviceUpdate servUpdate = null;
    private static serviceSearch servSearch = null;
    private static serviceList servList = null;

    private static Model model_instance = null;

    public Model() {
        servInsert = new serviceInsert();
        servDelete = new serviceDelete();
        servUpdate = new serviceUpdate();
        servSearch = new serviceSearch();
        servList = new serviceList();
    }

    public static serviceInsert getServInsert() {
        return servInsert;
    }

    public static serviceDelete getServDelete() {
        return servDelete;
    }

    public static serviceUpdate getServUpdate() {
        return servUpdate;
    }

    public static serviceSearch getServSearch() {
        return servSearch;
    }

    public static serviceList getServList() {
        return servList;
    }

    public static Model getInstance() {
        if (model_instance == null) {
            model_instance = new Model();
        }
        return model_instance;
    }

    public static void main(String[] args) {
        serviceSearch s = Model.getInstance().getServSearch();
        User test = s.searchUser("kev_qc");

        System.out.println(test.toString());
    }
}
