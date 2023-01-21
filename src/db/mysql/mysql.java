/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author saadia
 */
public class mysql {
    private String Table ="";
    private String jdbcURL = "jdbc:mysql://localhost:3306/taseofrcs?";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    

   
    public Connection getConnection() {
        Connection connection = null;
        try {
            
            
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected success");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return connection;
    }
    
    public String getQuerySQl()
    {
        return null;
    }
    
     
//     public void insertRecord(Model model) throws SQLException {
//        System.out.println(model.INSERT_SQL());
//        // Step 1: Establishing a Connection
//        try (Connection connection = DriverManager
//            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(model.INSERT_SQL())) {
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "Tony");
//            preparedStatement.setString(3, "tony@gmail.com");
//            preparedStatement.setString(4, "US");
//            preparedStatement.setString(5, "secret");
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//
//            // print SQL exception information
//            printSQLException(e);
//        }
//
//        // Step 4: try-with-resource statement will auto close the connection.
//    }
     
     public static void main(String[] args) {
         mysql m =new mysql();
         m.getConnection();

    }
}
