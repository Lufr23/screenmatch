package br.screenmatch.Main;

import br.screenmatch.Model.ErrorConvertionExeception;
import br.screenmatch.Model.OmdbTitle;
import br.screenmatch.Model.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class SearchMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a movie: ");
        var escolha = scanner.nextLine();

        try {
            String encodedEscolha = URLEncoder.encode(escolha, "UTF-8");
            var url = "https://www.omdbapi.com/?t=" + encodedEscolha + "&apikey=4f100043";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            OmdbTitle myTitleOmdb = gson.fromJson(json, OmdbTitle.class);

            Title myTitle = new Title(myTitleOmdb);
            System.out.println(myTitle);

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereço");
        } catch (ErrorConvertionExeception e) {
            System.out.println(e.getMessage());
        }
    }
}
