package net.spark.ws;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        staticFiles.location("/public");

        // make the connection to the serial port
        //

        webSocket("/my-route", new TheWebSocket());

        get("/yo", (req, res) -> {
            return "WS!";
        });

    }
}
