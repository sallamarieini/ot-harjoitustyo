
package dao;

import java.sql.*;

// Create database and the tables needed

public class DbDao {
    
    public void createDatabase() {
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
            
            Statement s = conn.createStatement();
            
            s.execute("CREATE TABLE IF NOT EXISTS Events (id INTEGER PRIMARY KEY, "
                    + "date TEXT, event TEXT, type TEXT, "
                    + "sum DOUBLE)");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
}
