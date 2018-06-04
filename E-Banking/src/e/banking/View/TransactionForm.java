package e.banking.View;

import e.banking.Controller.State;
import e.banking.Controller.Validation;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransactionForm extends Form {
    
    State state = new State();
    PINForm pin = new PINForm();
    Validation val = new Validation();
    MainForm main = new MainForm();
    ErrorMessage error = new ErrorMessage();
    
    JFrame frame = new JFrame("Transaction");
    
    JPanel panel = new JPanel();

    JButton button1 = super.createSubmitBtn();
    
    JLabel label1 = new JLabel("Transfer to     ");
    JLabel label2 = new JLabel("Enter Amount    ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    
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
    
    public String getAmount(){
        return txt2.getText();
    }
    
    public void button() {
        button1.addActionListener((ActionEvent e) -> {
            //submit
            try {
                if (val.transVal(Integer.parseInt(get_toAccid()))) {
                    pin.view(Double.parseDouble(getAmount()), Integer.parseInt(get_toAccid()));
                    frame.dispose();
                }
            }catch (NumberFormatException c) {
                error.showMessageBox("Some of your input are not valid, please re-check\n" + c);
            }
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
        
        panel.add(super.createBackBtn(frame,main));
    }
    
    public void view() {
        state.changeState("Transaction");
        
        super.createForm(frame,panel);
        button();
        label();
        txtfield();
        panel();
    }  
}
