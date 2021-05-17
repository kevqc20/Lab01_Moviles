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
    //inserts
    INSERT_AIRPLANE("CALL PRC_INSERT_AIRPLANE (?,?,?,?,?,?);"),
    INSERT_RUTE("CALL PRC_INSERT_RUTE(?,?,?,?);"),
    INSERT_SCHEDULE("CALL PRC_INSERT_SCHEDULE(?,?);"),
    INSERT_USER("CALL PRC_INSERT_USER(?,?,?);"),
    INSERT_FLIGHT("CALL PRC_INSERT_FLIGHT(?,?,?,?);"),
    INSERT_TICKET("CALL PRC_INSERT_TICKET(?,?,?,?,?,?);"),
    INSERT_PASSENGER("CALL PRC_INSERT_PASSENGER(?,?,?,?,?,?,?,?);"),
    //lists
    LIST_AIRPLANES("CALL PRC_LIST_AIRPLANES();"),
    LIST_RUTE("CALL PRC_LIST_RUTE();"),
    LIST_SCHEDULE("CALL PRC_LIST_SCHEDULE();"),
    LIST_USER("CALL PRC_LIST_USER();"),
    LIST_FLIGHT("CALL PRC_LIST_FLIGHT();"),
    LIST_TICKET("CALL PRC_LIST_TICKET();"),
    LIST_PASSENGER("CALL PRC_LIST_PASSENGER();"),
    //search
    SEARCH_AIRPLANE("CALL PRC_SEARCH_AIRPLANE(?);"),
    SEARCH_RUTE("CALL PRC_SEARCH_RUTE(?);"),
    SEARCH_SCHEDULE("CALL PRC_SEARCH_SCHEDULE(?);"),
    SEARCH_USER("CALL PRC_SEARCH_USER(?);"),
    SEARCH_FLIGHT("CALL PRC_SEARCH_FLIGHT(?);"),
    SEARCH_TICKET("CALL PRC_SEARCH_TICKET(?);"),
    SEARCH_PASSENGER("CALL PRC_SEARCH_PASSENGER(?);"),
    //updates
    UPDATE_AIRPLANE("CALL PRC_UPDATE_AIRPLANE (?,?,?,?,?,?);"),
    UPDATE_RUTE("CALL PRC_UPDATE_RUTE(?,?,?,?);"),
    UPDATE_SCHEDULE("CALL PRC_UPDATE_SCHEDULE(?,?);"),
    UPDATE_USER("CALL PRC_UPDATE_USER(?,?,?);"),
    UPDATE_FLIGHT("CALL PRC_UPDATE_FLIGHT(?,?,?,?);"),
    UPDATE_TICKET("CALL PRC_UPDATE_TICKET(?,?,?,?,?,?);"),
    UPDATE_PASSENGER("CALL PRC_UPDATE_PASSENGER(?,?,?,?,?,?,?,?);"),
    //deletes
    DELETE_AIRPLANE("CALL PRC_DELETE_AIRPLANES(?);"),
    DELETE_RUTE("CALL PRC_DELETE_RUTE(?);"),
    DELETE_SCHEDULE("CALL PRC_DELETE_SCHEDULE(?);"),
    DELETE_USER("CALL PRC_DELETE_USER(?);"),
    DELETE_FLIGHT("CALL PRC_DELETE_FLIGHT(?);"),
    DELETE_TICKET("CALL PRC_DELETE_TICKET(?);"),
    DELETE_PASSENGER("CALL PRC_DELETE_PASSENGER(?);"),;

    IMEC(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
