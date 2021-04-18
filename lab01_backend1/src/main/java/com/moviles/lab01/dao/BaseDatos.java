package com.moviles.lab01.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDatos {

    
    private BaseDatos() throws
            ClassNotFoundException,
            IOException,
            IllegalAccessException,
            InstantiationException {
        try {
            String manejador = "com.mysql.cj.jdbc.Driver";
            System.out.printf("Cargando el manejador de la base de datos: %s%n", manejador);
            Class.forName(manejador).newInstance();
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException ex) {
            System.err.println("No se pudo cargar el manejador de la base de datos..");
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw ex;
        }
    }

    public static BaseDatos obtenerInstancia() throws
            ClassNotFoundException,
            IOException,
            IllegalAccessException,
            InstantiationException {
        if (instancia == null) {
            instancia = new BaseDatos();
        }
        return instancia;
    }

    public Connection obtenerConexion(String baseDatos, String usuario, String clave)
            throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
        String URL_conexion = String.format("%s//%s/%s","jdbc:mysql:","localhost","mydb");
        System.out.printf("Conexión: '%s'%n", URL_conexion);

        cnx = DriverManager.getConnection(URL_conexion, usuario, clave);
        return cnx;
    }

    public Properties obtenerConfiguracion() {
        return configuracion;
    }

    public static void main(String[] args) {

        
        try {
            BaseDatos bd = BaseDatos.obtenerInstancia();
            Properties cfg = bd.obtenerConfiguracion();
            try ( Connection cnx = bd.obtenerConexion("mydb","root","209506Kqc")) {
                System.out.println("La conexión fue exitosa..");
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
        }
    }

    private static BaseDatos instancia = null;
    private Properties configuracion;
    private Connection cnx;
}