package e.banking.view;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginForm extends Form {
    
    PINForm pin = new PINForm();
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Login");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Username    ");
    JLabel label2 = new JLabel("Password    ");
    
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
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(200,180,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
            frame.dispose();
            
            main.view();
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
        button();
    }
}
