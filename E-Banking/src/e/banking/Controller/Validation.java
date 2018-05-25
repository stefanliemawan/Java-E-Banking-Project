package e.banking.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import e.banking.view.ErrorMessage;


public class Validation {
    
    private Statement stm;
    private ResultSet rs;
    private String query;
    
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    boolean val = false;
    
    public void regisval(String first, String last, String phone, String address, String dob){
        db.connectDB();
        db.insertInfo(first, last , dob , phone , address);
    }

    
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
        }catch (Exception e) {
            error.showMessageBox("Login Error, " + e);
        }
        return val;
    }
    
}
