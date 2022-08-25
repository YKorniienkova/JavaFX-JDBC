package com.petproject.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.petproject.User;
import com.petproject.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameControllers {

        @FXML
        private Label balancelabel;

        @FXML
        private Button bet500;

        @FXML
        private TextField betf;

        @FXML
        private Button but10;

        @FXML
        private Button but11;

        @FXML
        private Button but12;

        @FXML
        private Button but13;

        @FXML
        private Button but14;

        @FXML
        private Button but20;

        @FXML
        private Button but21;

        @FXML
        private Button but22;

        @FXML
        private Button but23;

        @FXML
        private Button but24;

        @FXML
        private Button but30;

        @FXML
        private Button but31;

        @FXML
        private Button but32;

        @FXML
        private Button but33;

        @FXML
        private Button but34;

        @FXML
        private Button but40;

        @FXML
        private Button but41;

        @FXML
        private Button but42;

        @FXML
        private Button but43;

        @FXML
        private Button but44;

        @FXML
        private Button but50;

        @FXML
        private Button but51;

        @FXML
        private Button but52;

        @FXML
        private Button but53;

        @FXML
        private Button but54;

        @FXML
        private Button nextb;

        @FXML
        private Label resultl;

        @FXML
        private Button stopb;

        @FXML
        private Label winl;
        @FXML
        private Button regulationsb;

    OpenPageController openPageController = new OpenPageController();

    //get id by method getId by class openPageControlle
    public int id_us= openPageController.getId();

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        getBalance();
        disable1();
        disable2();
        disable3();
        disable4();
        disable5();
        negativeBalance();
        //when you click on the rules button, a page with rules appears
        regulationsb.setOnAction(event->{
            regulationsb.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/petproject/regulations.fxml"));

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
            try {
                cancelBet();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        //there is a check whether the winning button is pressed, if it is winning,
        // the win() method is executed, if not, the noWin() method
        int[] apples1 = new int[5];
        generateButtons(apples1);
        but10.setOnAction(event -> {
            if (apples1[0]==0) {
                win();

            }
            else noWin();
            disable1();
        });
        but11.setOnAction(event -> {
            if (apples1[1]==0){
                win();
            }
            else noWin();
            disable1();
        });
        but12.setOnAction(event -> {
            if (apples1[2]==0){
                win();
            }
            else noWin();
            disable1();
        });
        but13.setOnAction(event -> {
            if (apples1[3]==0){
                win();
            }
            else noWin();
            disable1();
        });
        but14.setOnAction(event -> {
            if (apples1[4]==0){
                win();
            }
            else noWin();
            disable1();
        });


        int[] apples2= new int[5];
        generateButtons(apples2);
        but20.setOnAction(event -> {
            if (apples2[0]==0) {
                win2();

            }
            else noWin();
            disable2();
        });
        but21.setOnAction(event -> {
            if (apples2[1]==0){
                win2();
            }
            else noWin();
            disable2();
        });
        but22.setOnAction(event -> {
            if (apples2[2]==0){
                win2();
            }
            else noWin();
            disable2();
        });
        but23.setOnAction(event -> {
            if (apples2[3]==0){
                win2();
            }
            else noWin();
            disable2();
        });
        but24.setOnAction(event -> {
            if (apples2[4]==0){
                win2();
            }
            else noWin();
            disable2();
        });


        int[] apples3= new int[5];
        generateButtons2(apples3);
        but30.setOnAction(event -> {
            if (apples3[0]==0) {
                win3();

            }
            else noWin();
            disable3();
        });
        but31.setOnAction(event -> {
            if (apples3[1]==0){
                win3();
            }
            else noWin();
            disable3();
        });
        but32.setOnAction(event -> {
            if (apples3[2]==0){
                win3();
            }
            else noWin();
            disable3();
        });
        but33.setOnAction(event -> {
            if (apples3[3]==0){
                win3();
            }
            else noWin();
            disable3();
        });
        but34.setOnAction(event -> {
            if (apples3[4]==0){
                win3();
            }
            else noWin();
            disable3();
        });


        int[] apples4= new int[5];
        generateButtons3(apples4);
        but40.setOnAction(event -> {
            if (apples4[0]==0) {
                win4();

            }
            else noWin();
            disable4();
        });
        but41.setOnAction(event -> {
            if (apples4[1]==0){
                win4();
            }
            else noWin();
            disable4();
        });
        but42.setOnAction(event -> {
            if (apples4[2]==0){
                win4();
            }
            else noWin();
            disable4();
        });
        but43.setOnAction(event -> {
            if (apples4[3]==0){
                win4();
            }
            else noWin();
            disable4();
        });
        but44.setOnAction(event -> {
            if (apples4[4]==0){
                win4();
            }
            else noWin();
            disable4();
        });

        int[] apples5=new int[5];
        generateButtons4(apples5);
        but50.setOnAction(event -> {
            if (apples5[0]==0) {
                try {
                    win5();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
            else noWin();
            disable5();
        });
        but51.setOnAction(event -> {
            if (apples5[1]==0){
                try {
                    win5();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else noWin();
            disable5();
        });
        but52.setOnAction(event -> {
            if (apples5[2]==0){
                try {
                    win5();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else noWin();
            disable5();
        });
        but53.setOnAction(event -> {
            if (apples5[3]==0){
                try {
                    win5();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else noWin();
            disable5();
        });
        but54.setOnAction(event -> {
            if (apples5[4]==0){
                try {
                    win5();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else noWin();
            disable5();
        });

        stopb.setOnAction(event->{
            try {
                winBet();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                cancelBet();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

        bet500.setOnAction(event->{

            try {
                createBet(id_us);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            DatabaseHandler db = null;
            try {
                db=new DatabaseHandler();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                db.setBalanceMinus(id_us);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                getBalance();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            disableBet();
        });

        nextb.setOnAction(event->{
            nextb.getScene().getWindow().hide();

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
            try {
                cancelBet();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }
    //win button generation
    public int[] generateButtons(int[] apples1){
        for(int i=0; i<5; i++){
            apples1[i]=0;
        }
        int k=(int)(Math.random()*5);
        apples1[k]=1;
        return apples1;
    }

    //generation of winning buttons in row#3
    public int[] generateButtons2(int[] apple) {
        int sumHelp = 0;
        for (int j = 0; j < 5; j++) {
            apple[j] = 0;
        }

        while (sumHelp != 2) {
            sumHelp = 0;
            apple[(int) (Math.random() * 5)] = 1;
            for (int j = 0; j < 5; j++) {
                sumHelp += apple[j];
            }
        }
        return apple;
    }

    //generation of winning buttons in row#4
    public int[] generateButtons3(int[] appless) {
        int sumHelp = 0;
        for (int j = 0; j < 5; j++) {
            appless[j] = 0;
        }

        while (sumHelp != 3) {
            sumHelp = 0;
            appless[(int) (Math.random() * 5)] = 1;
            for (int j = 0; j < 5; j++) {
                sumHelp += appless[j];
            }
        }
        return appless;
    }

    //generation of winning buttons in row#5
    public int[] generateButtons4(int[] apples) {

        for (int j = 0; j < 5; j++) {
            apples[j] = 1;
        }
        apples[(int) (Math.random() * 5)] = 0;
        return apples;
    }


    //if a win button is selected, the odds increase and a win message appears
    public void win(){
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbHandler.setBet1(id_us);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            double balance = Double.parseDouble(dbHandler.getBetWin(id_us));
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            resultl.setText("You won "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        able2();

    }
    //if a win button is selected, the odds increase and a win message appears
    public void win2(){
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbHandler.setBet2(id_us);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            double balance = Double.parseDouble(dbHandler.getBetWin(id_us));
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            resultl.setText("You won "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            able3();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //if a win button is selected, the odds increase and a win message appears
    public void win3(){
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbHandler.setBet3(id_us);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            double balance = Double.parseDouble(dbHandler.getBetWin(id_us));
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            resultl.setText("You won "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            able4();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //if a win button is selected, the odds increase and a win message appears
    public void win4(){
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbHandler.setBet4(id_us);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            double balance = Double.parseDouble(dbHandler.getBetWin(id_us));
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            resultl.setText("You won "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            able5();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    //if a win button is selected, the odds increase and a win message appears
    public void win5() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbHandler.setBet5(id_us);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            double balance = Double.parseDouble(dbHandler.getBetWin(id_us));
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            resultl.setText("You won "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            winBet();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        disableBet();


    }

    //balance getting method
    public void getBalance() throws SQLException, ClassNotFoundException {

        DatabaseHandler db = null;
        try {
            db=new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        double balance = db.getBalance(id_us);
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        String result = decimalFormat.format(balance);
        balancelabel.setText("Balance: "+result);

    }

    //if a non-winning button is selected, a message appears and the buttons become inactive
    public void noWin(){

            resultl.setText("You didn't win, try again! ");

        disable2();
        disable3();
        disable4();
        disable5();
        bet500.setDisable(true);

    }

    //changing the balance when a player wins
    public void winBet() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler= null;
        try {
            dbHandler = new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dbHandler.setBalancePlus(id_us);
        try {
            double balance = dbHandler.getBalance(id_us);
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String result = decimalFormat.format(balance);
            balancelabel.setText("Balance: "+result);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        disable2();
        disable3();
        disable4();
        disable5();
    }


    //buttons become inactive
    public void disable1(){
        but10.setDisable(true);
        but11.setDisable(true);
        but12.setDisable(true);
        but13.setDisable(true);
        but14.setDisable(true);
    }

    public void disable2(){
        but20.setDisable(true);
        but21.setDisable(true);
        but22.setDisable(true);
        but23.setDisable(true);
        but24.setDisable(true);
    }
    public void disable3(){
        but30.setDisable(true);
        but31.setDisable(true);
        but32.setDisable(true);
        but33.setDisable(true);
        but34.setDisable(true);
    }
    public void disable4(){
        but40.setDisable(true);
        but41.setDisable(true);
        but42.setDisable(true);
        but43.setDisable(true);
        but44.setDisable(true);
    }
    public void disable5(){
        but50.setDisable(true);
        but51.setDisable(true);
        but52.setDisable(true);
        but53.setDisable(true);
        but54.setDisable(true);
    }
    public void disableBet(){
        bet500.setDisable(true);
    }

    //buttons become active
    public void able1(){
        but10.setDisable(false);
        but11.setDisable(false);
        but12.setDisable(false);
        but13.setDisable(false);
        but14.setDisable(false);
    }
    public void able2(){
        but20.setDisable(false);
        but21.setDisable(false);
        but22.setDisable(false);
        but23.setDisable(false);
        but24.setDisable(false);
    }
    public void able3(){
        but30.setDisable(false);
        but31.setDisable(false);
        but32.setDisable(false);
        but33.setDisable(false);
        but34.setDisable(false);
    }
    public void able4(){
        but40.setDisable(false);
        but41.setDisable(false);
        but42.setDisable(false);
        but43.setDisable(false);
        but44.setDisable(false);
    }
    public void able5(){
        but50.setDisable(false);
        but51.setDisable(false);
        but52.setDisable(false);
        but53.setDisable(false);
        but54.setDisable(false);
    }

    //adding bet to database
    private void createBet(int id_us) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String bet = betf.getText();
        double betdouble = Double.parseDouble(bet);

        if (betdouble<=dbHandler.getBalance(id_us)){
            User user = new User(bet);
            dbHandler.createBet(id_us, user);
            able1();
        }
        else {
            winl.setText("You cannot place a bet that is higher than your balance");
        }
    }

    //bet reset
    private void cancelBet() throws SQLException, ClassNotFoundException {
        DatabaseHandler db = null;
        db = new DatabaseHandler();
        db.cancelBet(id_us);
    }

    //negative balance action
    public void negativeBalance() throws SQLException, ClassNotFoundException {
        DatabaseHandler db = null;
        try {
            db=new DatabaseHandler();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        double balance = db.getBalance(id_us);
        if (balance<=0){
            winl.setText("Sorry, but you have no funds on your account, you cannot continue playing ;( ");
            disableBet();
            disable1();
            disable2();
            disable3();
            disable4();
            disable5();
            stopb.setDisable(true);
            nextb.setDisable(true);
        }

    }


}
