package e.banking.Model;

import e.banking.View.ErrorMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseSetup {
    
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null; 
    private String query = null;
    private String url = "jdbc:mysql://localhost/ebanking?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "";
    
    
    ErrorMessage error = new ErrorMessage();
    
    public void connectDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException e){
            error.showMessageBox("Error when connecting to database\n" + e);
        }
    }
    
    public boolean insertAccount(int id, String pass, int pin, int info_id, int balance_id) {
        connectDB();
        try {
            query = "INSERT INTO Account VALUES("+id+",\""+pass+"\","+pin+","+info_id+","+balance_id+");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Account Table\n" + e +"\n"+query);
            return false;
        }
    }
    
    public boolean insertBalance(double balance) {
        connectDB();
        try {
            query = "INSERT INTO Balance VALUES(NULL,"+balance+");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Balance Table\n" + e);
            return false;
        }
    }
    
    public boolean insertInfo(String fname, String lname, String dob, String phone, String address) {
        connectDB();
        try {
            query = "INSERT INTO Info VALUES(NULL,\""+fname+"\",\""+lname+"\",\""+dob+"\",\""+phone+"\",\""+address+"\");";
            stm.executeUpdate(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Info Table\n" + e);
            return false;
        }
    }
    
    public boolean insertTransaction(int acc_id, int type_id, int quantity, String date) {
        connectDB();
        try {
            query = "INSERT INTO Transaction VALUES(NULL,"+acc_id+","+type_id+",NULL,"+quantity+",\""+date+"\");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Transaction Table\n" + e);
            return false;
        }
    }
    
    public boolean insertTransactionTo(int acc_id, int type_id, int to_id, int quantity, String date) {
        connectDB();
        try {
            query = "INSERT INTO Transaction VALUES(NULL,"+acc_id+","+type_id+","+to_id+","+quantity+",\""+date+"\");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Transaction Table\n" + e);
            return false;
        }
    }
    
    public boolean insertType(String name) {
        connectDB();
        try {
            query = "INSERT INTO Type VALUES(NULL,\""+name+"\");";
            stm.execute(query);
            return true;
        }catch (SQLException e) {
            error.showMessageBox("Error when inserting into Type Table\n" + e);
            return false;
        }
    }
    
    public int selectLastAcc_ID() {
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT acc_id from Account WHERE acc_id=(SELECT MAX(acc_id) FROM Account);";
            rs = stm.executeQuery(query);
            while(rs.next())
            result = rs.getInt("acc_id");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting acc_id from Account Table\n" + e);
        }
        return result;
    }
    
     public int selectLastInfo_ID() {
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT info_id from Info WHERE info_id=(SELECT MAX(info_id) FROM Info);";
            rs = stm.executeQuery(query);
            while(rs.next())
            result = rs.getInt("info_id");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting info_id from Info Table\n" + e);
        }
        return result;
    }
     
      public int selectLastBalance_ID() {
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT balance_id from Balance WHERE balance_id=(SELECT MAX(balance_id) FROM Balance);";
            rs = stm.executeQuery(query);
            while(rs.next())
            result = rs.getInt("balance_id");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting balance_id from Balance Table\n" + e);
        }
        return result;
    }
    
    public String selectLastDOB() {
        String dob = null;
        connectDB();
        try {
            query = "SELECT dob from Info WHERE info_id=(SELECT MAX(info_id) FROM Info);";
            rs = stm.executeQuery(query);
            while(rs.next())
            dob = rs.getString("dob");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting from DOB from Info Table\n" + e);
        }
        return dob;
    }
    
    public String selectPassword(int acc_id) {
        String password = null;
        connectDB();
        try {
            query = "SELECT password FROM ACCOUNT WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
            password = rs.getString("password");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting Password from Account Table, " + e);
        }
        return password;
    }
    
    public int selectPin(int acc_id) {
        int pin = 0;
        connectDB();
        try {
            query = "SELECT pin FROM ACCOUNT WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
            pin = rs.getInt("pin");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting Pin from Account Table, " + e);
        }
        return pin;
    }
    
    public int selectBalanceId(int acc_id) {
        int balanceid = 0;
        connectDB();
        try {
            query = "SELECT balance_id FROM account WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
            balanceid = rs.getInt("balance_id");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting balance_id from Account Table, " + e);
        }
        return balanceid;
    }
    
    public double selectBalance(int bal_id) {
        double balance = 0;
        connectDB();
        try {
            query = "SELECT balance FROM BALANCE WHERE balance_id ="+bal_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
            balance = rs.getDouble("balance");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting Password from Balance Table, " + e);
        }
        return balance;
    }
    
    public boolean searchtoAccId(int acc_id) {
        connectDB();
        try {
            query = "SELECT * FROM account WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
            return true;
        }catch (SQLException e){
            error.showMessageBox("Error to Account ID not found, " + e);
        }
        return false;
    }
}
