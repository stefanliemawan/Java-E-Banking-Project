package e.banking.Controller;

public class State {
    
    private static String state; // Determining the state of the program

    private static int acc_id;

    public void changeState(String statenow) { // Change the current State
        state = statenow;
    }
    
    public String getState(){ // Return current State
        return state;
    }
            
    public void setAcc_ID(String id) { // Set Acc_ID as the user currently logged in
        acc_id = Integer.parseInt(id);
    }
    
    public int getAcc_ID() { // Return the Acc_ID
        System.out.println(acc_id);
        return acc_id;
    }
}
