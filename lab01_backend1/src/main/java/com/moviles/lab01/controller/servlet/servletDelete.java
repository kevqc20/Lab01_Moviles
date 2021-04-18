/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
@WebServlet(name = "servletDelete", urlPatterns = {"/servletDelete/registro", "/servletDelete/avion", "/servletDelete/ruta", "/servletDelete/horario", 
    "/servletDelete/tiquete","/servletDelete/vuelo"})
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

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String user = request.getParameter("user_username_rm");
        serv.deletePassenger(user);
        serv.deleteUser(user);
        
    }

    private void avion(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.deleteAirplane(id);
    }

    private void ruta(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.deleteRoute(id);
    }

    private void horario(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.deleteSchedule(id);
    }

    private void tiquetes(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.deleteTicket(id);
    }
    private void vuelo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serv.deleteFlight(id);
    }
    Model mod = Model.getInstance();
    serviceDelete serv = mod.getServDelete();
    HttpSession sesion = null;
}
