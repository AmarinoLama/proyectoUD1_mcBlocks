package edu.badpals.proyectoud1_mcrecipes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static edu.badpals.proyectoud1_mcrecipes.login.Login.creadorProperties;
import static edu.badpals.proyectoud1_mcrecipes.login.Login.validatePass;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Minecraft Recipes");

        creadorProperties();

        System.out.println(validatePass("Administrador","suputamadre"));

        // mostrar una laberl con texto
        Label label = new Label("Mostrar recipes");

        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}