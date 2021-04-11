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
    INSERT_AIRPLANE("insert into airplane (id,year_,model,brand,type_,cant_max) values (?,?,?,?,?,?);"),
    INSERT_RUTE("insert into rute(id,origin,destination,duration) values(?,?,?,?);"),
    INSERT_SCHEDULE("insert into schedule_ (id,day_,hour_, minute_) values (?,?,?,?);"),
    INSERT_USER("insert into user_ (user_name,password_ ,rol ) vlaues(?,?,?);"),
    INSERT_FLIGHT("insert into flight (id,rute_id,airplane_id,schedule_id) values (?,?,?,?);"),
    INSERT_TICKET("insert into ticket(id,flight_id,price,seat) values (?,?,?,?);"),
    INSERT_PASSENGER("insert into passenger (user_user_name,name_,lastname,email,bob,address,work_phone,cell_phone,ticket_id) values (?,?,?,?,?,?,?,?,?);"),
    //lists
    LIST_AIRPLANES("select * from airplane;"),
    LIST_RUTE("select * from rute;"),
    LIST_SCHEDULE("select * from schedule_;"),
    LIST_USER("select * from user_;"),
    LIST_FLIGHT("select * from flight;"),
    LIST_TICKET("select * from ticket;"),
    LIST_PASSENGER("select * from passenger;"),
    //search
    SEARCH_AIRPLANE("select * from airplane where id = P_AIRPLANE_ID;"),
    SEARCH_ROUTE("select * from rute where id = P_RUTE_ID;"),
    SEARCH_SCHEDULE("select * from schedule_ where id = P_SCHEDULE_ID;"),
    SEARCH_USER("select * from user_ where user_name = P_USER_NAME;"),
    SEARCH_FLIGHT("select * from flight where id = P_ID;"),
    SEARCH_TICKET("select * from ticket where id = P_ID;"),
    SEARCH_PASSENGER("select * from passenger where user_user_name = P_USER_NAME;"),
    //updates
    UPDATE_AIRPLANE("update airplane set P_AIRPLANE_ID=?,P_AIRPLANE_YEAR=?, P_AIRPLANE_MODEL=?, P_AIRPLANE_BRAND=?, P_AIRPLANE_TYPE=?,P_AIRPLANE_CANT_MAX=? where P_AIRPLANE_ID=?;"),
    UPDATE_RUTE("update rute set P_RUTE_ID=?, P_RUTE_ORIGIN=?,P_RUTE_DESTINATION=?, P_RUTE_DURATION=? WHERE P_RUTE_ID=?;"),
    UPDATE_SCHEDULE("update schedule_ set P_SCHEDULE_ID=?, P_SCHEDULE_DAY=?, P_SCHEDULE_HOUR=?, P_SCHEDUL_MINUTE=? WHERE P_SCHEDULE_ID=?;"),
    UPDATE_USER("update user_ set P_USER_NAME=?, P_USER_PASSWORD=?, P_USER_ROL=? WHERE P_USER_NAME=?;"),
    UPDATE_FLIGHT("update flight set P_FLIGHT_ID=?, P_FLIGHT_RUTE=?, P_FLIGHT_AIRPLANE=?, P_FLIGHT_SCHEDULE=? WHERE P_FLIGHT_ID=?;"),
    UPDATE_TICKET("update ticket set P_TICKET_FLIGHT=?, P_TICKET_PRICE=?,P_TICKET_SEAT=?, WHERE P_FLIGHT_ID=?;"),
    UPDATE_PASSENGER("update passenger set P_PASSENGER_USER_NAME=? P_PASSENGER_NAME=?, P_PASSENGER_LASTNAME=?, P_PASSENGER_EMAIL=?, P_PASSENGER_BOB=?, P_PASSENGER_ADDRESS=?, P_PASSENGER_WORK_PHONE=?, P_PASSENGER_CELL_PHONE=?, P_PASSENGER_TICKET=? WHERE P_PASSENGER_USER_NAME=?;"),
    //deletes
    DELETE_AIRPLANE("DELETE FROM airplane WHERE P_AIRPLANE_ID=?;"),
    DELETE_RUTE("DELETE FROM rute WHERE P_RUTE_ID=?;"),
    DELETE_SCHEDULE("DELETE FROM schedule_ WHERE P_SCHEDULE_ID=?;"),
    DELETE_USER("DELETE FROM user_ WHERE P_USER_NAME=?;"),
    DELETE_FLIGHT("DELETE FROM flight WHERE P_ID=?;"),
    DELETE_TICKET("DELETE FROM ticket WHERE P_ID=?;"),
    DELETE_PASSENGER("DELETE FROM passenger WHERE P_USER_NAME=?;"), //?????SETASIGNADOAVION(),
    ;

    IMEC(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
