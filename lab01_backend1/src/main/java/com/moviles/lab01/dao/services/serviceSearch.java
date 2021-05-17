/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.dao.services;

import com.moviles.lab01.model.entities.Airplane;
import com.moviles.lab01.model.entities.Flight;
import com.moviles.lab01.model.entities.Passanger;
import com.moviles.lab01.model.entities.Route;
import com.moviles.lab01.model.entities.Schedule;
import com.moviles.lab01.model.entities.Ticket;
import com.moviles.lab01.model.entities.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author valverde
 */
public class serviceSearch extends service {

    public User searchUser(String username) {
        User r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_USER.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, username);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new User(
                            rs.getString("user_name"),
                            rs.getString("password_"),
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

    public Airplane searchAirplane(String id) {
        Airplane r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_AIRPLANE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Airplane(
                            rs.getString("id"),
                            rs.getInt("year_"),
                            rs.getString("model"),
                            rs.getString("brand"),
                            rs.getBoolean("type_"),
                            rs.getInt("cant_max")
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

    public Route searchRoute(String id) {
        Route r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_RUTE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Route(
                            rs.getString("id"),
                            rs.getString("origin"),
                            rs.getString("destination"),
                            rs.getString("duration")
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

    public Schedule searchSchedule(String id) {
        Schedule r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_SCHEDULE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Schedule(
                            rs.getString("id"),
                            rs.getTimestamp("date_")
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

    public Flight searchFlight(String id) {
        Flight r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_FLIGHT.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Flight(
                            rs.getString("id"),
                            rs.getString("rute_id"),
                            rs.getString("airplane_id"),
                            rs.getString("schedule_id")
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

    public Ticket searchTicket(String id) {
        Ticket r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_TICKET.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Ticket(
                            rs.getString("id"),
                            rs.getString("flight_id"),
                            rs.getDouble("price"),
                            rs.getDouble("discount"),
                            rs.getInt("seat"),
                            rs.getString("passenger_user")
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

    public Passanger searchPassanger(String user_username) {
        Passanger r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_PASSENGER.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, user_username);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Passanger(
                            rs.getString("user_user_name"),
                            rs.getString("name_"),
                            rs.getString("lastname"),
                            rs.getString("email"),
                            rs.getDate("bob"),
                            rs.getString("address"),
                            rs.getInt("work_phone"),
                            rs.getInt("cell_phone")
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

    public static void main(String[] args) {
        serviceSearch s = new serviceSearch();
        Airplane test = s.searchAirplane("5094A");

        System.out.println(test.toString());
    }

}
