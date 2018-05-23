package e.banking.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class HistoryForm extends Form {

    JDialog dialog = new JDialog();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Transaction History");

    String[] columnNames = {"type","id","quantity","date"};
    Object[][] data = {{"transfer", 2342, 50000, "08-03-2000"}, {"deposit", 1209 , 500 , "08-03-2011"}};
    
    DefaultListModel listmodel = new DefaultListModel();
    JList list = new JList(listmodel);
    //pake list aja jangan table
    
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
        super.setLabel(label,1);
        list();
        setting();
        panel();
        dialog();
    }

}