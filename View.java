package e.banking;

import java.awt.Color;
import javax.swing.*;

public class View {
    JFrame frame = new JFrame("View");
    JPanel panel = new JPanel();
    JButton button = new JButton("Button");
    JLabel label = new JLabel("Label");
        
    Color black = new Color (0,0,0);
    Color white = new Color (255,255,255);
    
    public void gui(){
        label.setForeground(white);
        
        button.setBackground(white);
        
        panel.setBackground(black);
        panel.add(label);
        panel.add(button);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
        
    
}
