package e.banking.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import e.banking.view.ErrorMessage;
import java.sql.SQLException;


public class Validation {
    
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private String query = null;
    
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;
    
    // REGIS VALIDATION PISAH FILE AJA(?)    (1 VALIDATION 1 FILE)
    // REGIV VAL KALO ABORT REGISTERCONFRIMATION FORM BALANCE & INFO KEINPUT TAPI ACCOUNT GK
    
    public boolean loginval(String acc_id, String pass) {
        db.connectDB();
        try {
            query = "SELECT * FROM ACCOUNT WHERE acc_id ="+acc_id;
            rs = stm.executeQuery(query);
            if (rs.getString("password") == pass) {
                val =  true;
            }
            else {
                val =  false;
            }
        }catch (SQLException e) {
            error.showMessageBox("Login Error, " + e);
        }
        return val;
    }
    
    public boolean regisval(String first, String last, String dob, String phone, String address){
        if (db.insertBalance(0) && db.insertInfo(first,last,dob,phone,address)) return true;
        else return false;
    }
    
    public boolean FinalRegisVal(int acc_id, String password, int PIN, int info_id, int balance_id) {
        if (db.insertAccount(acc_id, password, PIN, info_id, balance_id) ) return true;
        else return false;
    }
    
    public int getLastInfo_ID() {
        return db.SelectLastInfo_ID();
    }
    
    public int getLastBalance_ID() {
        return db.SelectLastBalance_ID();
    }
    
    public String getLastDOB() {
        return db.SelectLastDOB();
    }
    
    
}
