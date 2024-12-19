package org.example.chatserver.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PuertoController {
    @FXML
    private Label portLb; // Etiqueta que muestra "Indique el puerto"

    @FXML
    private TextField portTf; // Campo de texto donde el usuario ingresa el puerto

    private ChatServer chatServer;

    public PuertoController() {
        this.chatServer = new ChatServer(); // Instancia del servidor
    }

    @FXML
    protected void setPort() {
        String input = portTf.getText().trim();

        if (input.isEmpty()) {
            chatServer.setPort(ChatServer.DEFAULT_PORT); // Usa el puerto predeterminado
            showAlert(Alert.AlertType.INFORMATION, "Puerto Configurado", "Usando el puerto predeterminado: " + ChatServer.DEFAULT_PORT);
        } else {
            try {
                int selectedPort = Integer.parseInt(input);
                if (selectedPort > 0 && selectedPort <= 65535) {
                    chatServer.setPort(selectedPort);
                    showAlert(Alert.AlertType.INFORMATION, "Puerto Configurado", "Puerto configurado en: " + selectedPort);
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Puerto fuera de rango (1-65535). Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Entrada no válida. Intente nuevamente.");
            }
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}