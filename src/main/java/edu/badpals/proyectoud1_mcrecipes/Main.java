package edu.badpals.proyectoud1_mcrecipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static edu.badpals.proyectoud1_mcrecipes.login.Login.creadorProperties;
import static edu.badpals.proyectoud1_mcrecipes.login.Login.validatePass;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // c6c6c6 - color fondo

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/loginscene.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Minecraft Recipes");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Application.launch(args);
        Minimain();
    }

    public static void Minimain() throws FileNotFoundException, NoSuchAlgorithmException {

        creadorProperties();

        System.out.println(validatePass("Administrador","Renaido"));
        System.out.println(validatePass("Aman","1234"));
        System.out.println(validatePass("a","1234"));
    }

}