package e.banking.Controller;

import e.banking.Model.DatabaseSetup;
import e.banking.View.ErrorMessage;

public class Validation {
    
    State state = new State();
    DatabaseSetup db = new DatabaseSetup();
    ErrorMessage error = new ErrorMessage();  
    
    static boolean val = false;

    public boolean withVal(double withdraw) {
        int acc_id = state.getAcc_ID();
        if (withdraw > 0 && db.selectBalance(db.selectBalanceId(acc_id)) >= withdraw) return true;
        else return false;
    }
    
    public boolean loginVal(int acc_id, String password) {
        if (db.selectPassword(acc_id).equals(password)) return true;
        else return false;
    }
    
    public boolean pinVal(int pin, double amount, int toacc_id) {
        int acc_id = state.getAcc_ID();

        if (db.selectPIN(state.getAcc_ID()) == pin){
            if (state.getState().equalsIgnoreCase("Withdrawal")){
                db.withdraw(acc_id, amount);
                db.insertHistoryWith(acc_id, amount);
            }
            else if(state.getState().equalsIgnoreCase("Transaction")){
                db.trans(acc_id, amount, toacc_id);
                db.insertHistoryTrans(acc_id, amount, toacc_id);
            }
            else error.showMessageBox("Form Source undefined...\n");
            return true;
        }
        else return false;
    }
    
    public boolean regisVal(String first, String last, String dob, String phone, String address){
        if (db.insertBalance(1000000) && db.insertInfo(first,last,dob,phone,address)) return true;
        else return false;
    }
    
    public boolean finalRegisVal(int acc_id, String password, int PIN, int info_id, int balance_id) {
        if (db.insertAccount(acc_id, password, PIN, info_id, balance_id) ) return true;
        else return false;
    }
    
    public boolean transVal(double amount, int toAcc_id){
        int acc_id = state.getAcc_ID();

        if (db.searchtoAccId(toAcc_id) && db.selectBalance(db.selectBalanceId(acc_id))>=amount) return true;
        else return false;
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
    
    //change old to new pin
    public void updatePIN(int acc_id,int pin){
        db.ChangePIN(acc_id, pin);
    }

    //change old to new password
    public void updatePass(int acc_id,String pass){
        db.ChangePassword(acc_id, pass);
    }

    //confirm new PIN
    public boolean confirmNewPIN(String pin1, String pin2){
        if(pin1.equals(pin2)) return true;
        else return false;
    }

    //confirm new password
    public boolean confirmNewPass(String pass1, String pass2){
        if(pass1.equals(pass2)) return true;
        else return false;
    }

    //oldPINValidation
    public boolean confirmOldPIN(int acc_id, int pin) {
        if (db.selectPIN(state.getAcc_ID())==pin) return true;
        else return false;
    }

    //oldPassValidation
    public boolean confirmOldPass(int acc_id, String password) {
        if (db.selectPassword(state.getAcc_ID()).equals(password)) return true;
        else return false;
    }
    
    public double getAccInfo() {
        return db.selectBalance(db.selectBalanceId(state.getAcc_ID()));
    }
}
