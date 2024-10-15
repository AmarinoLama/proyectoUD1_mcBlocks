package edu.badpals.proyectoud1_mcrecipes.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiRequest {

    private static final String URL = "https://minecraft-api.vercel.app/api/crafting-recipes?item="; // URL de la API

    public static String recipeRequest() throws Exception {

        // Crear un cliente HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + itemSearch()))  // Cambia esta URL por la de tu API
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Mostrar el JSON en la consola
        return response.body(); // Aquí el body contiene el JSON de respuesta
    }

    public static String itemSearch() {
        Scanner sc = new Scanner(System.in);
        String item;
        System.out.println("Introduce el item que quieres buscar: ");
        //item = sc.nextLine();  // todo CAMBIAR ESTO
        //return item.replaceAll(" ", "%20");
        return "Block%20of%20Netherite";  // todo CAMBIAR ESTO
    }

}