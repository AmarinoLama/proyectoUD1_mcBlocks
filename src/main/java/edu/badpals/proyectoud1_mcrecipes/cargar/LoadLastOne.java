package edu.badpals.proyectoud1_mcrecipes.cargar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

import java.io.*;

import static edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson.mapingRecipes;

public class LoadLastOne {

    public static void main(String[] args) throws Exception {
        saveJson("Block of Iron");
        saveTxt("Block of Iron");
        saveBin("Block of Iron");
        saveXML("Block of Iron");
    }

    public static void saveJson(String block) throws Exception {
        ApiRequest.setItem(block);
        String json = ApiRequest.recipeRequest();

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/loads/" + block + ".json"));
        writer.write(json);
        writer.close();
    }

    public static void saveTxt(String block) throws Exception {
        ApiRequest.setItem(block);
        Recipe recipes = mapingRecipes()[0];

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/loads/" + block + ".txt"));
        writer.write(recipes.toString());
        writer.close();
    }

    public static void saveBin(String block) throws IOException {
        ApiRequest.setItem(block);
        Recipe recipes = mapingRecipes()[0];

        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/main/loads/" + block + ".bin"));
        escritor.writeObject(recipes);
        escritor.close();
    }

    public static void saveXML(String block) throws Exception {

        saveJson(block);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/loads/" + block + ".json"));

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("src/main/loads/" + block + ".xml"), jsonNode);

    }
}