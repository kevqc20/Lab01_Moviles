/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.moviles.lab01.dao.services.serviceUpdate;
import com.moviles.lab01.model.Model;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@WebServlet(name = "servletUpdate", urlPatterns = {"/servletUpdate/registro", "/servletUpdate/avion", "/servletUpdate/ruta", "/servletUpdate/horario", 
    "/servletUpdate/tiquete","/servletUpdate/vuelo"})
public class servletUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        switch (request.getServletPath()) {
            case "/servletUpdate/registro":
                this.registrar(request, response);
                break;
            case "/servletUpdate/avion":
                this.avion(request, response);
                break;
            case "/servletUpdate/ruta":
                this.ruta(request, response);
                break;
            case "/servletUpdate/horario":
                this.horario(request, response);
                break;
            case "/servletUpdate/tiquete":
                this.tiquetes(request, response);
                break;
            case "/servletUpdate/vuelo":
                this.vuelo(request, response);
                break;

        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String user = request.getParameter("user_name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String name = request.getParameter("name_");
        String last_name = request.getParameter("lastname");
        String wk_phone = request.getParameter("work_phone");
        String cellphone = request.getParameter("cell_phone");
        String address = request.getParameter("address");
        String birthday = request.getParameter("bob");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.sql.Date sql = null;
        try {
            java.util.Date parsed = format.parse(birthday);
            sql = new java.sql.Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Boolean role = ("1".equals(request.getParameter("role")));
        serv.updateUser(user, pass, role);
        serv.updatePassenger(user, name, last_name, email, sql, address, Integer.parseInt(wk_phone), Integer.parseInt(cellphone));
    }

    private void avion(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String year = request.getParameter("year");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String cant = request.getParameter("cant");
        String type = request.getParameter("type");
        serv.updateAirplane(id, Integer.parseInt(year), model, brand, Boolean.parseBoolean(type), Integer.parseInt(cant));
    }

    private void ruta(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String duration = request.getParameter("duration");
        serv.updateRoute(id, origin, destination, duration);
    }

    private void horario(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        serv.updateSchedule(id,serv.fechaTSp(date));
    }

    private void tiquetes(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String flight_id = request.getParameter("price");
        String price = request.getParameter("id");
        String discount = request.getParameter("discount");
        String seat = request.getParameter("seat");
        String user_usuario = request.getParameter("user_usuario");
        serv.updateTicket(id, flight_id, Integer.parseInt(price), Integer.parseInt(seat), user_usuario, Integer.parseInt(discount));
    }
    private void vuelo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String rute_id = request.getParameter("rute_id");
        String airplane_id = request.getParameter("airplane_id");
        String shedule_id = request.getParameter("shedule_id");
        serv.updateFlight(id, rute_id, airplane_id, shedule_id);
    }
    HttpSession sesion = null;
    Model mod = Model.getInstance();
    serviceUpdate serv = Model.getServUpdate();

}
