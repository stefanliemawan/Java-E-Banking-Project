package e.banking.View;

import java.awt.event.ActionEvent;
import e.banking.Controller.State;
import e.banking.Controller.Validation;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChPassForm extends Form {
    
    State state = new State();
    MainForm main = new MainForm();
    Validation validation = new Validation();
    
    JFrame frame = new JFrame("Change Password");
    
    JPanel panel = new JPanel();
    
    JButton button = new JButton("Submit");
    
    JLabel label1 = new JLabel("Old Password                ");
    JLabel label2 = new JLabel("New Password                ");
    JLabel label3 = new JLabel("Confirmation                ");
    
    JPasswordField txt1 = new JPasswordField();
    JPasswordField txt2 = new JPasswordField();
    JPasswordField txt3 = new JPasswordField();

    public String getOldPassword(){
        return txt1.getText();
    }

    public String getNewPassword(){
        return txt2.getText();
    }

    public String confirmNewPass(){
        return txt3.getText();
    }
    
    public void button() {
        button.setFont(h3);
        button.setBounds(200,220,200,80);

        //changing old pass to new pass
        button.addActionListener((ActionEvent e) -> {
            if(validation.OldPass(state.getAcc_ID(),getOldPassword()) && validation.ConfirmNewPass(confirmNewPass(),getNewPassword()) ){
                validation.updatePass(state.getAcc_ID(),getNewPassword());

                System.out.println(getNewPassword());
                System.out.println(state.getAcc_ID());
                frame.dispose();

                main.view();
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
        state.changeState("ChangePassword");
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
        button();
    }


}
