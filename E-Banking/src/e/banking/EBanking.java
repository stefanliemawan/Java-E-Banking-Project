package e.banking;

import e.banking.view.View;
import e.banking.controller.Controller;

public class EBanking {
    
    public static void main(String[] args) {
            
            Controller cont = new Controller();
            cont.start();

            View view = new View();
            view.startgui();
        
        
        
    }
    
}
