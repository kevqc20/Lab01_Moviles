/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.google.gson.Gson;
import com.moviles.lab01.dao.services.serviceDelete;
import com.moviles.lab01.model.entities.User;
import com.moviles.lab01.dao.services.serviceSearch;
import com.moviles.lab01.model.Model;
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

/**
 *
 * @author jose
 */
@WebServlet(name = "servletDelete", urlPatterns = {"/servletDelete/registro", "/servletDelete/avion", "/servletDelete/ruta", "/servletDelete/horario",
    "/servletDelete/tiquete", "/servletDelete/vuelo"})
public class servletDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        switch (request.getServletPath()) {
            case "/servletDelete/registro":
                this.registrar(request, response);
                break;
            case "/servletDelete/avion":
                this.avion(request, response);
                break;
            case "/servletDelete/ruta":
                this.ruta(request, response);
                break;
            case "/servletDelete/horario":
                this.horario(request, response);
                break;
            case "/servletDelete/tiquete":
                this.tiquetes(request, response);
                break;
            case "/servletDelete/vuelo":
                this.vuelo(request, response);
                break;

        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String user = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deletePassenger(user) == true && serv.deleteUser(user) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void avion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deleteAirplane(id) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void ruta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deleteRoute(id) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void horario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deleteSchedule(id) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void tiquetes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deleteTicket(id) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void vuelo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map map = new HashMap();
        if (serv.deleteFlight(id) == true) { //or whatever conditions you need
            map.put("delete", true);
        } else {
            map.put("delete", false);
        }
        write(response, map);
    }

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map)); //this is how simple GSON works
    }
    Model mod = Model.getInstance();
    serviceDelete serv = mod.getServDelete();
    HttpSession sesion = null;

}
