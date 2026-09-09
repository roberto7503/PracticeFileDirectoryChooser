module org.example.practicafiledirectorychooser {

    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.practicafiledirectorychooser
            to javafx.fxml;

    exports org.example.practicafiledirectorychooser;
}