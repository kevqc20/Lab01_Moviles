/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviles.lab01.dao.services;

import com.moviles.lab01.dao.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 *
 * @author pc
 */
public class service {

    public service() {
    }

    public Date nowDate() {
        return Date.valueOf(LocalDate.now());
    }

    public java.sql.Timestamp fechaTSp(String str) throws ParseException{
    return new Timestamp(str_to_java_date(str).getTime());
    }
    public java.util.Date str_to_java_date(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(str);
    }
    
    public java.sql.Date str_to_sql_date(String str) throws ParseException {
        return date_Java_to_Sql(str_to_java_date(str));
        
    }

    public static Date date_Java_to_Sql(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Properties cfg = bd.obtenerConfiguracion();
        Connection cnx = bd.obtenerConexion(
                cfg.getProperty("database"),
                cfg.getProperty("user"),
                cfg.getProperty("password")
        );
        return cnx;
    }
}
