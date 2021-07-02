/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEndPoint;

import com.moviles.lab01.dao.services.serviceInsert;
import com.moviles.lab01.model.Model;
import java.io.IOException;
import javax.servlet.http.HttpSession;
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
@ServerEndpoint("/insertTicket")
public class controllerInsertTiquete {

    @OnMessage
    public String onMessage(String message, Session session) throws JSONException {
        try {
            JSONObject json = new JSONObject(message);
            String id = json.getString("id");
            String flight_id = json.getString("flight_id");
            String price = json.getString("price");
            String discount = json.getString("discount");
            String seat = json.getString("seat");
            String user_usuario = json.getString("user_usuario");
            serv.insertTicket(id, flight_id, Integer.parseInt(price), Integer.parseInt(seat), user_usuario, Integer.parseInt(discount));
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText("asientos");
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
    serviceInsert serv = mod.getServInsert();
}
