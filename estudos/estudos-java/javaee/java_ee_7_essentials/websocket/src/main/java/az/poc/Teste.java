package az.poc;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

/**
 * Created by allanqueiroz on 9/16/14.
 */
@ServerEndpoint("/private/usuario/notifications")
public class Teste {

    private List<Session> sessions = new LinkedList<>();
    private List<Runnable> agendamentos = new LinkedList<>();

    public void comunicarViaWebsocket(){
        try {
            Session session = sessions.get(0);
            session.getBasicRemote().sendText("{\"countNotifications\":{\"privadas\":0,\"andamentos\":0,\"mensagens\":0},\"jsonMessage\":null,\"jsonSuccess\":true}");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @OnOpen
    public void abrirWebsocket(Session session){
        Thread thread = construirNotificador();
        thread.start();

        sessions.add(session);
        agendamentos.add(thread);
    }

    @OnClose
    public void fecharWebsocket(){
        sessions.clear();
        agendamentos.clear();
    }

    private Thread construirNotificador(){
        Thread thread = new Thread(){
            @Override
            public void run () {
                while (true){
                    try {
                        comunicarViaWebsocket();
                        synchronized (this) {
                            this.wait(20000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        return thread;
    }
}
