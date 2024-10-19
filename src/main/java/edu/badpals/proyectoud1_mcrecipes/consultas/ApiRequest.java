package edu.badpals.proyectoud1_mcrecipes.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    /*

    ApiRequest se encarga de, a grandes rasgos, almacenar la URL de nuestra API en forma de una constante. Para luego formatear y enviar
    una petición a la API de Minecraft-Api uniendo la URL y una palabra que nosotros le damos para pedir un String.

     */


    private static final String URL = "https://minecraft-api.vercel.app/api/"; // URL de la API

    private static String item;

    /*

    La API de Minecraft está dividida en tres partes, crafting-recipes, blocks e items, y para que nuestro programa funcione, y nos
    muestre las imagenes de los objetos que estamos buscando. Dado que los JSON que nos provee la parte de la api "crafting-recipes"
    no tiene las imagenes de los objetos que componen el objeto que pedimos, así que tenemos que comprobar en las otras dos partes de
    la api de minecraft, que son blocks e items.

     */

    public static String recipeRequest() throws Exception {
        return sendRequest("crafting-recipes?item=" + giveFormat());
    }

    public static String itemRequest() throws Exception {
        String response = sendRequest("blocks?name=" + giveFormat());

        if(response.equals("[]")) {
            response = sendRequest("items?name=" + giveFormat());
        }

        return response;
    }

    /*

    sendRequest(String endpoint) crea un cliente HTTP que será un objeto que usaremos para hacer una petición a la API de minecraft.
    Además, crea un objeto tipo request con los datos que hemos creado con el nombre del objeto que queremos buscar, y el metodo nos
    regresa un objeto tipo string, que es un JSON sin formatear.

     */

    private static String sendRequest(String endpoint) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + endpoint))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error al hacer la petición");
            return null;
        }
    }


    /*

    giveFormat() se encarga de formatear un string que se le pase para que sea utilizable en la request que se haga mediante URL.

     */

    public static String giveFormat() {
        return getItem().replaceAll(" ", "%20");
    }

    public static String getItem() {
        return item;
    }

    public static void setItem(String item) {
        ApiRequest.item = item;
    }
}