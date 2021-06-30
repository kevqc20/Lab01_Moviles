/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletEndPoint;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author jose
 */
@ServerEndpoint("/reload")
public class controllerReload {

    @OnMessage
    public String onMessage(String message,Session session) throws IOException {
        int numSess = session.getOpenSessions().size();
        for (Session sess : session.getOpenSessions()) {
            if (sess.isOpen())
               sess.getBasicRemote().sendText(message+" "+numSess);
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
}
