
package dao;

import java.sql.*;

/**
 * Luokka luo tietokannan ja tietokannan taulut.
 * 
 */

public class DbDao {
    
    /**
     * Luo tietokannan ja sen taulut.
     * 
     * @param dbName config.properties tiedostossa annettu tietokannan nimi
     */
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
    
    /**
     * Users-taulu.
     * 
     * @return palauttaa Users-taulun luomiseen tarvittavan sql-kyselyn
     */
    public String usersTableCreate() {
        return "CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY, "
                + "name TEXT, username TEXT UNIQUE, password TEXT)";
    }
    
    /**
     * Categories-taulu.
     * 
     * @return palauttaa Categories-taulun luomiseen tarvittavan sql-kyselyn
     */
    public String categoriesTable() {
        return "CREATE TABLE IF NOT EXISTS Categories (id INTEGER PRIMARY KEY, "
                + "category TEXT UNIQUE)";
    }
    
}
