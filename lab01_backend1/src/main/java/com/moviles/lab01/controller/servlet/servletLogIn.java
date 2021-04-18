/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.google.gson.Gson;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

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
        sesion = request.getSession(true);
        switch (request.getServletPath()) {
            case "/servletLogin/in":
                this.logIn(request, response);
                break;
            case "/servletLogin/out":
                this.logOut(request, response);
                break;

        }
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        User usu = serv.searchUser(user);
        if (usu.getPassword().equals(pass)) {
            Map map = new HashMap();
            if (usu != null) { //or whatever conditions you need
                map.put("user", usu.getUsername());
                map.put("pass", usu.getPassword());
                map.put("rool", usu.isRol() ? "1" : "0");
            } else {
                map.put("isValid", false);

            }
            write(response, map);
        } else {
            //sesion.setAttribute("user", null);
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) {
        sesion.setAttribute("user", null);
    }

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map)); //this is how simple GSON works
    }

    HttpSession sesion = null;
    Model mod = Model.getInstance();
    serviceSearch serv = mod.getServSearch();
}
