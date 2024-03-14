package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrivatBankHistory {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private  static final Gson GSON = new Gson();


    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.privatbank.ua/p24api/exchange_rates?json&date=02.12.2023"))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Body =" + response.body());
        System.out.println(" Code =" + response.statusCode());

    }
}
