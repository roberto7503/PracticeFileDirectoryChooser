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
    private TextField txtEdad;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtCorreo;

    @FXML
    private void guardarEstudiante() {

        String carnet = txtCarnet.getText().trim();
        String nombre = txtNombreEstudiante.getText().trim();
        String edad = txtEdad.getText().trim();
        String carrera = txtCarrera.getText().trim();
        String correo = txtCorreo.getText().trim();

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

        if (edad.isEmpty()) {
            mostrarError("La edad del estudiante es obligatoria.");
            txtEdad.requestFocus();
            return;
        }

        if (carrera.isEmpty()) {
            mostrarError("La carrera es obligatoria.");
            txtCarrera.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            mostrarError("El correo electrónico es obligatorio.");
            txtCorreo.requestFocus();
            return;
        }

        mostrarInformacion(
                "¡Estudiante guardado correctamente!\n\n" +
                        "Carnet: " + carnet + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Edad: " + edad + "\n" +
                        "Carrera: " + carrera + "\n" +
                        "Correo: " + correo
        );

        limpiarFormulario();
    }

    private void limpiarFormulario() {
        txtCarnet.clear();
        txtNombreEstudiante.clear();
        txtEdad.clear();
        txtCarrera.clear();
        txtCorreo.clear();
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
