package e.banking;

import java.awt.event.*;
import javax.swing.*;

public class InfoForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Info");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Account Number      ");
    JLabel label2 = new JLabel("Account Balance     ");
    JLabel label3 = new JLabel("PIN                 ");
    
    JLabel label11 = new JLabel("//Acount Number");
    JLabel label12 = new JLabel("//Account Balance");
    JLabel label13 = new JLabel("******");
    
    JButton button1 = new JButton("History");
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
        
        super.setLabel1(label11,1);
        super.setLabel1(label12,2);
        super.setLabel1(label13,3);
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(button1);
        panel.add(super.createBackBtn(frame,main));
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(380,280,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //history
        });   
    }
    
    public void view() {
        super.createForm(frame,panel);
        button();
        label();
        panel();
    }
}
