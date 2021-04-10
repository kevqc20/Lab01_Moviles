/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlets;

import com.moviles.lab01.dao.services.serviceLogginUser;
import com.moviles.lab01.model.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jose
 */
@WebServlet(urlPatterns = {"/servletLogin/logIn", "/servletLogin/logOut"})
public class servletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/servletLogin/logIn":
                this.logIn(request, response);
                break;
            case "/servletLogin/logOut":
                this.logOut(request, response);
                break;
        }
    }

    protected void logIn(HttpServletRequest request, HttpServletResponse response) {
        try{
        HttpSession sesion = request.getSession(true);
        String usuario = request.getParameter("txt_user");
        String pass = request.getParameter("txt_password");
        User usu = service.getUser(usuario,pass);
        if (usu != null) {
            sesion.setAttribute("loggin_user", usu);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    protected void logOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("loggin_user");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private serviceLogginUser service = new serviceLogginUser();
}
