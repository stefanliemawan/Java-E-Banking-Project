package e.banking.View;

import e.banking.Controller.Validation;
import e.banking.Controller.State;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class RegisterConfirmationForm extends Form {
    
    State state = new State();
    Validation val = new Validation();
    ErrorMessage error = new ErrorMessage();
    
    JDialog dialog = new JDialog();
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("First Name          : ");
    JLabel label2 = new JLabel("Last Name           : ");
    JLabel label3 = new JLabel("Date of Birth       : ");
    JLabel label4 = new JLabel("Phone Number    : ");
    JLabel label5 = new JLabel("Address             : ");
    JLabel label6 = new JLabel("PLEASE CHECK THAT THE DATA ABOVE ARE COMPLETELY TRUE");
    JLabel label7 = new JLabel("Your Account ID : ");
    JLabel label8 = new JLabel("Set Password    : ");
    JLabel label9 = new JLabel("Set PIN     : ");
    
    JLabel label11 = new JLabel();
    JLabel label12 = new JLabel();
    JLabel label13 = new JLabel();
    JLabel label14 = new JLabel();
    JLabel label15 = new JLabel();
    JLabel label17 = new JLabel();
    
    JPasswordField txt1 = new JPasswordField();
    JPasswordField txt2 = new JPasswordField();
    
    JButton button1 = new JButton("Submit");
    
    public String getPass() {
        return txt1.getText();
    }
    
    public int getPIN() { //ERROR, NUMBERFORMATEXCEPTION
        return Integer.parseInt(txt2.getText());
    }
    
    public int generateAcc_ID() {

        String id = Integer.toString(val.getLastInfo_ID());
        String dob = val.getLastDOB();
        
        char y1 = dob.charAt(2);
        char y2 = dob.charAt(3);
        char m1 = dob.charAt(5);
        char m2 = dob.charAt(6);
        char d1 = dob.charAt(8);
        char d2 = dob.charAt(9);
        
        String acc_id = id+y1+y2+m1+m2+d1+d2;
        return Integer.parseInt(acc_id);
    } 
    
    public void setText(String fname, String lname, String dob, String phone_num, String address) {
        
        label11.setText(fname);
        label12.setText(lname);
        label13.setText(dob);
        label14.setText(phone_num);
        label15.setText(address);
        if (val.getLastInfo_ID() < 10) label17.setText("0"+Integer.toString(generateAcc_ID()));
        else label17.setText(Integer.toString(generateAcc_ID()));
        
    }
    
    public void setting() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
        super.setLabel(label4,4);
        super.setLabel(label5,5);
        super.setLabel(label6,6);
        label6.setBounds(40,pos[6],700,25);
        super.setLabel(label7,7);
        super.setLabel(label8,8);
        super.setLabel(label9,9);
        
        super.setLabel1(label11,1);
        super.setLabel1(label12,2);
        super.setLabel1(label13,3);
        super.setLabel1(label14,4);
        super.setLabel1(label15,5);
        super.setLabel1(label17,7);
        
        super.setTextField(txt1,8);
        txt1.setBounds(180,pos[8],280,25);
        super.setTextField(txt2,9);
        txt2.setBounds(180,pos[9],280,25);
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(560,440,200,100);
        
        button1.addActionListener((ActionEvent e) -> {
            //submit
            try {
                if(val.finalRegisVal(generateAcc_ID(), getPass(), getPIN(), val.getLastInfo_ID(), val.getLastBalance_ID()))
                dialog.dispose();
            }catch (NumberFormatException c) {
                error.showMessageBox("Some of your input are not valid, please re-check\n" + c);
            }
        });
    }
    
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(label14);
        panel.add(label15);
        panel.add(label17);
        panel.add(txt1);
        panel.add(txt2);
        panel.add(button1);
    }
    
    public void dialog() {
        panel.setLayout(null);
        panel.setBackground(black);
        
        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setSize(800,600);
        dialog.setLocationRelativeTo(null);
    }
    
    public void view() {
        state.changeState("RegisterConfirmtion");
        
        button();
        setting();
        panel();
        dialog();
    }
}
