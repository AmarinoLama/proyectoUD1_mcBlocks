package edu.badpals.proyectoud1_mcrecipes.consultas;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

import java.util.ArrayList;
import java.util.Arrays;

public class MapeoJson {

    /*
        Función que se encarga de elegir el crafteo correcto de los items con durabilidad, debido a que en la API de Minecraft las armaduras tienen
        dos crafteos (el primero es el bueno) y las herramientas tambien tienen dos crafteos (el segundo es el bueno). Por lo que hay que arreglar
        eso teniendo en cuenta que las herramientas y armaduras de Netherite no tienen crafteo, dado que solo admiten fusión.
     */

    public static int getCorrectCraft(Recipe[] recipes) {
        if (recipes.length == 1) {
            return 0;
        }
        ArrayList<String> minerals = new ArrayList<>(Arrays.asList("Diamond", "Netherite", "Gold", "Iron", "Leather"));
        for (Recipe recipe : recipes) {
            for (JsonNode item : recipe.getRecipe()) {
                if (item.asText().equals(recipe.getItem()) && !item.asText().contains("Netherite")) {
                    return 1;
                } else if (minerals.contains(item.asText())) {
                    return 0;
                }
            }
        }
        return 0;
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