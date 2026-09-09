package org.example.practicafiledirectorychooser;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RegistroEstudiantesController {

    @FXML
    private TextField txtCarnet;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private void guardarEstudiante() {

        String carnet = txtCarnet.getText().trim();
        String nombre = txtNombreEstudiante.getText().trim();

        if (carnet.isEmpty()) {

            mostrarError("El carnet del estudiante es obligatorio.");
            txtCarnet.requestFocus();
            return;
        }

        if (nombre.isEmpty()) {

            mostrarError("El nombre del estudiante es obligatorio.");
            txtNombreEstudiante.requestFocus();
            return;
        }

        mostrarInformacion(
                "¡Estudiante guardado correctamente!\n\n" +
                        "Carnet: " + carnet + "\n" +
                        "Nombre: " + nombre
        );

        limpiarFormulario();
    }

    private void limpiarFormulario() {
        txtCarnet.clear();
        txtNombreEstudiante.clear();
        txtCarnet.requestFocus();
    }

    private void mostrarError(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText("Operación realizada");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}