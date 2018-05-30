package e.banking.controller;

import e.banking.view.ErrorMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseSetup {
    
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null; 
    private String query = null;
    private String url = "jdbc:mysql://localhost/ebanking?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "lala";
    
    
    ErrorMessage error = new ErrorMessage();
    
    public void connectDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException e){
            error.showMessageBox("Error when connecting to database\n" + e);
        }
    }
    
    public boolean insertAccount(int id, String pass, int pin, int info_id, int balance_id) {
        connectDB();
        try {
            query = "INSERT INTO Account VALUES("+id+",\""+pass+"\","+pin+","+","+info_id+","+balance_id+");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Account Table\n" + e);
            return false;
        }
    }
    
    public boolean insertBalance(double balance) {
        connectDB();
        try {
            query = "INSERT INTO Balance VALUES(NULL,"+balance+");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Balance Table\n" + e);
            return false;
        }
    }
    
    public boolean insertInfo(String fname, String lname, String dob, String phone, String address) {
        connectDB();
        try {
            query = "INSERT INTO Info VALUES(NULL,\""+fname+"\",\""+lname+"\",\""+dob+"\",\""+phone+"\",\""+address+"\");";
            stm.executeUpdate(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Info Table\n" + e);
            return false;
        }
    }
    
    public boolean insertTransaction(int acc_id, int type_id, int to_id, int quantity, String date) {
        connectDB();
        try {
            query = "INSERT INTO Transaction VALUES(NULL,"+acc_id+","+type_id+","+to_id+","+quantity+",\""+date+"\");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Transaction Table\n" + e);
            return false;
        }
    }
    
    public boolean insertType(String name) {
        connectDB();
        try {
            query = "INSERT INTO Type VALUES(NULL,\""+name+"\");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Type Table\n" + e);
            return false;
        }
    }
    
}
