package e.banking.view;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class ErrorMessage {
    //show error message from exception
    
    public void showMessageBox(String message) {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
