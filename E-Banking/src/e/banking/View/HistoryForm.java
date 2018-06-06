package e.banking.View;

import e.banking.Controller.State;
import e.banking.Model.DatabaseSetup;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


public class  HistoryForm extends Form {

    State state = new State();
    DatabaseSetup db = new DatabaseSetup();
    
    JDialog dialog = new JDialog();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Transaction History");

    String[] columnNames = {"type","id","quantity","date"};
    String[][] data = db.transactionData(state.getAcc_ID()).clone();
    
    DefaultListModel listmodel = new DefaultListModel();
    JList list = new JList(listmodel);
    int lastindex = 0;


    
    public void list() {
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(5);
        list.setFont(h3);
        list.setBounds(20,60,460,460);
        list.setForeground(black);


        for (int i=lastindex; i<data.length;i++) {
            if (data[i][0] == null) {
                break;
            } else {
                listmodel.addElement(data[i][0] + "\n");
            }lastindex=i;

        }
    }





    public void setting() {
        label.setBounds(100,20,200,25);
        label.setFont(h2);
    }
    
    public void panel() {
        panel.setLayout(null);
        panel.setBackground(black);
        panel.add(label);
        panel.add(list);
    }
    
    public void dialog() {
        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setSize(600,600);
        dialog.setLocationRelativeTo(null);
    }
    
    public void view() {
        state.changeState("History");
        super.setLabel(label,1);
        list();
        setting();
        panel();
        dialog();
    }

}