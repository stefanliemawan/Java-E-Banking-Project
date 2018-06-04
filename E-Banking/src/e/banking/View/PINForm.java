package e.banking.View;

import e.banking.Controller.State;
import e.banking.Controller.Validation;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PINForm extends Form {
    
    ErrorMessage error = new ErrorMessage();
    State state = new State();
    MainForm main = new MainForm();
    Validation val = new Validation();
    
    JDialog dialog = new JDialog();
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Enter PIN");
    
    JPasswordField txt1 = new JPasswordField();
    
    JButton button1 = new JButton("Submit");
    
    public void setting() {
        
        label1.setBounds(40,40,200,25);
        
        txt1.setBounds(160,40,200,25);
    }

    public int getPIN(){
        return Integer.parseInt(txt1.getText());
    }
    
    public String getPin(){
        return txt1.getText();
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(100,100,200,50);
        
        button1.addActionListener((ActionEvent e) -> {
            //validation
            if (val.pinVal(Integer.parseInt(getPin()))) {
                dialog.dispose();
                main.view();
            }else {
                error.showMessageBox("Some of your input are not valid, please re-check\n");
            }
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
