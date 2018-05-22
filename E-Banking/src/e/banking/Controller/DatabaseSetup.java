package e.banking.controller;

import java.sql.*;

public class DatabaseSetup {
    
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    private String url = "jdbc:mysql://localhost/jdbctest";
    private String username = "root";
    private String password = "";
    private String query;
    
    public void connectDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void printTable(){
        try{
            query = "Select * from lala";
            rs = stm.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("id")+","+rs.getString("name"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(){
        try {
            query = "Update lala set ID = 111 where name = 'hasdaasdha'";
            stm.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(){
        try {
            query = "delete from lala where name = 'hasdaasdha'";
            stm.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
