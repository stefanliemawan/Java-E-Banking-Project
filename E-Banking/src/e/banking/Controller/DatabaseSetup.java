package e.banking.controller;

import e.banking.view.ErrorMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseSetup {
    
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    private String url = "jdbc:mysql://localhost/ebanking?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "lala";
    private String query;
    
    ErrorMessage error = new ErrorMessage();
    
    public void connectDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(Exception e){
            error.showMessageBox("Error when connecting to database, " + e);
        }
    }
    
    public void insertAccount(int id, String pass, int pin, int info_id, int balance_id) {
        try {
            query = "INSERT INTO Account VALUES("+id+pass+pin+info_id+balance_id+");";
            stm.execute(query);
        }catch (Exception e) {
            error.showMessageBox("Error when inserting into Account Table, " + e);
        }
    }
    
    public void insertBalance(double balance) {
        try {
            query = "INSERT INTO Balance VALUES(NULL"+balance+");";
            stm.execute(query);
        }catch (Exception e) {
            error.showMessageBox("Error when inserting into Balance Table, " + e);
        }
    }
    
    public void insertInfo(String fname, String lname, String dob, String phone, String address) {
        try {
            query = "INSERT INTO Info VALUES(NULL"+fname+lname+dob+phone+address+");";
            stm.execute(query);
        }catch (Exception e) {
            error.showMessageBox("Error when inserting into Info Table, " + e);
        }
    }
    
    public void insertTransaction(int acc_id, int type_id, int to_id, int quantity, String date) {
        try {
            query = "INSERT INTO Transaction VALUES(NULL"+acc_id+type_id+to_id+quantity+date+");";
            stm.execute(query);
        }catch (Exception e) {
            error.showMessageBox("Error when inserting into Transaction Table, " + e);
        }
    }
    
    public void insertType(String name) {
        try {
            query = "INSERT INTO Type VALUES(NULL"+name+");";
            stm.execute(query);
        }catch (Exception e) {
            error.showMessageBox("Error when inserting into Type Table, " + e);
        }
    }
    
}
