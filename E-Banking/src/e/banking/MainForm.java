package e.banking;

import java.awt.event.*;
import javax.swing.*;


public class MainForm extends Form {
    JFrame frame = new JFrame("Main");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Welcome",JLabel.CENTER);
    JLabel label2 = new JLabel("to",JLabel.CENTER);
    JLabel label3 = new JLabel("Tarada",JLabel.CENTER);
    JLabel label4 = new JLabel("E-Banking",JLabel.CENTER);
    
    JButton button1 = new JButton("Withdrawal");
    JButton button2 = new JButton("Transaction");
    JButton button3 = new JButton("Account Information");
    JButton button4 = new JButton("Admin");
    
    public void label() {
        label1.setFont(h1);
        label1.setBounds(20,40,300,100);
        label1.setForeground(white);
        
        label2.setFont(h1);
        label2.setBounds(20,100,300,100);
        label2.setForeground(white);
        
        label3.setFont(h1);
        label3.setBounds(20,160,300,100);
        label3.setForeground(white);
        
        label4.setFont(h1);
        label4.setBounds(20,220,300,100);
        label4.setForeground(white);
    }
    
    public void button(){
        button1.setFont(h3);
        button1.setBounds(360,10,220,80);
        
        button2.setFont(h3);
        button2.setBounds(360,100,220,80);
        
        button3.setFont(h3);
        button3.setBounds(360,190,220,80);
        
        button4.setFont(h3);
        button4.setBounds(360,280,220,80);
        
        button1.addActionListener((ActionEvent e) -> {
            // open withdrawal
            frame.dispose();
            WithdrawalForm with = new WithdrawalForm();
            with.view();
            
        });
        
        button2.addActionListener((ActionEvent e) -> {
            // open transaction
            frame.dispose();
            TransactionForm tran = new TransactionForm();
            tran.view();
        });
        
        button3.addActionListener((ActionEvent e) -> {
            // open account information
            frame.dispose();
            InfoForm info = new InfoForm();
            info.view();
        });
        
        button4.addActionListener((ActionEvent e) -> {
            // open admin
            frame.dispose();
            
            AdminForm admin = new AdminForm();
            admin.view();
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
    }
    
    
    public void view(){
        
        super.createForm(frame,panel);
        panel();
        label();
        button();
        
    }
    

}
