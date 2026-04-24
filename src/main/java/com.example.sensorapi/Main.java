package com.example.sensorapi;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/v1/";

    public static HttpServer startServer() {
        return GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI),
                new SensorApplication()
        );
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = startServer();
        System.out.println("Server running at " + BASE_URI);

        Thread.currentThread().join();
        server.shutdownNow();
    }
}
