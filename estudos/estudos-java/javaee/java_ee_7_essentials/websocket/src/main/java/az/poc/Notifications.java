package az.poc;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by allanqueiroz on 9/16/14.
 */
@ServerEndpoint("/notifications")
public class Notifications {

    private Set<Session> sessions = new LinkedHashSet<>();

    @OnMessage
    public void onMessage(String message, Session session){
        sendMessageToAll(message);
    }

    @OnOpen
    public void open(Session session){
        sessions.add(session);
    }

    @OnClose
    public void close(Session session){
        sessions.remove(session);
    }

    private void sendMessageToAll(String message){
        try {
            for (Session session : sessions) {
                for(Session peer : session.getOpenSessions()) {
                    peer.getBasicRemote().sendText(message);
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
