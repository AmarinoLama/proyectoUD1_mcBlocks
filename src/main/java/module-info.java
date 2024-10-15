module edu.badpals.proyectoud1_mcrecipes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;


    opens edu.badpals.proyectoud1_mcrecipes to javafx.fxml;
    exports edu.badpals.proyectoud1_mcrecipes;
}