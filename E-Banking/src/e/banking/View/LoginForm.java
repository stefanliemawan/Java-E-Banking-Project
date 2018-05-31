package e.banking.View;

import e.banking.Controller.Validation;
import e.banking.Controller.State;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LoginForm extends Form {
    
    State state = new State();
    PINForm pin = new PINForm();
    RegisterForm regis = new RegisterForm();
    MainForm main = new MainForm();
    Validation validation = new Validation();
    ErrorMessage error = new ErrorMessage();
    
    JFrame frame = new JFrame("Login");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Username    ");
    JLabel label2 = new JLabel("Password    ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    JButton button2 = new JButton("New? Register Here");
    
    public String getAcc_ID() {
        return txt1.getText();
    }
    
    public String getPassword() {
        return txt2.getText();
    }
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
    }
    
    public void txtfield() {
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
    }
        
    public void button() {
        button1.setFont(h3);
        button1.setBounds(200,180,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
            if (validation.loginVal(Integer.parseInt(getAcc_ID()),getPassword())) {
                state.setAcc_ID(getAcc_ID());
                frame.dispose();
                main.view();
            }
        });
        
        button2.setFont(p);
        button2.setBounds(200,300,200,40);
        button2.setBackground(black);
        button2.setForeground(white);
        button2.setBorder(null);
        
        button2.addMouseListener( new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(white);
                button2.setForeground(black);
            }
            public void mouseExited(MouseEvent e) {
                button2.setBackground(black);
                button2.setForeground(white);
            }
        });
        
        button2.addActionListener((ActionEvent e) -> {
            //submit
            regis.view();
        });
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
        state.changeState("Login");
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
        button();
    }
}
