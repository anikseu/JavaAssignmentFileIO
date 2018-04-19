/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kmhasan
 */
public class DBConsoleApplication {
    private final String USERNAME = "spring2018java";
    private final String PASSWORD = "java";
    private final String HOSTNAME = "172.17.10.52";
    private final String DBNAME = "studentdb";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    private void insertData() {
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connection OK");
            
            String query = "insert into student values('2014433', 'Anjan Dutta', 'Shantinagar', '2441139');";
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
            System.out.println("Record inserted");
            
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Some error happened! " + sqle);
        }        
    }
    
    public void retrieveData() {
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connection OK");
            
            String query = "select * from student";
            
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Retrieved data");
            
            while (resultSet.next()) {
                String studentId = resultSet.getString("id");
                String studentName = resultSet.getString("name");
                System.out.println(studentId + " " + studentName);
            }
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Some error happened! " + sqle);
        }         
    }
    
    // CONSTRUCTOR
    public DBConsoleApplication() {
        //insertData();
        retrieveData();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConsoleApplication a = new DBConsoleApplication();
    }
    
}
