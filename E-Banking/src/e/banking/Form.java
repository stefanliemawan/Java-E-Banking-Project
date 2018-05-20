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
    
    public void createForm(JFrame frame, JPanel panel) {
        
        panel.setLayout(null);
        panel.setBackground(white);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createBackBtn(JButton button,JFrame from,MainForm to){
        button.setFont(h3);
        button.setBounds(20,320,120,40);
        
        button.addActionListener((ActionEvent e) -> {
            //back to main
            from.setVisible(false);
            from.dispose();
            to.view();
        });
    }
}
