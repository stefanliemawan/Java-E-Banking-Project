package e.banking.view;

import java.awt.*;


import javax.swing.*;


public class HistoryForm extends Form {

    JDialog dialog = new JDialog();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Transaction History");



    public class table extends JFrame {

        JTable table;


        public table(){
            setLayout(new FlowLayout());

            String[] columnNames = {"type","id","quantity","date"};
            Object[][] data = {{"transfer", 2342, 50000, "08-03-2000"}, {"deposit", 1209 , 500 , "08-03-2011"}};

            table= new JTable(data,columnNames);
            table.setPreferredScrollableViewportSize(new Dimension(500,50));
            table.setFillsViewportHeight(true);

            JScrollPane scrollpane = new JScrollPane(table);
            add(scrollpane);


        }
   }
    public void setting(){
        label.setBounds(40,40,200,25);
    }

    public void panel() {
        panel.add(label);

    }

    public void table() {
        table gui= new table();
        gui.setSize(600,200);
        gui.setVisible(true);

    }

    public void dialog() {
        panel.setLayout(null);
        panel.setBackground(black);

        dialog.getContentPane().add(panel);
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setSize(800,500);
        dialog.setLocationRelativeTo(null);
    }

    public void view() {
        super.setLabel(label, 1);

        setting();
        panel();
        table();
        dialog();
    }




}

//code kevin


//public class HistoryForm extends Form{
//
//    JDialog dialog = new JDialog();
//
//    String[] columnNames = {"type","id","quantity","date"};
//    Object[][] data = {{"transfer", 2342, 50000, "08-03-2000"}, {"deposit", 1209 , 500 , "08-03-2011"}};
//
//    JTable table = new JTable(data, columnNames);
//
//    JPanel panel = new JPanel();
//    JLabel label = new JLabel("Transaction History");
//    JScrollPane scrollpane = new JScrollPane(table);
//
//    public void setting(){
//        label.setBounds(40,40,200,25);
//    }
//
//    public void panel() {
//        panel.add(label);
//        panel.add(scrollpane);
//    }
//
//    public void table() {
//        table.setFont(h3);
//        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
//        table.setBounds(150,100,500,300);
//    }
//
//    public void dialog() {
//        panel.setLayout(null);
//        panel.setBackground(black);
//
//        dialog.getContentPane().add(panel);
//        dialog.setVisible(true);
//        dialog.setResizable(false);
//        dialog.setSize(800,500);
//        dialog.setLocationRelativeTo(null);
//    }
//
//    public void view() {
//        super.setLabel(label, 1);
//
//        setting();
//        panel();
//        table();
//        dialog();
//    }
//
//    public int getColumnCount() {
//        return columnNames.length;
//    }
//
//    public int getRowCount() {
//        return data.length;
//    }
//
//    public String getColumnName(int col) {
//        return columnNames[col];
//    }
//
//    public Object getValueAt(int row, int col) {
//        return data[row][col];
//    }
//}



