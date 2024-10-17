package edu.badpals.proyectoud1_mcrecipes.controlls;

import edu.badpals.proyectoud1_mcrecipes.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
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
    void btnLoginClicked(ActionEvent event) throws FileNotFoundException, NoSuchAlgorithmException {
        if (Login.validatePass(lblUsuario.getText(), lblContraseña.getText())) {
            System.out.println("Login correcto");
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