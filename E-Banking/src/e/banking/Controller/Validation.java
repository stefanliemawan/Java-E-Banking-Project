package e.banking.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import e.banking.view.ErrorMessage;
import java.sql.SQLException;


public class Validation {
    
    private Statement stm = null;
    private ResultSet rs = null;
    private String query = null;
    
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;
    
    public boolean regisval(String first, String last, String dob, String phone, String address){
        if (db.insertInfo(first,last,dob,phone,address)) return true;
        else return false;
    }

    
    public boolean loginval(String acc_id, String pass) {
        try {
            query = "SELECT * FROM ACCOUNT WHERE acc_id ="+acc_id; // semua query pindah ke dbsetup kalo bisa
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
    
}
