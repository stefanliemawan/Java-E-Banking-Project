package e.banking.view;

import javax.swing.JOptionPane;

public class ErrorMessage {
    //show error message from exception
    
    public void showMessageBox(Exception e) {
        JOptionPane.showMessageDialog(null, e, "Error Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
