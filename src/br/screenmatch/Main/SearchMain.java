package br.screenmatch.Main;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class SearchMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a movie: ");
        var escolha = scanner.nextLine();

        try {
            String encodedEscolha = URLEncoder.encode(escolha, "UTF-8");
            var url = "https://www.omdbapi.com/?t=" + encodedEscolha + "&apikey=4f100043";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest resquest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            client.sendAsync(resquest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
