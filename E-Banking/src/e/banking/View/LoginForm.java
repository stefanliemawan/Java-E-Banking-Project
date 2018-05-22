package e.banking.view;

import java.awt.event.*;
import javax.swing.*;

public class LoginForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Login");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Username    ");
    JLabel label2 = new JLabel("Password    ");
    
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
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(super.createSubmitBtn(frame,main));
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
    }
}
