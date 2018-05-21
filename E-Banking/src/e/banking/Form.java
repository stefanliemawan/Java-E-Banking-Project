package e.banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Form {
    
    Color black = new Color (0,0,0);
    Color white = new Color (255,255,255);
    
    Font h1 = new Font(Font.SERIF, Font.ITALIC, 40);
    Font h2 = new Font(Font.SERIF, Font.ITALIC, 24);
    Font h3 = new Font(Font.SERIF, Font.ITALIC, 18);
    Font p = new Font(Font.SERIF, Font.ITALIC, 14);
    
    int pos[] = {0,40,100,160,220,280,340};
    
    public void setLabel(JLabel label, int i) {
        label.setFont(h3);
        label.setBounds(40,pos[i],200,25);
        label.setForeground(white);
    }
    
    public void setLabel1(JLabel label, int i) {
        label.setFont(h3);
        label.setBounds(220,pos[i],200,25);
        label.setForeground(white);
    }
    
    public void setTextField(JTextField txt, int i) {
        txt.setFont(h3);
        txt.setBounds(180,pos[i],380,25);
    }
    
    public JButton createBackBtn(JFrame from, MainForm to){
        JButton button = new JButton("Back");
        button.setFont(h3);
        button.setBounds(20,320,120,40);
        
        button.addActionListener((ActionEvent e) -> {
            //back to main
            from.dispose();
            to.view();
        });
        return button;
    }
    
    public JButton createSubmitBtn(JFrame frame, MainForm main) {
        JButton button = new JButton("Submit");
        button.setFont(h3);
        button.setBounds(200,180,200,80);
        
        button.addActionListener((ActionEvent e) -> {
            //submit
            frame.dispose();
            main.view();
        });
        return button;
    }
    
    public void createForm(JFrame frame, JPanel panel) {
        
        panel.setLayout(null);
        panel.setBackground(black);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
