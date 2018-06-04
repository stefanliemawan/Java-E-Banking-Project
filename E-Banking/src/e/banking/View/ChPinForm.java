package e.banking.View;

import java.awt.event.ActionEvent;
import e.banking.Controller.State;
import e.banking.Controller.Validation;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChPinForm extends Form {

    State state = new State();
    MainForm main = new MainForm();
    Validation validation = new Validation();
    ErrorMessage error = new ErrorMessage();
    
    JFrame frame = new JFrame("Change PIN");
    
    JPanel panel = new JPanel();
    
    JButton button = super.createSubmitBtn();
    
    JLabel label1 = new JLabel("Old PIN                ");
    JLabel label2 = new JLabel("New PIN                ");
    JLabel label3 = new JLabel("Confirmation           ");
    
    JPasswordField txt1 = new JPasswordField();
    JPasswordField txt2 = new JPasswordField();
    JPasswordField txt3 = new JPasswordField();

    public int getOldPIN(){
        return Integer.parseInt(txt1.getText());
    }

    public String getNewPIN(){
        return txt2.getText();
    }

    public String getconfirmPIN(){
        return txt3.getText();
    }


    public void button() {
        button.setBounds(220,220,200,80);
        
        button.addActionListener((ActionEvent e) -> {
            //submit
            if(validation.confirmNewPIN(getNewPIN(),getconfirmPIN()) && validation.confirmOldPIN(state.getAcc_ID(),getOldPIN())){
                validation.updatePIN(state.getAcc_ID(),Integer.parseInt(getNewPIN()));
                frame.dispose();
                main.view();
            }else {
                error.showMessageBox("Some of your input are not valid, please re-check\n");
            }
        });
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
        super.setTextField(txt3,3);
    }
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
    }
    
    public void panel() {
        panel.add(super.createBackBtn(frame,main));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(button);
    }
    
    public void view() {
        state.changeState("ChangePIN");
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
        button();
    }
}
