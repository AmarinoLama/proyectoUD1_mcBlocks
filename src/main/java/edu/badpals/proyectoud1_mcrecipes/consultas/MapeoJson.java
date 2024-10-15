package edu.badpals.proyectoud1_mcrecipes.consultas;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipes;

public class MapeoJson {
    public static void main(String[] args) throws Exception {
        // Crear un ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Obtener el JSON de la respuesta
        String json = ApiRequest.recipeRequest();

        // Mapear el JSON a una instancia de Recipes
        Recipes[] recipes = mapper.readValue(json, Recipes[].class);

        // Ahora puedes usar el objeto recipes como desees
        for (Recipes recipe : recipes) {
            System.out.println(recipe.getQuantity());
        }
    }
}