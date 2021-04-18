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
import com.moviles.lab01.model.entities.Passanger;
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
@WebServlet(name = "servletSearch", urlPatterns = {"/servletSearch/usario", "/servletSearch/pasagero", "/servletSearch/avion", "/servletSearch/ruta", "/servletSearch/horario",
    "/servletSearch/tiquete", "/servletSearch/vuelo"})
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
            case "/servletSearch/usario":
                this.usuario(request, response);
                break;
            case "/servletSearch/pasagero":
                this.pasagero(request, response);
                break;
            case "/servletSearch/avion":
                this.avion(request, response);
                break;
            case "/servletSearch/ruta":
                this.ruta(request, response);
                break;
            case "/servletSearch/horario":
                this.horario(request, response);
                break;
            case "/servletSearch/tiquete":
                this.tiquetes(request, response);
                break;
            case "/servletSearch/vuelo":
                this.vuelo(request, response);
                break;

        }
    }

    private void usuario(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String user = request.getParameter("user_username_rm");
        User usu = serv.searchUser(user);
        Map map = new HashMap();
        if (usu != null) { //or whatever conditions you need
                map.put("user",usu);
            } else {
                map.put("isValid", false);

            }
            write(response, map);
    }
    private void pasagero(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String id = request.getParameter("user_username_rm");
        Passanger pasag = serv.searchPassanger(id);
        Map map = new HashMap();
        if (pasag != null) { //or whatever conditions you need
            map.put("user", pasag);
        } else {
            map.put("isValid", false);

        }
        write(response, map);

    }

    private void avion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Airplane plane = serv.searchAirplane(id);
        Map map = new HashMap();
        if (plane != null) { //or whatever conditions you need
                map.put("user",plane);
            } else {
                map.put("isValid", false);

            }
            write(response, map);
    }

    private void ruta(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.searchRoute(id);
    }

    private void horario(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.searchSchedule(id);
    }

    private void tiquetes(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.searchTicket(id);
    }

    private void vuelo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.searchFlight(id);
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
