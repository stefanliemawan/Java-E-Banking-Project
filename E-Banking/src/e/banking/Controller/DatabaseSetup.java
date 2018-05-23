package e.banking.controller;

import e.banking.view.ErrorMessage;

import java.time.LocalDate;
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
            error.showMessageBox(e);
        }
    }
    
    public void insertAccount(int id, String pass, int pin, int info_id, int balance_id) {
        try {
            query = "INSERT INTO Account VALUES("+id+pass+pin+info_id+balance_id+");";
            rs = stm.executeQuery(query);
        }catch (Exception e) {
            error.showMessageBox(e);
        }
    }
    
    public void insertBalance(double balance) {
        try {
            query = "INSERT INTO Balance VALUES("+balance+");";
            rs = stm.executeQuery(query);
        }catch (Exception e) {
            error.showMessageBox(e);
        }
    }
    
    public void insertInfo(String fname, String lname, LocalDate dob, String phone, String address) {
        try {
            query = "INSERT INTO Info VALUES("+fname+lname+dob+phone+address+");";
            rs = stm.executeQuery(query);
        }catch (Exception e) {
            error.showMessageBox(e);
        }
    }
    
    public void insertTransaction(int acc_id, int type_id, int to_id, int quantity, LocalDate date) {
        try {
            query = "INSERT INTO Transaction VALUES("+acc_id+type_id+to_id+quantity+date+");";
            rs = stm.executeQuery(query);
        }catch (Exception e) {
            error.showMessageBox(e);
        }
    }
    
    public void insertType(String name) {
        try {
            query = "INSERT INTO Type VALUES("+name+");";
            rs = stm.executeQuery(query);
        }catch (Exception e) {
            error.showMessageBox(e);
        }
    }
    
}
