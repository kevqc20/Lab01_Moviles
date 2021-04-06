/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.dao.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author valverde
 */
public class serviceUpdate extends service {

    private void updateUser(String username, String password, boolean rol) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.UPDATE_USER.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setBoolean(3, rol);
            try {
                int val = stm.executeUpdate();
            } catch (SQLException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    private void update() {

    }
}
