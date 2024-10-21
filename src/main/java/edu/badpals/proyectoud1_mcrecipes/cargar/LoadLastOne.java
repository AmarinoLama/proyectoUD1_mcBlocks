package edu.badpals.proyectoud1_mcrecipes.cargar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

import java.io.*;

import static edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson.mapingRecipes;

public class LoadLastOne {

    /*
    * Método que guarda el archivo JSON llamando a las respectivas funciones para extraer el JSON de la API
     */

    public static void saveJson(String block) throws Exception {
        ApiRequest.setItem(block);
        String json = ApiRequest.recipeRequest();

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/loads/" + block + ".json"));
        writer.write(json);
        writer.close();
    }

    /*
    * Método que guarda el archivo TXT mapeando la clase y llamando a toString
     */

    public static void saveTxt(String block) throws Exception {
        ApiRequest.setItem(block);
        Recipe recipes = mapingRecipes()[0];

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/loads/" + block + ".txt"));
        writer.write(recipes.toString());
        writer.close();
    }

    /*
    * Método que guarda el archivo BIN mapeando la clase y usando ObjectOutputStream
     */

    public static void saveBin(String block) throws IOException {
        ApiRequest.setItem(block);
        Recipe recipes = mapingRecipes()[0];

        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/main/resources/loads/" + block + ".bin"));
        escritor.writeObject(recipes);
        escritor.close();
    }

    /*
    * Método que guarda el archivo XML usando el método anterior para guardar el JSON y luego mapear a XML
     */

    public static void saveXML(String block) throws Exception {
        saveJson(block);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/loads/" + block + ".json"));

        if (jsonNode.isArray()) {
            jsonNode = objectMapper.createObjectNode().set("root", jsonNode);
        }

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("src/main/resources/loads/" + block + ".xml"), jsonNode);
    }
}