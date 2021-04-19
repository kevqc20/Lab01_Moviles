/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.moviles.lab01.dao.services.serviceInsert;
import com.moviles.lab01.model.Model;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "servletInsert", urlPatterns = {"/servletInsert/registro", "/servletInsert/avion", "/servletInsert/ruta", "/servletInsert/horario",
    "/servletInsert/tiquete", "/servletInsert/vuelo"})
public class servletInsert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        switch (request.getServletPath()) {
            case "/servletInsert/registro":
                this.registrar(request, response);
                break;
            case "/servletInsert/avion":
                this.avion(request, response);
                break;
            case "/servletInsert/ruta":
                this.ruta(request, response);
                break;
            case "/servletInsert/horario":
                this.horario(request, response);
                break;
            case "/servletInsert/tiquete":
                this.tiquetes(request, response);
                break;
            case "/servletInsert/vuelo":
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
        serv.insertUser(user, pass, false);
        serv.insertPassenger(user, name, last_name, email, sql, address, Integer.parseInt(wk_phone), Integer.parseInt(cellphone));
    }

    private void avion(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String year = request.getParameter("year");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String cant = request.getParameter("cant");
        String type = request.getParameter("type");
        serv.insertAirplane(id, Integer.parseInt(year), model, brand, Boolean.parseBoolean(type), Integer.parseInt(cant));
    }

    private void ruta(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String duration = request.getParameter("duration");
        serv.insertRoute(id, origin, destination, duration);
    }

    private void horario(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        serv.insertSchedule(id, serv.fechaTSp(date));
    }

    private void tiquetes(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String flight_id = request.getParameter("price");
        String price = request.getParameter("id");
        String discount = request.getParameter("discount");
        String seat = request.getParameter("seat");
        String user_usuario = request.getParameter("user_usuario");
        serv.insertTicket(id, flight_id, Integer.parseInt(price), Integer.parseInt(seat), user_usuario, Integer.parseInt(discount));
    }

    private void vuelo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String rute_id = request.getParameter("rute_id");
        String airplane_id = request.getParameter("airplane_id");
        String shedule_id = request.getParameter("shedule_id");
        serv.insertFlight(id, rute_id, airplane_id, shedule_id);
    }
    HttpSession sesion = null;
    Model mod = Model.getInstance();
    serviceInsert serv = mod.getServInsert();

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = format.parse("20110210");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        System.out.println(sql);
    }

}
