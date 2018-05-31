package e.banking;

import e.banking.View.View;
import e.banking.Controller.Controller;

public class EBanking {
    
    public static void main(String[] args) {
            
            Controller cont = new Controller();
            cont.start();

            View view = new View();
            view.startgui();
        
        
        
    }
    
}
