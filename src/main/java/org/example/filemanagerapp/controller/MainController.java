package org.example.filemanagerapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainController {

    @FXML
    private Button btnBuscarArchivo;

    @FXML
    private Label lblArchivoSeleccionado;

    @FXML
    private ListView<String> fileListView;

    @FXML
    private TextField searchField;

    @FXML
    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Archivo");

        // Filtros opcionales (Ej: solo archivos de texto y PDF)
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"),
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf")
        );

        // Mostrar el cuadro de diálogo
        Stage stage = (Stage) btnBuscarArchivo.getScene().getWindow();
        File archivoSeleccionado = fileChooser.showOpenDialog(stage);

        // Si se selecciona un archivo, mostrar la ruta en la etiqueta
        if (archivoSeleccionado != null) {
            lblArchivoSeleccionado.setText(archivoSeleccionado.getAbsolutePath());
        } else {
            lblArchivoSeleccionado.setText("Ningún archivo seleccionado");
        }
    }

    @FXML
    private void saveFile() {
        // Lógica para guardar archivos (puedes implementarla más adelante)
        System.out.println("Guardar archivo...");
    }

    @FXML
    private void buscarArchivo() {
        String searchTerm = searchField.getText();
        if (!searchTerm.isEmpty()) {
            // Lógica para buscar archivos (puedes implementarla más adelante)
            System.out.println("Buscando archivos con el término: " + searchTerm);
        } else {
            lblArchivoSeleccionado.setText("Ingresa un término de búsqueda.");
        }
    }
}