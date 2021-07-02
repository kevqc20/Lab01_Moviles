/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEndPoint;

import com.moviles.lab01.dao.services.serviceUpdate;
import com.moviles.lab01.model.Model;
import java.io.IOException;
import java.sql.Date;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jose
 */
@ServerEndpoint("/wsEditUser")
public class controllerEditUser {

    @OnMessage
    public String onMessage(String message, Session session) throws JSONException {
        try {
            JSONObject json = new JSONObject(message);
            String user = json.getString("user_name");
            String email = json.getString("email");
            String pass = json.getString("password");
            String name = json.getString("name_");
            String last_name = json.getString("lastname");
            String wk_phone = json.getString("work_phone");
            String cellphone = json.getString("cell_phone");
            String address = json.getString("address");
            String birthday = json.getString("bob");
            Date date = Date.valueOf(birthday);
            Boolean role = ("1".equals(json.getString("role")));
            serv.updateUser(user, pass, role);
            serv.updatePassenger(user, name, last_name, email, date, address, Integer.parseInt(wk_phone), Integer.parseInt(cellphone));
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText("no reloaded change");
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @OnOpen
    public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText("{'nombre':'servlet','mensaje':'conectado'}");
        } catch (IOException ex) {

        }

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        //session.getBasicRemote().sendText("Coneccion terminada");
        System.out.println("Sesion de: " + session.getId() + " ha terminado");
    }

    Model mod = Model.getInstance();
    serviceUpdate serv = Model.getServUpdate();
}
