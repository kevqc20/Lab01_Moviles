/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.dao.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author valverde
 */
public class serviceInsert extends service {

    public void insertAirplane(String id, int year, String model, String brand, boolean type, int cant_max) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_AIRPLANE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setInt(2, year);
            stm.setString(3, model);
            stm.setString(4, brand);
            stm.setBoolean(5, type);
            stm.setInt(6, cant_max);
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

    public void insertFlight(String id, String route_id, String airplaine_id, String schedule_id) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_FLIGHT.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, route_id);
            stm.setString(3, airplaine_id);
            stm.setString(4, schedule_id);

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

    public void insertPassenger(String user_username, String name, String lastname, String email, Date dob, String address, int work_phone, int cell_phone, int ticket_id) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_PASSENGER.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, user_username);
            stm.setString(2, name);
            stm.setString(3, lastname);
            stm.setString(4, email);
            stm.setDate(5, dob);
            stm.setString(6, address);
            stm.setInt(7, work_phone);
            stm.setInt(8, cell_phone);
            stm.setInt(9, ticket_id);
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

    public void insertRoute(String id, String origin, String destination, String duration) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_RUTE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, origin);
            stm.setString(3, destination);
            stm.setString(4, duration);
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

    public void insertarSchedule(String id, Timestamp date_time) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_SCHEDULE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setTimestamp(2, date_time);
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

    public void insertarTicket(String id, String flight_id, double price, double discount, int seat) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_TICKET.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, flight_id);
            stm.setDouble(3, price);
            stm.setDouble(4, discount);
            stm.setInt(5, seat);
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

    public void insertarUser(String username, String password, boolean rol) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.INSERT_USER.obtenerComando());) {
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

}
