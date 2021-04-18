/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.moviles.lab01.model.entities.User;
import com.moviles.lab01.dao.services.serviceSearch;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author jose
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin/in", "/servletLogin/out"})
public class servletLogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/servletLogin/in":
                this.logIn(request, response);
                break;
            case "/servletLogin/out":
                this.logOut(request, response);
                break;

        }
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        User usu = serv.searchUser(user);
        if (usu.getPassword().equals(pass)) {
            sesion.setAttribute("user", usu);
        } else {
            sesion.setAttribute("user", null);
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) {
        sesion.setAttribute("user", null);
    }
    HttpSession sesion = null;
    serviceSearch serv = new serviceSearch();
}
