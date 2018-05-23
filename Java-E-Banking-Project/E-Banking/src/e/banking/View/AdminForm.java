package e.banking.view;

import java.awt.event.*;
import javax.swing.*;

public class AdminForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Admin");
    
    JPanel panel = new JPanel();
    
    JButton button1 = new JButton("Change PIN");
    JButton button2 = new JButton("Change Password");
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(80,120,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //open change pin
            frame.dispose();
            ChPinForm ch = new ChPinForm();
            ch.view();
        });
        
        button2.setFont(h3);
        button2.setBounds(320,120,200,80);
        
        button2.addActionListener((ActionEvent e) -> {
            //open change password
            frame.dispose();
            ChPassForm ch = new ChPassForm();
            ch.view();
        });
    }
    
    public void panel() {
        panel.add(super.createBackBtn(frame,main));
        panel.add(button1);
        panel.add(button2);
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
        button();
    }
}
