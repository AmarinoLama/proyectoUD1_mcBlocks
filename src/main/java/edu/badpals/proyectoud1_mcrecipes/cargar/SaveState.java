package edu.badpals.proyectoud1_mcrecipes.cargar;

import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.controlls.MainController;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveState {

    public static void saveLastState(String item) {
        try {
            ArrayList<String> itemsImg = MainController.getItemsSearched();
            saveFile(itemsImg, item);
        } catch (Exception e) {
            System.out.println("Error al guardar el estado");
        }
    }

    public static void saveFile(ArrayList<String> itemsImg, String item) throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/lastState.txt"));
        writer.write(item);
        for (String url : itemsImg) {
            writer.write("\n" + url);
        }
        writer.close();
    }

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
