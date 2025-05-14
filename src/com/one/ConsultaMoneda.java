package com.one;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Monedas buscaMonedabuscaMoneda (String monedaBase, String monedaObjetivo) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b1598abeb7fcf84a33c378d6/pair/" + monedaBase + "/" + monedaObjetivo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        Gson gson = new Gson();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    return gson.fromJson(response.body(), Monedas.class);
        }
        catch (Exception e){
            throw  new RuntimeException("No encontre la moneda");
        }

    }
}
