package edu.badpals.proyectoud1_mcrecipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.badpals.proyectoud1_mcrecipes.login.Login.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Minecraft Recipes");

        propertiesCreator();

        System.out.println(validatePass("Administrador","suputamadre"));

        // mostrar una laberl con texto
        Label label = new Label("Mostrar recipes");

        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscene.fxml"));
            Parent root = loader.load();
            // Controller controller = loader.getController();
            //controller.setMainWindow(primaryStage);

            stage.setTitle("Disney API");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }



        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}