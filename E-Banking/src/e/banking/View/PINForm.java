package e.banking.view;

import java.awt.event.*;
import javax.swing.*;
import e.banking.controller.State;

public class PINForm extends Form {
    
    State state = new State();
    MainForm main = new MainForm();
    
    JDialog dialog = new JDialog();
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Enter PIN");
    
    JTextField txt1 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    
    public void setting() {
        
        label1.setBounds(40,40,200,25);
        
        txt1.setBounds(160,40,200,25);
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(100,100,200,50);
        
        button1.addActionListener((ActionEvent e) -> {
            //validation
            dialog.dispose();
            main.view();
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(txt1);
        panel.add(button1);
    }
    
    public void dialog() {
        panel.setLayout(null);
        panel.setBackground(black);
        
        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setSize(400,200);
        dialog.setLocationRelativeTo(null);
    }
    
    public void view() {
        state.changeState("PIN");
        
        super.setLabel(label1,1);
        super.setTextField(txt1,1);
        
        button();
        setting();
        panel();
        dialog();
    }
}
