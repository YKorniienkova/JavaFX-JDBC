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
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    private static int id;

    @FXML
    void initialize() {
        //when you click on the SignIn button, if the user is NOT found in
        // the database or the fields are empty, the fields move, otherwise
        // the page with the game is redirected
        buttonSignIn.setOnAction(event ->{
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")){
                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                Shake userLogAnim = new Shake(loginField);
                Shake  userLogPass = new Shake(passwordField);
                userLogAnim.playAnim();
                userLogPass.playAnim();
            }
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
        //when you click on the SignUp button, you go to the user registration page
        buttonSignUp.setOnAction(event -> {
            OpenSignUp("/com/petproject/createAcPage.fxml");
        });
    }

    public TextField getLoginField() {
        return loginField;
    }

    //here it checks if the user is found in order to open the next page
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

                OpenPlayPage("/com/petproject/game.fxml");

        }
        else{
            Shake userLogAnim = new Shake(loginField);
            Shake  userLogPass = new Shake(passwordField);
            userLogAnim.playAnim();
            userLogPass.playAnim();
        }
    }

    //getting ID
    public static int getId() {
        return id;
    }

    //method to go to user registration page
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
        stage.setTitle("Yelyzaveta Korniienkova");
        stage.showAndWait();
    }

    //method to go to game page
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
        stage.setTitle("Yelyzaveta Korniienkova");
        stage.showAndWait();
    }

}
