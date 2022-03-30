module com.example.bio4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.bio4 to javafx.fxml;
    exports com.example.bio4;
}