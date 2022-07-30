package com.petproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.petproject.User;
import com.petproject.animation.Shake;
import com.petproject.database.Const;
import com.petproject.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OpenPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSignIn;

    @FXML
    private Button buttonSignUp;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        buttonSignIn.setOnAction(event ->{
            String loginText = emailField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")){
                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else System.out.println("Лох");
            DatabaseHandler db = null;
            try {
                db  = new DatabaseHandler();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                db.cancelBet(getId());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });
        buttonSignUp.setOnAction(event -> {
//            buttonSignUp.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/com/petproject/createAcPage.fxml"));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
            OpenSignUp("/com/petproject/createAcPage.fxml");
        });
    }

    public TextField getEmailField() {
        return emailField;
    }

    private static int id;
    String search="SELECT "+ Const.USERS_ID +" FROM "+ Const.USER_TABLE+" WHERE "+Const.USERS_LOGIN+ "=?";
    private void loginUser(String loginff, String passwordff) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginff);
        user.setPassword(passwordff);
        ResultSet result = dbHandler.getUser(user);
        int count=0;
        while(result.next()){
            count++;
            id = result.getInt(1);
        }
        if (count==1) {
            buttonSignIn.setOnAction(event -> {
//                int id = 0;
//                try {
//                    id = result.getInt(1);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
                OpenPlayPage("/com/petproject/game.fxml");
                //System.out.println(id);
            });
        }
        else{
            Shake userLogAnim = new Shake(emailField);
            Shake  userLogPass = new Shake(passwordField);
            userLogAnim.playAnim();
            userLogPass.playAnim();
            System.out.println("OK");
        }
    }

    public static int getId() {
        return id;
    }

    public void OpenSignUp(String window){
        buttonSignUp.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    public void OpenPlayPage(String window){
        buttonSignIn.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        Label label = new Label("My label");

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
