package com.petproject.database;

import com.petproject.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbConnection;


    public DatabaseHandler() throws SQLException, ClassNotFoundException {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println(dbConnection);
        return dbConnection;

    }
    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert= "INSERT INTO "+Const.USER_TABLE+"("+Const.USERS_NAME+","+Const.USERS_LASTNAME+","+Const.USERS_LOGIN
                +","+Const.USERS_PASSWORD+")"+"VALUES(?,?,?,?)";

        PreparedStatement prSt=getDbConnection().prepareStatement(insert);
        try {
        prSt.setString(1,user.getFirstname());
        prSt.setString(2,user.getLastname());
        prSt.setString(3,user.getLogin());
        prSt.setString(4,user.getPassword());

        prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {
        ResultSet resSet=null;

        String select = "SELECT * FROM "+ Const.USER_TABLE+" WHERE "+Const.USERS_LOGIN+"=? AND "+Const.USERS_PASSWORD+"=?";

        PreparedStatement prSt=getDbConnection().prepareStatement(select);
        try {
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());

            resSet=prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
    public double getBalance( int id) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        String query = "SELECT " + Const.USERS_BALANCE + " FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + "=" + id;
        PreparedStatement prSt = getDbConnection().prepareStatement(query);

        resSet = prSt.executeQuery();
        double idd = 0;
        while (resSet.next()) {
            idd = resSet.getDouble(1);

        }
        return idd;
    }
    public void getBet(int id) throws SQLException, ClassNotFoundException{


        String bet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"=10 "+" WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(bet);
        prSt.executeUpdate();
        String betres = "UPDATE "+Const.USER_TABLE+" SET "+Const.USER_BETRES+"=10 "+" WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSta=getDbConnection().prepareStatement(betres);
        prSta.executeUpdate();

    }

    public void setBet1(int id) throws SQLException, ClassNotFoundException {

        String setBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"="
                +Const.USER_BETRES+"*1.24"+ " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBet);
        prSt.executeUpdate();

    }
    public void setBet2(int id) throws SQLException, ClassNotFoundException {

        String setBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"="
                +Const.USER_BETRES+"*2.42"+ " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBet);
        prSt.executeUpdate();

    }
    public void setBet3(int id) throws SQLException, ClassNotFoundException {

        String setBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"="
                +Const.USER_BETRES+"*4.03"+ " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBet);
        prSt.executeUpdate();

    }
    public void setBet4(int id) throws SQLException, ClassNotFoundException {

        String setBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"="
                +Const.USER_BETRES+"*27.97"+ " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBet);
        prSt.executeUpdate();

    }
    public void setBet5(int id) throws SQLException, ClassNotFoundException {

        String setBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"="
                +Const.USER_BETRES+"*349.68"+ " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBet);
        prSt.executeUpdate();

    }
    public String getBetWin(int id) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String getBet = "SELECT " + Const.USERS_BETF + " FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + "=" + id;
        PreparedStatement prSt = getDbConnection().prepareStatement(getBet);

        resSet = prSt.executeQuery();
        String res = null;
        while (resSet.next()) {
            res = resSet.getString(1);

        }
        return res;
    }
    public void setBalancePlus(int id) throws SQLException, ClassNotFoundException {

        String setBalance = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BALANCE+"="
                +Const.USERS_BALANCE+"+"+Const.USERS_BETF +"-"+Const.USER_BETRES+
                " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBalance);
        prSt.executeUpdate();

    }
    public void setBalanceMinus(int id) throws SQLException, ClassNotFoundException {

        String setBalance = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BALANCE+"="
                +Const.USERS_BALANCE+"-"+Const.USER_BETRES+
                " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBalance);
        prSt.executeUpdate();

    }
    public void balanceMinusBet(int id) throws SQLException, ClassNotFoundException {

        String setBalancee = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BALANCE+"="
                +Const.USERS_BALANCE+"-"+Const.USERS_BETF+
                " WHERE "+Const.USERS_ID+"="+id;

        PreparedStatement prSt=getDbConnection().prepareStatement(setBalancee);
        prSt.executeUpdate();

    }
    public void createBet(int id, User user) throws SQLException, ClassNotFoundException {
        String createBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"=? "+" WHERE "+Const.USERS_ID+"="+id;
        PreparedStatement prSt=getDbConnection().prepareStatement(createBet);
        try {
            prSt.setString(1,user.getBet());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String createBetf = "UPDATE "+Const.USER_TABLE+" SET "+Const.USER_BETRES +"=? "+" WHERE "+Const.USERS_ID+"="+id;
        PreparedStatement prStf=getDbConnection().prepareStatement(createBetf);
        try {
            prStf.setString(1,user.getBet());
            prStf.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cancelBet(int id) throws SQLException, ClassNotFoundException {
        String createBet = "UPDATE "+Const.USER_TABLE+" SET "+Const.USERS_BETF +"=0"+" WHERE "+Const.USERS_ID+"="+id;
        PreparedStatement prSt=getDbConnection().prepareStatement(createBet);
            prSt.executeUpdate();
        String createBetf = "UPDATE "+Const.USER_TABLE+" SET "+Const.USER_BETRES +"=0 "+" WHERE "+Const.USERS_ID+"="+id;
        PreparedStatement prStf=getDbConnection().prepareStatement(createBetf);

            prStf.executeUpdate();

    }





}