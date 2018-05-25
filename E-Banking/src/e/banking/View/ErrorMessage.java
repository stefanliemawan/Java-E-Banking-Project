package e.banking.view;

import javax.swing.JOptionPane;

public class ErrorMessage {
    //show error message from exception
    
    public void showMessageBox(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
