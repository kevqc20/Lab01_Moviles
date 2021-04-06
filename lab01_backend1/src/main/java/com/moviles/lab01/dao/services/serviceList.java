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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author valverde
 */
public class serviceList extends service {

    public ArrayList<User> listUser() {
        ArrayList<User> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_USER.obtenerComando())) {
            while (rs.next()) {
                User e = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("rol")
                );
                r.add(e);
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

    public ArrayList<Airplane> listAirplane() {
        ArrayList<Airplane> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_AIRPLANES.obtenerComando())) {
            while (rs.next()) {
                Airplane e = new Airplane(
                        rs.getString("id"),
                        rs.getInt("year"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getBoolean("type"),
                        rs.getInt("rol")
                );
                r.add(e);
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

    public ArrayList<Route> listRoute() {
        ArrayList<Route> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_RUTE.obtenerComando())) {
            while (rs.next()) {
                Route e = new Route(
                        rs.getString("id"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getString("duration")
                );
                r.add(e);
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

    public ArrayList<Schedule> listSchedule() {
        ArrayList<Schedule> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_SCHEDULE.obtenerComando())) {
            while (rs.next()) {
                Schedule e = new Schedule(
                        rs.getString("id"),
                        rs.getTimestamp("date_time")
                );
                r.add(e);
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

    public ArrayList<Flight> listFlight() {
        ArrayList<Flight> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_FLIGHT.obtenerComando())) {
            while (rs.next()) {
                Flight e = new Flight(
                        rs.getString("id"),
                        rs.getString("route_id"),
                        rs.getString("airplaine_id"),
                        rs.getString("schedule_id")
                );
                r.add(e);
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

    public ArrayList<Ticket> listTicket() {
        ArrayList<Ticket> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_TICKET.obtenerComando())) {
            while (rs.next()) {
                Ticket e = new Ticket(
                        rs.getString("id"),
                        rs.getString("flight_id"),
                        rs.getDouble("price"),
                        rs.getDouble("discount"),
                        rs.getInt("seat")
                );
                r.add(e);
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

    public ArrayList<Passanger> listPassanger() {
        ArrayList<Passanger> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC.LIST_PASSENGER.obtenerComando())) {
            while (rs.next()) {
                Passanger e = new Passanger(
                        rs.getString("user_username"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getDate("dob"),
                        rs.getString("address"),
                        rs.getInt("work_phone"),
                        rs.getInt("cell_phone"),
                        rs.getInt("ticket_id")
                );
                r.add(e);
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
