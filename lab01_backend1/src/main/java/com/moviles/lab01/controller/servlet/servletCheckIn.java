/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.controller.servlet;

import com.moviles.lab01.dao.services.serviceInsert;
import java.io.IOException;
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
@WebServlet(name = "servletCheckIn", urlPatterns = {"/servletCheckIn"})
public class servletCheckIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(servletCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String user = request.getParameter("user_username_rm");
        String email = request.getParameter("email_rm");
        String pass = request.getParameter("password_rm");
        String name = request.getParameter("name_rm");
        String last_name = request.getParameter("lastname_rm");
        String wk_phone = request.getParameter("work_phone_rm");
        String cellphone = request.getParameter("cell_phone_rm");
        String address = request.getParameter("address_rm");
        String birthday = request.getParameter("dob_rm");
        serv.insertarUser(user, pass, true);
        serv.insertPassenger(user, name, last_name, email, serv.str_to_sql_date(birthday), address, Integer.parseInt(wk_phone), Integer.parseInt(cellphone),0 );
    }
    HttpSession sesion = null;
    serviceInsert serv = new serviceInsert();
}
