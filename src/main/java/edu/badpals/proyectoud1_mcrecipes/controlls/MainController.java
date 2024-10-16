package edu.badpals.proyectoud1_mcrecipes.controlls;

import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtRecip;

    @FXML
    private TextField txtOutput;

    @FXML
    void btnClicked(ActionEvent event) throws Exception {
        ApiRequest.setItem(getTxtRecip());
        Recipe[] recipes = MapeoJson.mapingRecipes();
        System.out.printf(recipes[0].getRecipe().toString());
        setTxtOutput(txtOutput);
        // devuelve un print de la recip
    }

    public String getTxtRecip() {
        return txtRecip.getText();
    }

    public void setTxtOutput(TextField txtOutput) {
        this.txtOutput = txtOutput;
        txtOutput.setText("Hola");
    }
}
