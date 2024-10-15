package edu.badpals.proyectoud1_mcrecipes.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiRequest {

    private static final String URL = "https://minecraft-api.vercel.app/api/"; // URL de la API

    public static String recipeRequest() throws Exception {
        return sendRequest("crafting-recipes?item=" + itemSearch());
    }

    public static String itemRequest() throws Exception {
        String response = sendRequest("blocks?name=" + itemSearch());

        if(response.equals("[]")) {
            response = sendRequest("items?name=" + itemSearch());
        }

        return response;
    }

    private static String sendRequest(String endpoint) throws Exception {
        // Crear un cliente HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + endpoint))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    // NO ACEPTA ITEMS QUE USEN MADERA GENÉRICA
    public static String itemSearch() {
        Scanner sc = new Scanner(System.in);
        String item;
        System.out.println("Introduce el item que quieres buscar: ");
        //item = sc.nextLine();  // todo CAMBIAR ESTO
        //return item.replaceAll(" ", "%20");
        return "Barrel";  // todo CAMBIAR ESTO
    }

}