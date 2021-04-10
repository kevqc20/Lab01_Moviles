/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.dao.services;

import com.moviles.lab01.model.entities.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author valverde
 */
public class serviceLogginUser extends service{

    public User getUser(String username, String password) {
        User r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.LOGIN.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, username);
            stm.setString(2, password);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new User(
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getBoolean("rol")
                    );
                    System.out.println("entro a datos");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
       
    }
    
}
