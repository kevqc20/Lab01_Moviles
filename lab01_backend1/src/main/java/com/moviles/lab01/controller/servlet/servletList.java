/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.google.gson.Gson;
import com.moviles.lab01.dao.services.serviceList;
import com.moviles.lab01.model.entities.User;
import com.moviles.lab01.dao.services.serviceList;
import com.moviles.lab01.model.Model;
import com.moviles.lab01.model.entities.Airplane;
import com.moviles.lab01.model.entities.Flight;
import com.moviles.lab01.model.entities.Passanger;
import com.moviles.lab01.model.entities.Route;
import com.moviles.lab01.model.entities.Schedule;
import com.moviles.lab01.model.entities.Ticket;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author jose
 */
@WebServlet(name = "servletList", urlPatterns = {"/servletList/userList", "/servletList/passengerList", "/servletList/airplaneList", "/servletList/routeList", "/servletList/scheduleList",
    "/servletList/ticketsList", "../servletList/flightList"})
public class servletList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        switch (request.getServletPath()) {
            case "/servletList/userList":
                this.userList(request, response);
                break;
            case "/servletList/passengerList":
                this.passengerList(request, response);
                break;
            case "/servletList/airplaneList":
                this.airplaneList(request, response);
                break;
            case "/servletList/routeList":
                this.routeList(request, response);
                break;
            case "/servletList/scheduleList":
                this.scheduleList(request, response);
                break;
            case "/servletList/ticketsList":
                this.ticketsLists(request, response);
                break;
            case "../servletList/flightList":
                this.flightList(request, response);
                break;

        }
    }

    private void userList(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        ArrayList<User> usu = serv.listUser();
        Map map = new HashMap();
        if (usu != null) { //or whatever conditions you need
            map.put("userList", usu);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void passengerList(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        ArrayList<Passanger> pasag = serv.listPassanger();
        Map map = new HashMap();
        if (pasag != null) { //or whatever conditions you need
            map.put("passengerList", pasag);
        } else {
            map.put("isValid", false);

        }
        write(response, map);

    }

    private void airplaneList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Airplane> plane = serv.listAirplane();
        Map map = new HashMap();
        if (plane != null) { //or whatever conditions you need
            map.put("airplaneList", plane);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void routeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Route> rut = serv.listRoute();
        Map map = new HashMap();
        if (rut != null) { //or whatever conditions you need
            map.put("routeList", rut);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void scheduleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Schedule> sched = serv.listSchedule();
        Map map = new HashMap();
        if (sched != null) { //or whatever conditions you need
            map.put("scheduleList", sched);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void ticketsLists(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Ticket> tiq = serv.listTicket();
        Map map = new HashMap();
        if (tiq != null) { //or whatever conditions you need
            map.put("ticketsLists", tiq);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void flightList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Flight> fly = serv.listFlight();
        Map map = new HashMap();
        if (fly != null) { //or whatever conditions you need
            map.put("flightList", fly);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map)); //this is how simple GSON works
    }
    Model mod = Model.getInstance();
    serviceList serv = mod.getServList();
    HttpSession sesion = null;
    
    
}