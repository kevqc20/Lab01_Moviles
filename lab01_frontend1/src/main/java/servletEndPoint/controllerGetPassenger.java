/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEndPoint;

import com.google.gson.Gson;
import com.moviles.lab01.dao.services.serviceSearch;
import com.moviles.lab01.model.Model;
import com.moviles.lab01.model.entities.Passanger;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
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
@ServerEndpoint("/wsGetPassenger")
public class controllerGetPassenger {

    @OnMessage
    public String onMessage(String message, Session session) throws JSONException {
        try {
            JSONObject json = new JSONObject(message);
            String id = json.getString("username");
            Passanger pasag = serv.searchPassanger(id);
            Map map = new HashMap();
            if (pasag != null) { //or whatever conditions you need
                map.put("passanger", pasag);
            } else {
                map.put("isValidbbbbbbbbbbb", false);

            }
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText(new Gson().toJson(map));
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
    serviceSearch serv = mod.getServSearch();
}
