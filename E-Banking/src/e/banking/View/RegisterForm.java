package e.banking.View;

import e.banking.Controller.Validation;
import e.banking.Controller.State;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterForm extends Form {
    
    State state = new State();
    RegisterConfirmationForm confirm = new RegisterConfirmationForm();
    Validation val = new Validation();
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Register");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("First Name      ");
    JLabel label2 = new JLabel("Last Name       ");
    JLabel label3 = new JLabel("Date of Birth   ");
    JLabel label4 = new JLabel("Phone Number    ");
    JLabel label5 = new JLabel("Address         ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    JTextField txt4 = new JTextField();
    JTextField txt5 = new JTextField();
    
    JButton button1 = new JButton("Submit");
    
    public String getFirstName(){
        return txt1.getText();
    }
    
    public String getLastName(){
        return txt2.getText();
    }
    
    public String getDOB(){
        return txt3.getText();
    }
    
    public String getPhone(){
        return txt4.getText();
    }
    
    public String getAddress(){
        return txt5.getText();
    }
    
    public void setting() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
        super.setLabel(label4,4);
        super.setLabel(label5,5);
        
        super.setTextField(txt1,1);
        super.setTextField(txt2,2);
        super.setTextField(txt3,3);
        super.setTextField(txt4,4);
        super.setTextField(txt5,5);
    }
    
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(360,320,200,40);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
            if (val.regisVal(getFirstName(),getLastName(),getDOB(),getPhone(),getAddress())){
                frame.dispose();
                confirm.view();
                confirm.setText(getFirstName(),getLastName(),getDOB(),getPhone(),getAddress());
            }
            
        });
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(txt4);
        panel.add(txt5);
        panel.add(button1);
    }
    
    public void view() {
        state.changeState("Register");
        super.createForm(frame,panel);
        setting();
        panel();
        button();

    }
    
}
