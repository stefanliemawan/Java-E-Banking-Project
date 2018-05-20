package e.banking;

import java.awt.event.*;
import javax.swing.*;

public class AdminForm extends Form {
    
    MainForm main = new MainForm();
    
    JFrame frame = new JFrame("Admin");
    
    JPanel panel = new JPanel();
    
    public void panel() {
        panel.add(super.createBackBtn(frame,main));
    }
    
    public void view() {
        super.createForm(frame,panel);
        panel();
    }
}
