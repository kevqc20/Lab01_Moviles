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

    public User searchUser(String username, String password) {
        User r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_USER.obtenerComando());) {
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

    public Airplane searchAirplane(String id, int year, String model, String brand, boolean type, int cant_max) {
        Airplane r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_AIRPLANE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setInt(2, year);
            stm.setString(3, model);
            stm.setString(4, brand);
            stm.setBoolean(5, type);
            stm.setInt(6, cant_max);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Airplane(
                            rs.getString("id"),
                            rs.getInt("year"),
                            rs.getString("model"),
                            rs.getString("brand"),
                            rs.getBoolean("type"),
                            rs.getInt("rol")
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

    public Route searchRoute(String id, String origin, String destination, String duration) {
        Route r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_ROUTE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, origin);
            stm.setString(3, destination);
            stm.setString(4, duration);
            try (ResultSet rs = stm.executeQuery()) {
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

    public Schedule searchSchedule(String id, Timestamp date_time) {
        Schedule r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_SCHEDULE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setTimestamp(2, date_time);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Schedule(
                            rs.getString("id"),
                            rs.getTimestamp("date_time")
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

    public Flight searchFlight(String id, String route_id, String airplaine_id, String schedule_id) {
        Flight r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_FLIGHT.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, route_id);
            stm.setString(3, airplaine_id);
            stm.setString(4, schedule_id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Flight(
                            rs.getString("id"),
                            rs.getString("route_id"),
                            rs.getString("airplaine_id"),
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

    public Ticket searchTicket(String id, String flight_id, double price, double discount, int seat) {
        Ticket r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_TICKET.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, flight_id);
            stm.setDouble(3, price);
            stm.setDouble(4, discount);
            stm.setInt(5, seat);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Ticket(
                            rs.getString("id"),
                            rs.getString("flight_id"),
                            rs.getDouble("price"),
                            rs.getDouble("discount"),
                            rs.getInt("seat"),
                            rs.getString("user_username")
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

    public Passanger searchPassanger(String user_username, String name, String lastname, String email, Date dob, String address, int work_phone, int cell_phone, int ticket_id) {
        Passanger r = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC.SEARCH_PASSENGER.obtenerComando());) {
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
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Passanger(
                            rs.getString("user_username"),
                            rs.getString("name"),
                            rs.getString("lastname"),
                            rs.getString("email"),
                            rs.getDate("dob"),
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

}
