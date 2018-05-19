package e.banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mainform {
    
    JFrame frame = new JFrame("Tarada E-Banking");
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Welcome",JLabel.CENTER);
    JLabel label2 = new JLabel("to",JLabel.CENTER);
    JLabel label3 = new JLabel("Tarada",JLabel.CENTER);
    JLabel label4 = new JLabel("E-Banking",JLabel.CENTER);
    
    JButton depobtn = new JButton("Deposit");
    JButton withbtn = new JButton("Withdrawal");
    JButton tranbtn = new JButton("Transaction");
    JButton infobtn = new JButton("Account Information");
        
    Color black = new Color (0,0,0);
    Color white = new Color (255,255,255);
    
    Font font = new Font(Font.SERIF, Font.PLAIN, 50);
    
    public void panelaction(){
        panel.setLayout(null);
        panel.setBackground(white);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(depobtn);
        panel.add(withbtn);
        panel.add(tranbtn);
        panel.add(infobtn);
        }
    
    public void frameaction(){
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(700,465);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void labelaction() {
        label1.setFont(font);
        label1.setBounds(30,20,300,100);
        
        label2.setFont(font);
        label2.setBounds(30,80,300,100);
        
        label3.setFont(font);
        label3.setBounds(30,140,300,100);
        
        label4.setFont(font);
        label4.setBounds(30,200,300,100);
    }
    
    public void buttonaction(){
        depobtn.setBounds(380,5,300,100);
        
        depobtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // deposit
            }
        });
        
        withbtn.setBounds(380,110,300,100);
        
        withbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // withdrawal
            }
        });
        tranbtn.setBounds(380,215,300,100);
        
        tranbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // transaction
            }
        });
        infobtn.setBounds(380,320,300,100);
        
        infobtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // account information
            }
        });
    }
    
    public void view(){
        labelaction();
        buttonaction();
        panelaction();
        frameaction();
    }
    
    
}
