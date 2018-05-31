package e.banking.View;

import javax.swing.JOptionPane;

public class ErrorMessage {
    //show error message from exception
    
    public void showMessageBox(String message) {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
