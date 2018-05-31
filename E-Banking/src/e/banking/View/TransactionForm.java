package e.banking.view;

import javax.swing.*;
import e.banking.controller.State;

public class TransactionForm extends Form {
    
    State state = new State();
    PINForm pin = new PINForm();
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Transaction");
    
    JPanel panel = new JPanel();

    JLabel label1 = new JLabel("Transfer to     ");
    JLabel label2 = new JLabel("Enter Amount    ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
        panel.add(super.createSubmitBtn(frame,pin));
        panel.add(super.createBackBtn(frame,main));
    }
    
    public void view() {
        state.changeState("Transaction");
        
        super.createForm(frame,panel);
        label();
        txtfield();
        panel();
    }
    
}
