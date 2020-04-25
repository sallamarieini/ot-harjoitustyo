
package dao;

import java.sql.*;

// Create database and the tables needed

public class DbDao {
    
    public void createDatabase(String dbName) {
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            
            Statement s = conn.createStatement();
            
            s.execute("CREATE TABLE IF NOT EXISTS Events (id INTEGER PRIMARY KEY, "
                    + "date TEXT, event TEXT, type TEXT, "
                    + "sum DOUBLE, user TEXT)");
            s.execute(usersTableCreate());
            s.execute(categoriesTable());
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    public String usersTableCreate() {
        return "CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY, "
                + "name TEXT, username TEXT, password TEXT)";
    }
    
    public String categoriesTable() {
        return "CREATE TABLE IF NOT EXISTS Categories (id INTEGER PRIMARY KEY, "
                + "category TEXT)";
    }
    
}
