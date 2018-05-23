package e.banking.controller;

public class Controller {
    
    public void start(){
        DatabaseSetup db = new DatabaseSetup();
        db.connectDB();
    }
}
