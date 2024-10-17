import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;
import org.junit.Test;

import static edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson.mapingItems;
import static edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson.mapingRecipes;
import static org.junit.Assert.assertEquals;

public class MapeoJsonTest {

    @Test
    public void testMapeoJsonRecip() {
        ApiRequest.setItem("Barrel");

        Recipe recipe = mapingRecipes()[0];
        String expectedRecipe = "[\"Oak Planks\", \"Oak Slab\", \"Oak Planks\", \"Oak Planks\", null, \"Oak Planks\", \"Oak Planks\", \"Oak Slab\", \"Oak Planks\"]";
        assertEquals(expectedRecipe, recipe.getRecipe().toString());
    }

    @Test
    public void testMapeoJsonItem() throws Exception {
        ApiRequest.setItem("Block of Iron");

        Item item = mapingItems()[0];
        assertEquals("Block of Iron", item.getName());
    }
}