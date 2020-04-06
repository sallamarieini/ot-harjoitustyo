
package dao;

import domain.User;
import java.sql.*;

public class DbUserDao implements UserDao<User, String> {

    @Override
    public void create(User object) {
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
            
            PreparedStatement p = conn.prepareStatement(
                    "INSERT INTO Users (name, username, password) VALUES (?,?,?)");
            
            p.setString(1, object.getName());
            p.setString(2, object.getUsername());
            p.setString(3, object.getPassword());
            
            p.executeUpdate();
            
            p.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    @Override
    public User read(String object) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db");

        PreparedStatement p = conn.prepareStatement(
                "SELECT name, username, password FROM Users WHERE username = ?");
        p.setString(1, object);

        ResultSet r = p.executeQuery();

        if (!r.next()) {
            return null;
        }

        User user = new User(r.getString("name"), r.getString("username"), r.getString("password"));

        r.close();
        p.close();
        conn.close();

        return user;
        
    }
    
}
