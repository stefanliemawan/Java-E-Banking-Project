package e.banking;

import e.banking.view.View;
import e.banking.controller.Controller;

public class EBanking {
    
    public static void main(String[] args) {
        View view = new View();
        view.startgui();
        
        Controller cont = new Controller();
        cont.start();
    }
    
}
