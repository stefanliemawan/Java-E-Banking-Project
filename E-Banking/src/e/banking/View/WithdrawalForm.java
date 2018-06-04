package e.banking.View;

import e.banking.Controller.State;
import e.banking.Controller.Validation;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawalForm extends Form {
    
    ErrorMessage error = new ErrorMessage();
    State state = new State();
    PINForm pin = new PINForm();
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Withdrawal");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Enter Amount    ");
    
    JButton button1 = super.createSubmitBtn();
    
    JTextField txt1 = new JTextField();
    
    Validation val = new Validation();
    
    public void label() {
        super.setLabel(label1,1);
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
    }
    
    public String getWithdraw() {
        return txt1.getText();
    }
    
    public void button() {
        button1.addActionListener((ActionEvent e) -> {
            //submit
            try {
                if (val.withVal(Double.parseDouble(getWithdraw()))) {
                    pin.view(Double.parseDouble(getWithdraw()), 0);
                    frame.dispose();
                }
            }catch (NumberFormatException c) {
                error.showMessageBox("Some of your input are not valid, please re-check\n" + c);
            }
        });
    }
    
    public void panel() {
        
        panel.add(label1);
        panel.add(txt1);
        panel.add(button1);
        
        panel.add(super.createBackBtn(frame,main));
    }
   
    
    public void view() {
        state.changeState("Withdrawal");
        
        super.createForm(frame, panel);
        button();
        label();
        txtfield();
        panel();
    } 
}
