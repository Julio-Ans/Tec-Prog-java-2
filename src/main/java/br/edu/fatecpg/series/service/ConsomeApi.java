package br.edu.fatecpg.series.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {







    public static String obterDados(String filme) throws IOException, InterruptedException {
        String apikey="205b04b1";
        String regex =" ";
        String replace="+";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?t="+filme.replaceAll(regex, replace)+"&apikey="+apikey))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
