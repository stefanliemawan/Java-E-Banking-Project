package e.banking.View;

import e.banking.Controller.State;
import e.banking.Controller.Validation;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    Validation val = new Validation();
    // Validation = val.transVal(Integer.parseInt(get_toAccid()));
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
    }
    
    public String get_toAccid() {
        return txt1.getText();
    }
    
    public double getAmount(){
        return Double.parseDouble(txt2.getText());
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
        panel.add(super.createSubmitBtn(frame,pin,val.transVal(Integer.parseInt(get_toAccid()))));
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
