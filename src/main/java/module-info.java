module org.example.filemanagerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.filemanagerapp to javafx.fxml;
    opens org.example.filemanagerapp.view to javafx.graphics;
    opens org.example.filemanagerapp.controller to javafx.fxml;

    exports org.example.filemanagerapp;
}