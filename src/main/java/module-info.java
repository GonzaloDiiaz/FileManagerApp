module org.example.filemanagerapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example.filemanagerapp.controller to javafx.fxml;

    exports org.example.filemanagerapp;
}
