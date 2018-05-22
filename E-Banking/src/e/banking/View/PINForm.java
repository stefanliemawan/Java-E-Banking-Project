package e.banking.view;

import java.awt.event.*;
import javax.swing.*;

public class PINForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("PIN");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Enter PIN");
    
    JTextField txt1 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    
    public void setting() {
        frame.setSize(400,200);
        
        label1.setBounds(40,40,200,25);
        
        txt1.setBounds(160,40,200,25);
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(100,100,200,50);
        
        button1.addActionListener((ActionEvent e) -> {
            //validation
            frame.dispose();
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(txt1);
        panel.add(button1);
    }
    
    public void view() {
        super.createForm(frame,panel);
        super.setLabel(label1,1);
        super.setTextField(txt1,1);
        
        button();
        setting();
        panel();
    }
}
