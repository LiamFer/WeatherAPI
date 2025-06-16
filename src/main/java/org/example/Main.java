package org.example;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(3000),0);
        server.createContext("/weather", new MyHandler());

        // Start the server
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Server is running on port 3000");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            String path = exchange.getRequestURI().getPath();
            String city = Arrays.asList(path.split("/")).getLast();
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(new URI("https://wttr.in/"+city+"?format=j1")).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                exchange.sendResponseHeaders(200, response.body().length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.body().getBytes());
                os.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

        }
    }
}