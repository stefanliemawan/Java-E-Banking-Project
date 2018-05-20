package e.banking;

import java.awt.event.*;
import javax.swing.*;

public class TransactionForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Transaction");
    
    JPanel panel = new JPanel();

    JLabel label1 = new JLabel("Transfer to     ");
    JLabel label2 = new JLabel("Enter Amount    ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    JButton button2 = new JButton("Back");
    
    public void label() {
        label1.setFont(h3);
        label1.setBounds(40,20,200,25);
        
        label2.setFont(h3);
        label2.setBounds(40,80,200,25);
    }
    
    public void txtfield() {
        txt1.setFont(h3);
        txt1.setBounds(180,20,380,25);
        
        txt2.setFont(h3);
        txt2.setBounds(180,80,380,25);
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(200,160,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
        });
        
        super.createBackBtn(button2,frame,main);
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
        panel.add(button2);
    }
    
    public void view() {
        super.createForm(frame,panel);
        label();
        button();
        txtfield();
        panel();
    }
    
}
