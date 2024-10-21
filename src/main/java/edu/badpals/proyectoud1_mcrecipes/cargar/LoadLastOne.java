package edu.badpals.proyectoud1_mcrecipes.cargar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson;
import edu.badpals.proyectoud1_mcrecipes.controlls.MainController;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

import java.io.*;

import static edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson.mapingRecipes;

public class LoadLastOne {

    /*
    * Método que guarda el archivo JSON llamando a las respectivas funciones para extraer el JSON de la API
     */

    public static void saveJson(String block, String nameFile) {
        try {
            String fileName = (nameFile != null && !nameFile.isEmpty()) ? nameFile : block;

            ApiRequest.setItem(block);
            String json = ApiRequest.recipeRequest();
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/loads/" + fileName + ".json"));
            writer.write(json);
            writer.close();
            System.out.println("Archivo exportado a JSON");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo JSON");
        }

    }

    /*
    * Método que guarda el archivo TXT mapeando la clase y llamando a toString
     */

    public static void saveTxt(String block, String nameFile) {
        try {
            String fileName = (nameFile != null && !nameFile.isEmpty()) ? nameFile : block;

            ApiRequest.setItem(block);
            Recipe recipes = mapingRecipes()[MapeoJson.getCorrectCraft(mapingRecipes())];

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/loads/" + fileName + ".txt"));
            writer.write(recipes.toString());
            writer.close();
            System.out.println("Archivo exportado a TXT");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo TXT");
        }
    }

    /*
    * Método que guarda el archivo BIN mapeando la clase y usando ObjectOutputStream
     */

    public static void saveBin(String block, String nameFile) {
        try {
            String fileName = (nameFile != null && !nameFile.isEmpty()) ? nameFile : block;
            ApiRequest.setItem(block);
            Recipe recipes = mapingRecipes()[0];

            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/main/resources/loads/" + fileName + ".bin"));
            escritor.writeObject(recipes);
            escritor.close();
            System.out.println("Archivo exportado a BIN");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo BIN");
        }
    }

    /*
    * Método que guarda el archivo XML usando el método anterior para guardar el JSON y luego mapear a XML
     */

    public static void saveXML(String block, String nameFile) {
        try {
            String fileName = (nameFile != null && !nameFile.isEmpty()) ? nameFile : block;
            saveJson(block, nameFile);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/loads/" + block + ".json"));

            if (jsonNode.isArray()) {
                jsonNode = objectMapper.createObjectNode().set("root", jsonNode);
            }

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("src/main/resources/loads/" + fileName + ".xml"), jsonNode);
            System.out.println("Archivo exportado a XML");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo XML");
        }
    }
}