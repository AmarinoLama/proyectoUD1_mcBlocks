package edu.badpals.proyectoud1_mcrecipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/loginscene.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Minecraft Recipes");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    // --module-path C:\Users\a23amanlv\javafx-sdk-23.0.1\lib --add-modules="javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.swing,javafx.media"

    public static void main(String[] args) {
        Application.launch(args);
    }
}