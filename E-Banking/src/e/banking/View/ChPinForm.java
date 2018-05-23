package e.banking.view;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class ChPinForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Change PIN");
    
    JPanel panel = new JPanel();
    
    JButton button = new JButton("Submit");
    
    JLabel label1 = new JLabel("Old PIN                ");
    JLabel label2 = new JLabel("New PIN                ");
    JLabel label3 = new JLabel("Confirmation           ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    
    public void button() {
        button.setFont(h3);
        button.setBounds(220,220,200,80);
        
        button.addActionListener((ActionEvent e) -> {
            //submit
            frame.dispose();
            
            main.view();
        });
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
        super.setTextField(txt3,3);
    }
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
    }
    
    public void panel() {
        panel.add(super.createBackBtn(frame,main));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(button);
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
        button();
    }
}
