package e.banking.Controller;

import e.banking.Model.DatabaseSetup;
import e.banking.View.ErrorMessage;

public class Validation {
    
    State state = new State();
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;

    //change old to new pin
    public void updatePIN(int acc_id,int pin){
        db.ChangePIN(acc_id, pin);
    }






    //change old to new password
    public void updatePass(int acc_id,String pass){
        db.ChangePassword(acc_id, pass);
    }

    //confirm new PIN
    public boolean ConfirmNewPIN(String pin1, String pin2){
        try{
            if(pin1.equals(pin2))val = true;
            else val = false;
        }catch(Exception e){
            error.showMessageBox("new PIN confirmation error\n"+e);
        }
        return val;
    }

    //confirm new password
    public boolean ConfirmNewPass(String pass1, String pass2){
        try{
            if(pass1.equals(pass2))val = true;
            else val = false;
        }catch(Exception e){
            error.showMessageBox("new Password confirmation error\n"+e);
        }
        return val;
    }

    //oldPINValidation
    public boolean OldPIN(int acc_id, int pin) {
        try {
            if (db.selectPIN(state.getAcc_ID())==pin) val = true;
            else val = false;
        }catch (Exception e) {
            error.showMessageBox("Old PIN is invalid mistake in validation\n" + e);
        }
        return val;
    }

    //oldPassValidation
    public boolean OldPass(int acc_id, String password) {
        try {

            if (db.selectPassword(state.getAcc_ID()).equals(password)) {val = true;}
            else val = false;
        }catch (Exception e) {
            error.showMessageBox("Old password is invalid\n" + e);
        }
        return val;
    }


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
