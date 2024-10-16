package edu.badpals.proyectoud1_mcrecipes.controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField inputField;

    @FXML
    private Label outputLabel;

    @FXML
    private Button search;

    @FXML
    void initialize(ActionEvent event) {
        search.setOnAction(e -> {
            outputLabel.setText("Buscando recetas para " + inputField.getText());
        });
    }

}
