package e.banking.view;

import javax.swing.*;

public class ChPassForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Change Password");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Old Password                ");
    JLabel label2 = new JLabel("New Password                ");
    JLabel label3 = new JLabel("Confirmation                ");
    
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    
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
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
        label();
        txtfield();
    }
}
