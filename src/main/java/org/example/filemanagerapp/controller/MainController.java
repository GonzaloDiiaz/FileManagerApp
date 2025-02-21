package org.example.filemanagerapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ComboBox<String> menuComboBox;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    public void initialize() {
        // Agregar opciones al ComboBox si no están en el FXML
        menuComboBox.getItems().addAll("Opción 1", "Opción 2", "Opción 3");

        // Manejar evento del ComboBox
        menuComboBox.setOnAction(event -> {
            String seleccion = menuComboBox.getValue();
            System.out.println("Seleccionaste: " + seleccion);
        });

        // Evento de búsqueda
        searchButton.setOnAction(event -> {
            String query = searchField.getText();
            System.out.println("Buscando: " + query);
        });
    }
}
