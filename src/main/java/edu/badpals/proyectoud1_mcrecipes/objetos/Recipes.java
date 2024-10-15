package edu.badpals.proyectoud1_mcrecipes.objetos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Recipes {

    @JsonProperty("item")
    private String item;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("shapeless")
    private String shapeless;

    @JsonProperty("recipe")
    private ArrayList<String> recipe;

    public Recipes(String quantity, String shapeless, ArrayList<String> recipe, String item) {
        this.quantity = quantity;
        this.shapeless = shapeless;
        this.recipe = recipe;
        this.item = item;
    }

    public ArrayList<String> getRecipe() {
        return recipe;
    }

    public String getShapeless() {
        return shapeless;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "item='" + item + '\'' +
                ", quantity='" + quantity + '\'' +
                ", shapeless='" + shapeless + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
