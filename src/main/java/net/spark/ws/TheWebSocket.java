package net.spark.ws;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

@WebSocket
public class TheWebSocket {

    public TheWebSocket() {
        // serial connection passed in here
    }


    @OnWebSocketConnect
    public void connected(Session session) {
        System.out.println("Connected...");

        // once connected to the web sockets
        // now yu can get a connection to the client using...

        RemoteEndpoint connectionToTheBrowser = session.getRemote();
        // use connectionToTheBrowser.sendString
        // to send a message to the browser

    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        System.out.println("closed...");
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        System.out.println("Got: " + message);   // Print message
        session.getRemote().sendString(message.toUpperCase()); // and send it back

    }
}
