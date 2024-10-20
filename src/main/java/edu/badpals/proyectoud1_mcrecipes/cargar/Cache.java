package edu.badpals.proyectoud1_mcrecipes.cargar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cache {

    /*
    * Guarda la lista de imagenes junto al nombre del item en un archivo de texto de caché situado en
    * /src/main/resources/cache/
     */

    public static void saveFileCache(ArrayList<String> itemsImg, String item) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/cache/" + item + ".txt"));
            writer.write(item);
            for (String url : itemsImg) {
                writer.write("\n" + url);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo de cache");
        }
    }

    /*
    * Carga el archivo de caché de un item en un ArrayList de Strings los cuales contienen las imagenes y el nombre del item
     */

    public static ArrayList<String> loadCache(String item) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/cache/" + item + ".txt"));
            ArrayList<String> itemsImg = new ArrayList<>();
            String texto;
            int i = 1;
            while ((texto = br.readLine()) != null) {
                itemsImg.add(texto);
                i++;
            }
            return itemsImg;
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo de cache");
            return null;
        }
    }

    /*
    * Comprueba si existe un archivo de caché de un item y devuelve true o false conforme si lo localiza o no
     */

    public static boolean existsCache(String item) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/cache/" + item + ".txt"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
