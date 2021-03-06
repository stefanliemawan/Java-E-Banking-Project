package e.banking.View;

import e.banking.Controller.State;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminForm extends Form {
    
    State state = new State();
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Admin");
    
    JPanel panel = new JPanel();
    
    JButton button1 = new JButton("Change PIN");
    JButton button2 = new JButton("Change Password");
    JButton button3 = new JButton("Log Out");
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(80,120,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //open change pin
            frame.dispose();
            ChPinForm ch = new ChPinForm();
            ch.view();
        });
        
        button2.setFont(h3);
        button2.setBounds(320,120,200,80);
        
        button2.addActionListener((ActionEvent e) -> {
            //open change password
            frame.dispose();
            ChPassForm ch = new ChPassForm();
            ch.view();
        });
        
        button3.setFont(h3);
        button3.setBounds(460,320,120,40);
        button3.addActionListener((ActionEvent e) -> {
            //open change password
            frame.dispose();
            LoginForm login = new LoginForm();
            login.view();
        });
    }
    
    public void panel() {
        panel.add(super.createBackBtn(frame,main));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    }
    
    public void view() {
        state.changeState("Admin");
        super.createForm(frame,panel);
        panel();
        button();
    }
}
