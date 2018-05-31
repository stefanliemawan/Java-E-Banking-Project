package e.banking.controller;

import e.banking.view.LoginForm;


public class State {
    
    LoginForm login = new LoginForm();
    
    private static String state;
    private int acc_id;
    
    public void changeState(String statenow) {
        state = statenow;
        
        if (state == "login") {
            setAcc_ID();
        }
    }
    
    public void setAcc_ID() {
        acc_id = Integer.parseInt(login.getAcc_ID());
    }
    
    public int getAcc_ID() {
        return acc_id;
    }
}
