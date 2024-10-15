package edu.badpals.proyectoud1_mcrecipes.objetos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String image;

    public Item() {
    }

    public Item(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
