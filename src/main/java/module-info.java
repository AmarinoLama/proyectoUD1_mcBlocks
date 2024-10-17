module edu.badpals.proyectoud1_mcrecipes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;
    requires junit;

    opens edu.badpals.proyectoud1_mcrecipes to javafx.fxml;
    opens edu.badpals.proyectoud1_mcrecipes.controlls to javafx.fxml;
    opens edu.badpals.proyectoud1_mcrecipes.objetos to com.fasterxml.jackson.databind;

    exports edu.badpals.proyectoud1_mcrecipes;
    exports edu.badpals.proyectoud1_mcrecipes.objetos;
    exports edu.badpals.proyectoud1_mcrecipes.login;
    exports edu.badpals.proyectoud1_mcrecipes.consultas;
}