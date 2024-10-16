package edu.badpals.proyectoud1_mcrecipes.consultas;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

public class MapeoJson {

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