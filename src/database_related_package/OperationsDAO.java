/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_related_package;

import java.sql.*;

/*
Singltone class
*/
public class OperationsDAO {
    
    private static OperationsDAO INSTANCE; 
    
    //Database configuration constants
    private final String url = "jdbc:mysql://127.0.0.2:3306/bank_db";
    private final String userName = "root";
    private final String password = "root";
    
    private Connection conn; 
    private Statement stmt; 
    
    //Private Cons
    private OperationsDAO(){}
    
    //Get instance of OperationsDAO (Singleton)
    public static synchronized OperationsDAO getInstance(){
        if(INSTANCE == null)
            INSTANCE = new OperationsDAO();
        
        
        return INSTANCE;
    }
    
    private void connect() throws SQLException{
        // Stablish connection to the database
        conn = DriverManager.getConnection(url, userName, password);
        
        // Create database statment
        stmt = conn.createStatement();
    }
    
    // Close database connection method
    public void close() throws SQLException{
        if(conn != null)
            conn.close();
    }
    
    public ResultSet excuteOperationQuery(String query) throws SQLException{
       
        //Invoke connect();
        connect();
        
        //Excute All queries
        ResultSet result = stmt.executeQuery(query);
        
        return result;
    }
        
    public void excuteOperationUpdate(String... queries) throws SQLException{
        //Invoke connect();
        connect();
        
        //Excute All queries
        for(String query: queries)
            stmt.executeUpdate(query);
        
           
        //Close Connnection
        close();
    }
}
