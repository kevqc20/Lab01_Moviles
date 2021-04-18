/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.google.gson.Gson;
import com.moviles.lab01.dao.services.serviceSearch;
import com.moviles.lab01.model.entities.User;
import com.moviles.lab01.dao.services.serviceSearch;
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
@WebServlet(name = "servletSearch", urlPatterns = {"/servletSearch/user", "/servletSearch/passenger", "/servletSearch/airplane", "/servletSearch/route", "/servletSearch/schedule",
    "/servletSearch/ticket", "/servletSearch/flight"})
public class servletSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        switch (request.getServletPath()) {
            case "/servletSearch/user":
                this.usuario(request, response);
                break;
            case "/servletSearch/passenger":
                this.passenger(request, response);
                break;
            case "/servletSearch/airplane":
                this.airplane(request, response);
                break;
            case "/servletSearch/route":
                this.route(request, response);
                break;
            case "/servletSearch/schedule":
                this.schedule(request, response);
                break;
            case "/servletSearch/ticket":
                this.tickets(request, response);
                break;
            case "/servletSearch/flight":
                this.flight(request, response);
                break;

        }
    }

    private void usuario(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String user = request.getParameter("user_username_rm");
        User usu = serv.searchUser(user);
        Map map = new HashMap();
        if (usu != null) { //or whatever conditions you need
            map.put("user", usu);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void passenger(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String id = request.getParameter("user_username_rm");
        Passanger pasag = serv.searchPassanger(id);
        Map map = new HashMap();
        if (pasag != null) { //or whatever conditions you need
            map.put("passanger", pasag);
        } else {
            map.put("isValid", false);

        }
        write(response, map);

    }

    private void airplane(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Airplane plane = serv.searchAirplane(id);
        Map map = new HashMap();
        if (plane != null) { //or whatever conditions you need
            map.put("airplane", plane);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void route(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Route rut = serv.searchRoute(id);
        Map map = new HashMap();
        if (rut != null) { //or whatever conditions you need
            map.put("route", rut);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void schedule(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Schedule sched = serv.searchSchedule(id);
        Map map = new HashMap();
        if (sched != null) { //or whatever conditions you need
            map.put("schedule", sched);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void tickets(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Ticket tiq = serv.searchTicket(id);
        Map map = new HashMap();
        if (tiq != null) { //or whatever conditions you need
            map.put("tickets", tiq);
        } else {
            map.put("isValid", false);

        }
        write(response, map);
    }

    private void flight(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Flight fly = serv.searchFlight(id);
        Map map = new HashMap();
        if (fly != null) { //or whatever conditions you need
            map.put("flight", fly);
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
    serviceSearch serv = mod.getServSearch();
    HttpSession sesion = null;
}