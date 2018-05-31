package e.banking.controller;

import e.banking.view.ErrorMessage;


public class Validation {
    
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;
    
    //USE NUMBER FORMAT EXCEPTION ON VALIDATION!! (NOT YET)
    
    public boolean loginval(int acc_id, String password) {
        try {
            if (db.selectPassword(acc_id).equals(password)) val = true;
            else val = false;
        }catch (Exception e) { 
            error.showMessageBox("Login Error, please check your username and password\n" + e);
        }
        return val;
    }
    
    public boolean regisval(String first, String last, String dob, String phone, String address){
        try {
            if (db.insertBalance(0) && db.insertInfo(first,last,dob,phone,address)) val = true;
            else val =  false;
        }catch(Exception e) {
            error.showMessageBox("Register Error, please check your input\n" + e);
        }
        return val;
    }
    
    public boolean FinalRegisVal(int acc_id, String password, int PIN, int info_id, int balance_id) {
        try {
            if (db.insertAccount(acc_id, password, PIN, info_id, balance_id) ) val = true;
            else val = false;
        }catch (Exception e) {
            error.showMessageBox("Register Error, please check your password and PIN\n" + e);
        }
        return val;
    }
    
    public int getLastInfo_ID() {
        return db.selectLastInfo_ID();
    }
    
    public int getLastBalance_ID() {
        return db.selectLastBalance_ID();
    }
    
    public String getLastDOB() {
        return db.selectLastDOB();
    }
    
    
}
