package edu.badpals.proyectoud1_mcrecipes.cargar;

import edu.badpals.proyectoud1_mcrecipes.controlls.MainController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveState {

    /*
    * Método que obtiene la lista de items buscados y el item actual y los guarda en un archivo de texto
     */

    public static void saveLastState(String item) {
        try {
            ArrayList<String> itemsImg = MainController.getItemsSearched();
            saveFile(itemsImg, item);
        } catch (Exception e) {
            System.out.println("Error al guardar el estado");
        }
    }

    /*
    * Método encargado de generar el archivo de texto guardando la lista de las imagenes y el nombre del item
    */

    public static void saveFile(ArrayList<String> itemsImg, String item) throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/lastState.txt"));
        writer.write(item);
        for (String url : itemsImg) {
            writer.write("\n" + url);
        }
        writer.close();
    }

    /*
    * Método encargado de leer el archivo de texto y retornar la lista de items buscados
     */

    public static ArrayList<String> loadState() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lastState.txt"));
        ArrayList<String> itemsImg = new ArrayList<>();
        String texto;
        int i=1;
        while((texto=br.readLine())!=null) {
            itemsImg.add(texto);
            i++;
        }
        return itemsImg;
    }
}