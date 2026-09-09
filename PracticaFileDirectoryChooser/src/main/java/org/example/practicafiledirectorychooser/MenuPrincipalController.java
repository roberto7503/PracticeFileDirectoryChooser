package org.example.practicafiledirectorychooser;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;

public class MenuPrincipalController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        mostrarInicio();
    }

    @FXML
    private void mostrarInicio() {
        contentArea.getChildren().clear();
        Label bienvenida = new Label("Bienvenido al Sistema de Gestión");
        contentArea.getChildren().add(bienvenida);
    }

    @FXML
    private void abrirRegistroProyectos() {
        cargarVista("registro-proyectos.fxml");
    }

    @FXML
    private void abrirRegistroEstudiantes() {
        cargarVista("registro-estudiantes.fxml");
    }

    private void cargarVista(String fxml) {
        try {
            URL recurso = getClass().getResource(fxml);

            if (recurso == null) {
                mostrarError("No se encontró el archivo FXML:\n" + fxml);
                return;
            }

            FXMLLoader loader = new FXMLLoader(recurso);
            Parent vista = loader.load();
            contentArea.getChildren().setAll(vista);

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("No se pudo cargar la vista:\n" + fxml + "\n\nError: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al cargar la vista");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
