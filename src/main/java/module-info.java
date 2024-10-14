module edu.badpals.proyectoud1_mcrecipes {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.badpals.proyectoud1_mcrecipes to javafx.fxml;
    exports edu.badpals.proyectoud1_mcrecipes;
}