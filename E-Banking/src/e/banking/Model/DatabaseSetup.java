package e.banking.Model;

import e.banking.View.ErrorMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class DatabaseSetup {

    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private String query = null;
    private String url = "jdbc:mysql://localhost/ebanking?verifyServerCertificate=false&useSSL=true";
    private String username = "root";
    private String password = "lala";

    ErrorMessage error = new ErrorMessage();

    public void connectDB() { // Connect to Database Server
        try {
            conn = DriverManager.getConnection(url, username, password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            error.showMessageBox("Error when connecting to database\n" + e);
        }
    }

    public boolean insertAccount(int id, String pass, int pin, int info_id, int balance_id) { // Insert into Account table
        connectDB();
        try {
            query = "INSERT INTO Account VALUES(" + id + ",\"" + pass + "\"," + pin + "," + info_id + "," + balance_id + ");";
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Account Table\n" + e + "\n" + query);
            return false;
        }
    }

    public boolean insertBalance(double balance) { // Insert into Balance table
        connectDB();
        try {
            query = "INSERT INTO Balance VALUES(NULL," + balance + ");";
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Balance Table\n" + e);
            return false;
        }
    }

    public boolean insertInfo(String fname, String lname, String dob, String phone, String address) { // Insert into Info table
        connectDB();
        try {
            query = "INSERT INTO Info VALUES(NULL,\"" + fname + "\",\"" + lname + "\",\"" + dob + "\",\"" + phone + "\",\"" + address + "\");";
            stm.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Info Table\n" + e);
            return false;
        }
    }

    public boolean insertTransaction(int acc_id, int type_id, int quantity, String date) { // Insert into Transaction table (with one null column)
        connectDB();
        try {
            query = "INSERT INTO Transaction VALUES(NULL," + acc_id + "," + type_id + ",NULL," + quantity + ",\"" + date + "\");";
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Transaction Table\n" + e);
            return false;
        }
    }

    public boolean insertTransactionTo(int acc_id, int type_id, int to_id, int quantity, String date) { // Insert into Account table (full column)
        connectDB();
        try {
            query = "INSERT INTO Transaction VALUES(NULL," + acc_id + "," + type_id + "," + to_id + "," + quantity + ",\"" + date + "\");";
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Transaction Table\n" + e);
            return false;
        }
    }

    public boolean insertType(String name) { // Insert into Type table from Type table
        connectDB();
        try {
            query = "INSERT INTO Type VALUES(NULL,\"" + name + "\");";
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when inserting into Type Table\n" + e);
            return false;
        }
    }

    public int selectLastAcc_ID() { // Select the latest Acc_ID from Account table
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT acc_id from Account WHERE acc_id=(SELECT MAX(acc_id) FROM Account);";
            rs = stm.executeQuery(query);
            while (rs.next())
                result = rs.getInt("acc_id");
        } catch (SQLException e) {
            error.showMessageBox("Error when selecting acc_id from Account Table\n" + e);
        }
        return result;
    }

    public int selectLastInfo_ID() { // Select the latest Info_ID from Info table
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT info_id from Info WHERE info_id=(SELECT MAX(info_id) FROM Info);";
            rs = stm.executeQuery(query);
            while (rs.next())
                result = rs.getInt("info_id");
        } catch (SQLException e) {
            error.showMessageBox("Error when selecting info_id from Info Table\n" + e);
        }
        return result;
    }

    public int selectLastBalance_ID() { // Select the latest Balance_ID from Balance table
        int result = 0;
        connectDB();
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            query = "SELECT balance_id from Balance WHERE balance_id=(SELECT MAX(balance_id) FROM Balance);";
            rs = stm.executeQuery(query);
            while (rs.next())
                result = rs.getInt("balance_id");
        } catch (SQLException e) {
            error.showMessageBox("Error when selecting balance_id from Balance Table\n" + e);
        }
        return result;
    }

    public String selectLastDOB() { // Select the lates Date of Birth from Info table
        String dob = null;
        connectDB();
        try {
            query = "SELECT dob from Info WHERE info_id=(SELECT MAX(info_id) FROM Info);";
            rs = stm.executeQuery(query);
            while (rs.next())
                dob = rs.getString("dob");
        } catch (SQLException e) {
            error.showMessageBox("Error when selecting from DOB from Info Table\n" + e);
        }
        return dob;
    }

    public boolean ChangePassword(int acc_id, String password) { // Update new Password
        connectDB();
        try {
            query = "UPDATE account SET password =\"" + password + "\" where acc_id =" + acc_id + ";";
            stm.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when updating password\n" + e);
            return false;
        }
    }

    public boolean ChangePIN(int acc_id, int pin) { // Update new PIN
        connectDB();
        try {
            query = "UPDATE account SET pin = " + pin + " where acc_id =" + acc_id + ";";
            stm.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            error.showMessageBox("Error when updating PIN\n" + e);
            return false;
        }
    }
    
    public void insertHistoryWith(int acc_id, double withdraw){ // Insert History table with Withdrawal data
        connectDB();
        
        try {
            query = "INSERT INTO transaction VALUES(NULL, "+acc_id+", 2, NULL, "+ withdraw + ",now());";
            stm.execute(query);
                        
        }catch (SQLException e){
            error.showMessageBox("Error recording transaction , " + query);
        }
    }
    
    public void insertHistoryTrans(int acc_id, double withdraw, int toacc_id){ // Insert History table with Transaction data
        connectDB();
        
        LocalDate date = LocalDate.now();
        try {
            query = "INSERT INTO transaction VALUES(NULL, "+acc_id+", 1, " + toacc_id + ", "+ withdraw + ",now());";
            stm.execute(query);
                      
            query = "INSERT INTO transaction VALUES(NULL, "+toacc_id+", 4,"+acc_id+", "+ withdraw + ",now());";
            stm.execute(query);
        }catch (SQLException e){
            error.showMessageBox("Error recording transaction , " + query);
        }
    }
    
    public String[][] transactionData(int acc_id) { // Select Datas from Transaction table
        connectDB();
        String info = null;
        int check = 0;
        int i = 0;
        String[][] data = new String[1000][1];
        try {
            query = "select * from transaction where acc_id = " + acc_id + ";";
            rs = stm.executeQuery(query);
            while (rs.next()){
                check = rs.getInt(3);
                
                if(check == 1){
                    info = (rs.getString(6)+" send to: "+rs.getString(4)+" amount: "+rs.getString(5));
                }else if(check == 2){
                    info = (rs.getString(6)+" withdraw amount: "+rs.getString(5));
                }else if(check == 4){
                    info = (rs.getString(6)+" received amount: "+rs.getString(5)+" from "+rs.getString(4));
                }
                data[i][0] = info;
                i++;}
        } catch (SQLException e) {
            error.showMessageBox("error when retrieving transaction" + e);
        }
      
        return data;
    }
    
    public String selectPassword(int acc_id) { // Select Password from Account table
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
    
    public int selectPIN(int acc_id) { // Select PIN from Account table
        int PIN = 0;
        connectDB();
        try {
            query = "SELECT pin FROM ACCOUNT WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next())
                PIN = rs.getInt("pin");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting pin from Account Table, " + e);
        }
        return PIN;
    }
    
    public int selectBalanceId(int acc_id) { // Select Balance_ID from Account table
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
    
    public double selectBalance(int bal_id) { // Select Balance from Account table
        double balance = 0;
        connectDB();
        try {
            query = "SELECT balance FROM Balance WHERE balance_id ="+bal_id+";";
            rs = stm.executeQuery(query);
            while(rs.next()) 
                balance = rs.getDouble("balance");
        }catch (SQLException e) {
            error.showMessageBox("Error when selecting balance from Balance Table, " + e);
        }
        return balance;
    }
    
    public boolean searchtoAccId(int acc_id) { // Search Acc_ID
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
    
    public boolean withdraw(int acc_id, double withdraw){ // Withdraw balance from the Account
        connectDB();

        try {
            int balanceId = 0;

            query = "SELECT * FROM account WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next())
                balanceId = rs.getInt("balance_id");
            rs.close(); 
                        
            query = "UPDATE balance SET balance=balance-"+ withdraw +"  WHERE balance_id="+ balanceId +";";
            stm.executeUpdate(query);
            
        }catch (SQLException e){
            error.showMessageBox("Error to Account ID not found, " + e);
        }
        return false;
    }
    
    public boolean trans(int acc_id, double amount, int toacc_id){ // Do Transaction from one Account to another
        connectDB();

        try {
            int balanceId = 0;

            query = "SELECT * FROM account WHERE acc_id ="+acc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next())
                balanceId = rs.getInt("balance_id");
            rs.close(); 
            
            query = "UPDATE balance SET balance = balance-"+ amount +"  WHERE balance_id ="+ balanceId +";";
            stm.executeUpdate(query);
 
            query = "SELECT * FROM account WHERE acc_id ="+toacc_id+";";
            rs = stm.executeQuery(query);
            while(rs.next())
                balanceId = rs.getInt("balance_id");
            rs.close(); 
            
            query = "UPDATE balance SET balance = balance + "+ amount +"  WHERE balance_id ="+ balanceId +";";
            stm.executeUpdate(query);
            
        }catch (SQLException e){
            error.showMessageBox("Error to Account ID not found, " + e);
        }
        return false;
    }
}
