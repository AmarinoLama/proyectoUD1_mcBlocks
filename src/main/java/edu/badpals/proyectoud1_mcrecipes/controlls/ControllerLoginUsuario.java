package edu.badpals.proyectoud1_mcrecipes.controlls;

import edu.badpals.proyectoud1_mcrecipes.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ControllerLoginUsuario {

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgLogin;

    @FXML
    private PasswordField lblContraseña;

    @FXML
    private TextField lblUsuario;

    @FXML
    private Label txtContraseña;

    @FXML
    private Label txtCredenciales;

    @FXML
    private Label txtError;

    @FXML
    private Label txtUsuario;

    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        if (Login.validatePass(lblUsuario.getText(), lblContraseña.getText())) {

            // Cargar el archivo FXML de la nueva escena
            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/mainview.fxml"));

            // Crear una nueva escena
            Scene newScene = new Scene(newSceneParent);

            // Obtener el escenario actual y establecer la nueva escena
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);

        } else {
            txtError.setText("Usuario o contraseña incorrectos");
        }
    }

    public Label getTxtContraseña() {
        return txtContraseña;
    }

    public Label getTxtCredenciales() {
        return txtCredenciales;
    }
}