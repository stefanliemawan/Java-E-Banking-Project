package e.banking.view;

import java.awt.event.*;
import javax.swing.*;

public class RegisterForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Register");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("First Name      ");
    JLabel label2 = new JLabel("Last Name       ");
    JLabel label3 = new JLabel("Phone Number    ");
    JLabel label4 = new JLabel("Address         ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    JTextField txt4 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    
    public void setting() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
        super.setLabel(label4,4);
        
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
        super.setTextField(txt3,3);
        super.setTextField(txt4,4);
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(360,280,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
            frame.dispose();
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(txt4);
        panel.add(button1);
    }
    
    public void view() {
        super.createForm(frame,panel);
        setting();
        panel();
        button();
    }
    
}