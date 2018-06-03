package e.banking.View;

import e.banking.Controller.State;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class HistoryForm extends Form {

    State state = new State();
    
    JDialog dialog = new JDialog();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Transaction History");

    String[] columnNames = {"type","id","quantity","date"};
    Object[][] data = {{"transfer", 2342, 50000, "08-03-2000"}, {"deposit", 1209 , 500 , "08-03-2011"}};
    
    DefaultListModel listmodel = new DefaultListModel();
    JList list = new JList(listmodel);
    
    public void list() {
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(5);
        list.setFont(h3);
        list.setBounds(20,60,360,460);
        list.setForeground(black);
        
        listmodel.addElement("Test1");
        listmodel.addElement("Test1");
        listmodel.addElement("Test1");
        listmodel.addElement("Test1");
        
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
        dialog.setSize(400,600);
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