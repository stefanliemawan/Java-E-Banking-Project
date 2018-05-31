package e.banking.view;

import e.banking.controller.State;
import javax.swing.*;

public class WithdrawalForm extends Form {
    
    State state = new State();
    PINForm pin = new PINForm();
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Withdrawal");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Enter Amount    ");
    
    JButton button1 = new JButton("Submit");
    
    JTextField txt1 = new JTextField();
    
    public void label() {
        super.setLabel(label1,1);
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(txt1);
        panel.add(button1);
        panel.add(super.createSubmitBtn(frame,pin));
        panel.add(super.createBackBtn(frame,main));
    }
   
    
    public void view() {
        state.changeState("Withdrawal");
        
        super.createForm(frame, panel);
        label();
        txtfield();
        panel();
    }
}
