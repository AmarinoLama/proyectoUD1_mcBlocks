package edu.badpals.proyectoud1_mcrecipes.objetos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("item")
    private String item;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("shapeless")
    private boolean shapeless;

    @JsonProperty("recipe")
    private List<JsonNode> recipe;

    public Recipe() {
    }

    public Recipe(String item, int quantity, boolean shapeless, List<JsonNode> recipe) {
        this.item = item;
        this.quantity = quantity;
        this.shapeless = shapeless;
        this.recipe = recipe;
    }

    public String getItem() {
        return item;
    }

    public List<JsonNode> getRecipe() {
        setRecipe();
        return recipe;
    }

    private void setRecipe() {
        List<JsonNode> updatedRecipe = new ArrayList<>();
        for (JsonNode node : recipe) {
            if (node.isArray() && node.size() > 0) {
                // Si es una lista, añade el primer elemento de la lista
                updatedRecipe.add(node.get(0));
            } else {
                // Si no es una lista, añade el elemento tal cual
                updatedRecipe.add(node);
            }
        }
        recipe = updatedRecipe;
    }

    public boolean isShapeless() {
        return shapeless;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "item='" + item + '\'' +
                ", quantity=" + quantity +
                ", shapeless=" + shapeless +
                ", recipe=" + recipe +
                '}';
    }
}