module com.petproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.petproject to javafx.fxml;
    exports com.petproject;
    exports com.petproject.database;
    opens com.petproject.database to javafx.fxml;
    exports com.petproject.controllers;
    opens com.petproject.controllers to javafx.fxml;
}