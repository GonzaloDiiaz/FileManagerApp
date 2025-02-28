package org.example.filemanagerapp.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView<String> fileListView;

    @FXML
    private TextField searchField;

    @FXML
    private Label statusLabel;

    private List<File> archivos = new ArrayList<>();
    private Stage stage;

    // Método para recibir el Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void subirArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivos para Subir");
        List<File> archivosSeleccionados = fileChooser.showOpenMultipleDialog(stage);

        if (archivosSeleccionados != null) {
            archivos.addAll(archivosSeleccionados);
            actualizarListaArchivos();
            statusLabel.setText(archivosSeleccionados.size() + " archivos subidos.");
        }
    }

    @FXML
    private void descargarArchivo() {
        String archivoSeleccionado = fileListView.getSelectionModel().getSelectedItem();
        if (archivoSeleccionado != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar Archivo");
            File destino = fileChooser.showSaveDialog(stage);

            if (destino != null) {
                // Lógica para copiar el archivo seleccionado al destino
                statusLabel.setText("Archivo descargado: " + archivoSeleccionado);
            }
        } else {
            statusLabel.setText("Selecciona un archivo para descargar.");
        }
    }

    @FXML
    private void borrarArchivo() {
        ObservableList<String> seleccionados = fileListView.getSelectionModel().getSelectedItems();
        if (!seleccionados.isEmpty()) {
            archivos.removeIf(file -> seleccionados.contains(file.getName()));
            actualizarListaArchivos();
            statusLabel.setText(seleccionados.size() + " archivos borrados.");
        } else {
            statusLabel.setText("Selecciona al menos un archivo para borrar.");
        }
    }

    @FXML
    private void buscarArchivo() {
        String searchTerm = searchField.getText();
        if (!searchTerm.isEmpty()) {
            fileListView.getItems().clear();
            for (File file : archivos) {
                if (file.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    fileListView.getItems().add(file.getName());
                }
            }
            statusLabel.setText("Búsqueda completada.");
        } else {
            actualizarListaArchivos();
            statusLabel.setText("Ingresa un término de búsqueda.");
        }
    }

    private void actualizarListaArchivos() {
        fileListView.getItems().clear();
        for (File file : archivos) {
            fileListView.getItems().add(file.getName());
        }
    }
}