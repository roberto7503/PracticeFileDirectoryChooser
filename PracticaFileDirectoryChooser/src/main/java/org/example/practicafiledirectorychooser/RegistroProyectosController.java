package org.example.practicafiledirectorychooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroProyectosController {

    @FXML
    private TextField txtnombreProyecto;

    @FXML
    private TextField txtResponsable;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtArchivo;

    @FXML
    private TextField txtDirectorio;

    @FXML
    private Button btnSeleccionarArchivo;

    @FXML
    private Button btnSeleccionarDirectorio;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;


    @FXML
    private void seleccionarArchivo(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleccionar archivo de requerimiento");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Archivos TXT y PDF",
                        "*.txt",
                        "*.pdf"
                ),
                new FileChooser.ExtensionFilter(
                        "Archivo TXT",
                        "*.txt"
                ),
                new FileChooser.ExtensionFilter(
                        "Archivo PDF",
                        "*.pdf"
                )
        );

        File archivo = fileChooser.showOpenDialog(
                btnSeleccionarArchivo.getScene().getWindow()
        );

        if (archivo != null) {
            txtArchivo.setText(archivo.getAbsolutePath());
        }
    }


    @FXML
    private void seleccionarDirectorio() {

        DirectoryChooser directoryChooser =
                new DirectoryChooser();

        directoryChooser.setTitle(
                "Seleccionar directorio del proyecto"
        );

        File directorioInicial =
                new File(System.getProperty("user.home"));

        if (directorioInicial.isDirectory()) {
            directoryChooser.setInitialDirectory(
                    directorioInicial
            );
        }

        File directorio = directoryChooser.showDialog(
                btnSeleccionarDirectorio.getScene().getWindow()
        );

        if (directorio != null) {
            txtDirectorio.setText(
                    directorio.getAbsolutePath()
            );
        }
    }


    @FXML
    private void guardarProyecto() {

        if (!validarFormulario()) {
            return;
        }

        Alert confirmacion =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText(
                "¿Seguro que quieres guardar el proyecto?"
        );

        confirmacion.setContentText(
                "Proyecto: " +
                        txtnombreProyecto.getText().trim()
        );

        Optional<ButtonType> respuesta =
                confirmacion.showAndWait();

        if (respuesta.isPresent()
                && respuesta.get() == ButtonType.OK) {

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Proyecto guardado");

            alert.setHeaderText(
                    "¡Proyecto guardado correctamente!"
            );

            alert.setContentText(
                    "El proyecto se ha registrado con éxito."
            );

            alert.showAndWait();

            limpiar();
        }
    }


    private boolean validarFormulario() {

        if (txtnombreProyecto.getText().trim().isEmpty()) {
            mostrarError(
                    "El nombre del proyecto es obligatorio."
            );
            txtnombreProyecto.requestFocus();
            return false;
        }

        if (txtResponsable.getText().trim().isEmpty()) {
            mostrarError(
                    "El responsable del proyecto es obligatorio."
            );
            txtResponsable.requestFocus();
            return false;
        }

        if (txtDescripcion.getText().trim().isEmpty()) {
            mostrarError(
                    "La descripción del proyecto es obligatoria."
            );
            txtDescripcion.requestFocus();
            return false;
        }

        if (txtArchivo.getText().trim().isEmpty()) {
            mostrarError(
                    "Debe seleccionar el archivo de requerimiento."
            );
            return false;
        }

        if (txtDirectorio.getText().trim().isEmpty()) {
            mostrarError(
                    "Debe seleccionar el directorio del proyecto."
            );
            return false;
        }

        return true;
    }


    @FXML
    private void limpiar() {

        txtnombreProyecto.clear();
        txtResponsable.clear();
        txtDescripcion.clear();
        txtArchivo.clear();
        txtDirectorio.clear();

        txtnombreProyecto.requestFocus();
    }


    private void mostrarError(String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}