package edu.badpals.proyectoud1_mcrecipes.controlls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtRecip;

    public Button getBtnSearch() {
        return btnSearch;
    }

    public String getTxtRecip() {
        return txtRecip.getText();
    }
}