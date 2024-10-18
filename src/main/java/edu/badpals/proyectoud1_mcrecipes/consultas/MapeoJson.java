package edu.badpals.proyectoud1_mcrecipes.consultas;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

public class MapeoJson {

    /*



     */

    public static void main(String[] args) throws Exception {
        ApiRequest.setItem("Block of Iron");
        Recipe[] recipes = mapingRecipes();
        Item[] items = mapingItems();
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getRecipe());
        }
        for (Item item : items) {
            System.out.println(item.getImage());
        }
    }

    /*

    El metodo mapingRecipes() solicita un JSON desde la API de Minecraft, luego utiliza la clase ObjectMapper
    para convertir ese JSON en un array de objetos Recipe. Si la conversión falla por algún error, el metodo captura la
    excepción y devuelve null.

     */


    public static Recipe[] mapingRecipes() {
        try {
            // Crear un ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Obtener el JSON de la respuesta
            String json = ApiRequest.recipeRequest();

            // Mapear el JSON a una instancia de Recipes
            Recipe[] recipes = mapper.readValue(json, Recipe[].class);

            return recipes;
        } catch (Exception e) {
            return null;
        }
    }

    /*

    El metodo mapingItems() convierte un JSON obtenido de la API de Minecraft en un array de objetos Item utilizando ObjectMapper de Jackson.
    Configura el mapeo para ignorar propiedades desconocidas en el JSON y lanza una excepción si ocurre algún error durante el proceso.

     */

    public static Item[] mapingItems() throws Exception {
        // Crear un ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Ignorar propiedades excesivas
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Obtener el JSON de la respuesta
        String json = ApiRequest.itemRequest();

        // Mapear el JSON a una instancia de Items
        Item[] items = mapper.readValue(json, Item[].class);

        return items;
    }
}