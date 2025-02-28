package org.example.filemanagerapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private Stage stage;

    // Método para recibir el Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validación simple (usuario: admin, contraseña: admin)
        if ("admin".equals(username) && "admin".equals(password)) {
            abrirInterfazPrincipal();
        } else {
            statusLabel.setText("Usuario o contraseña incorrectos.");
        }
    }

    private void abrirInterfazPrincipal() {
        try {
            // Cargar la interfaz principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el Stage
            MainController mainController = loader.getController();
            mainController.setStage(stage);

            // Configurar la escena
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.setTitle("File Manager App");
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error al cargar la interfaz principal.");
        }
    }
}