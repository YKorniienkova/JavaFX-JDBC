package com.petproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegulationsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backb;

    @FXML
    void initialize() {
        //go to game page on button click
       backb.setOnAction(event->{
           backb.getScene().getWindow().hide();

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/com/petproject/game.fxml"));

           try {
               loader.load();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.setTitle("Yelyzaveta Korniienkova");
           stage.show();
       });

    }

}
