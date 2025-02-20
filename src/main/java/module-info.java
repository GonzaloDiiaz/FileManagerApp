module org.example.filemanagerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.filemanagerapp to javafx.fxml;
    exports org.example.filemanagerapp;
}