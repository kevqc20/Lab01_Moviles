package com.moviles.lab01.dao.services;

public enum IMEC {

    /*
    private static final String INSERTARAVION = "{call insertarAvion(?,?,?,?,?)}";
    private static final String ACTUALIZARAVION = "{call actualizarAvion(?,?,?,?,?)}";
    private static final String ELIMINARAVION = "{call eliminarAvion(?)}";
    private static final String SETASIGNADOAVION = "{call setasignadoavion(?,?)}";

    private static final String LISTARAVIONES = "{?=call listarAviones()}";
    private static final String CONSULTARAVION = "{?=call consultarAvion(?)}";

    */
    //escribir todas las consultas aqui de todos los IMECS
    ;

    IMEC(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
