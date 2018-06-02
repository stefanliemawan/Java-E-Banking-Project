package e.banking.Controller;

import e.banking.Model.DatabaseSetup;
import e.banking.View.ErrorMessage;

public class Validation {
    
    State state = new State();
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;
    
    //USE NUMBER FORMAT EXCEPTION ON VALIDATION!! (NOT YET)
    
    public boolean withVal(double withdraw) {
        int acc_id = state.getAcc_ID();
        try {
            if (withdraw > 0 && db.selectBalance(db.selectBalanceId(acc_id)) >= withdraw) val = true;
            else val = false;
        }catch(Exception e) {
            error.showMessageBox("Withdrawal Error\n" + e);
        }
        return val;
    }
    
    public boolean loginVal(int acc_id, String password) {
        try {
            if (db.selectPassword(acc_id).equals(password)) val = true;
            else val = false;
        }catch (Exception e) { 
            error.showMessageBox("Login Error, please check your username and password\n" + e);
        }
        return val;
    }
    
    public boolean pinVal(int pin) {
        try {
            if (db.selectPin(state.getAcc_ID()) == pin) val = true;
            else val = false;
        }catch (Exception e) { 
            error.showMessageBox("Pin Confirmation Error, please check your pin" + e);
        }
        return val;
    }
    
    public boolean regisVal(String first, String last, String dob, String phone, String address){
        try {
            if (db.insertBalance(0) && db.insertInfo(first,last,dob,phone,address)) val = true;
            else val =  false;
        }catch(Exception e) {
            error.showMessageBox("Register Error, please check your input\n" + e);
        }
        return val;
    }
    
    public boolean finalRegisVal(int acc_id, String password, int PIN, int info_id, int balance_id) {
        try {
            if (db.insertAccount(acc_id, password, PIN, info_id, balance_id) ) val = true;
            else val = false;
        }catch (Exception e) {
            error.showMessageBox("Register Error, please check your password and PIN\n" + e);
        }
        return val;
    }
    
    public boolean transVal(int toAcc_id){
        try {
            if (db.searchtoAccId(toAcc_id)) val = true;
            else val = false;
        }catch (Exception e) {
            error.showMessageBox("Transfer Error\n" + e);
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
