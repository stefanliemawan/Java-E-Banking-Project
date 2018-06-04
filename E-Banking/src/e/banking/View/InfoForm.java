package e.banking.View;

import e.banking.Controller.State;
import e.banking.Controller.Validation;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoForm extends Form {

    State state = new State();
    HistoryForm history = new HistoryForm();
    MainForm main = new MainForm();
    Validation val = new Validation();
    
    JFrame frame = new JFrame("Info");
    
    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Account ID          ");
    JLabel label2 = new JLabel("Account Balance     ");
    JLabel label3 = new JLabel("PIN                 ");
    
    JLabel label11 = new JLabel(Integer.toString(state.getAcc_ID()));
    JLabel label12 = new JLabel(Double.toString(val.getAccInfo()));
    JLabel label13 = new JLabel("*************");
    
    JButton button1 = new JButton("History");
    
    public void label() {
        super.setLabel(label1,1);
        super.setLabel(label2,2);
        super.setLabel(label3,3);
        
        super.setLabel1(label11,1);
        super.setLabel1(label12,2);
        super.setLabel1(label13,3);
    }
    
    public void panel() {
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(button1);
        panel.add(super.createBackBtn(frame,main));
    }
    
    public void button() {
        button1.setFont(h3);
        button1.setBounds(380,280,200,80);
        
        button1.addActionListener((ActionEvent e) -> {
            //history
            history.dialog.dispose();
            history.dialog.validate();
            history.dialog.repaint();
            history.view();
        });   
    }
    
    public void view() {
        state.changeState("Info");
        super.createForm(frame,panel);
        button();
        label();
        panel();
    }
}
