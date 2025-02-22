package org.example.filemanagerapp.controller;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.File;

public class MainController {

    @FXML
    private Button btnBuscarArchivo;

    @FXML
    private Label lblArchivoSeleccionado;

    @FXML
    private void buscarArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivo");

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
}
