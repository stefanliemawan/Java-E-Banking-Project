package e.banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Form {
    JFrame main = new JFrame("Tarada E-Banking");
    JFrame depo = new JFrame("Deposit");
    JFrame with = new JFrame("Withdrawal");
    JFrame tran = new JFrame("Transaction");
    JFrame info = new JFrame("Account Information");
    
    JPanel mpanel = new JPanel();
    JPanel dpanel = new JPanel();
    JPanel wpanel = new JPanel();
    JPanel tpanel = new JPanel();
    JPanel ipanel = new JPanel();
    
    JLabel mlabel1 = new JLabel("Welcome",JLabel.CENTER);
    JLabel mlabel2 = new JLabel("to",JLabel.CENTER);
    JLabel mlabel3 = new JLabel("Tarada",JLabel.CENTER);
    JLabel mlabel4 = new JLabel("E-Banking",JLabel.CENTER);
    
    JButton mbutton1 = new JButton("Deposit");
    JButton mbutton2 = new JButton("Withdrawal");
    JButton mbutton3 = new JButton("Transaction");
    JButton mbutton4 = new JButton("Account Information");
        
    Color black = new Color (0,0,0);
    Color white = new Color (255,255,255);
    
    
    Font font = new Font(Font.SERIF, Font.PLAIN, 50);
    

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void infopanel() {
        ipanel.setLayout(null);
        ipanel.setBackground(white);
    }
    
    public void infoframe() {
        info.getContentPane().add(ipanel);
        info.setVisible(false);
        info.setResizable(false);
        info.setSize(700,465);
        info.setLocationRelativeTo(null);
        info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void tranpanel() {
        tpanel.setLayout(null);
        tpanel.setBackground(white);
    }
    
    public void tranframe() {
        tran.getContentPane().add(tpanel);
        tran.setVisible(false);
        tran.setResizable(false);
        tran.setSize(700,465);
        tran.setLocationRelativeTo(null);
        tran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
            
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void withpanel() {
        wpanel.setLayout(null);
        wpanel.setBackground(white);
    }
    
    public void withframe() {
        with.getContentPane().add(wpanel);
        with.setVisible(false);
        with.setResizable(false);
        with.setSize(700,465);
        with.setLocationRelativeTo(null);
        with.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void depopanel(){
        dpanel.setLayout(null);
        dpanel.setBackground(white);
    }
    
    public void depoframe(){
        depo.getContentPane().add(dpanel);
        depo.setVisible(false);
        depo.setResizable(false);
        depo.setSize(700,465);
        depo.setLocationRelativeTo(null);
        depo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void mainpanel(){
        mpanel.setLayout(null);
        mpanel.setBackground(white);
        mpanel.add(mlabel1);
        mpanel.add(mlabel2);
        mpanel.add(mlabel3);
        mpanel.add(mlabel4);
        mpanel.add(mbutton1);
        mpanel.add(mbutton2);
        mpanel.add(mbutton3);
        mpanel.add(mbutton4);
        }
    
    public void mainframe(){
        main.getContentPane().add(mpanel);
        main.setVisible(true);
        main.setResizable(false);
        main.setSize(700,465);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void mainlabel() {
        mlabel1.setFont(font);
        mlabel1.setBounds(30,20,300,100);
        
        mlabel2.setFont(font);
        mlabel2.setBounds(30,80,300,100);
        
        mlabel3.setFont(font);
        mlabel3.setBounds(30,140,300,100);
        
        mlabel4.setFont(font);
        mlabel4.setBounds(30,200,300,100);
    }
    
    public void mainbutton(){
        mbutton1.setBounds(380,5,300,100);
        
        mbutton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // deposit
                main.setVisible(false);
                depopanel();
                depoframe();
                depo.setVisible(true);
            }
        });
        
        mbutton2.setBounds(380,110,300,100);
        
        mbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // withdrawal
                main.setVisible(false);
                withpanel();
                withframe();
                with.setVisible(true);
            }
        });
        mbutton3.setBounds(380,215,300,100);
        
        mbutton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // transaction
                main.setVisible(false);
                tranpanel();
                tranframe();
                tran.setVisible(true);
            }
        });
        mbutton4.setBounds(380,320,300,100);
        
        mbutton4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // account information
                main.setVisible(false);
                infopanel();
                infoframe();
                info.setVisible(true);
            }
        });
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void viewmain(){
        mainlabel();
        mainbutton();
        mainpanel();
        mainframe();
    }
    
    
}
