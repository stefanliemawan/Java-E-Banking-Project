package e.banking.Controller;

public class State {
    
    private static String state;

    private static int acc_id;

    public void changeState(String statenow) {
        state = statenow;
    }
    
    public void setAcc_ID(String id) {
        acc_id = Integer.parseInt(id);
    }
    
    public int getAcc_ID() {
        System.out.println(acc_id);
        return acc_id;
    }
}
