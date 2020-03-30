
package dao;

import domain.Event;
import java.sql.*;
import java.util.*;

public class DbEventDao implements EventDao<Event>{
    
    
    @Override
    public void create(Event object) {
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
            
            PreparedStatement p = conn.prepareStatement(
                    "INSERT INTO Events (date, event, type, sum) VALUES (?,?,?,?)");
            
            p.setString(1, object.getDate());
            p.setString(2, object.getEvent());
            p.setString(3, object.getType());
            p.setDouble(4, object.getSum());
            
            p.executeUpdate();
            
            p.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    @Override
    public List<Event> list() throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
        
        PreparedStatement p = conn.prepareStatement("SELECT * FROM Events");
        
        ResultSet r = p.executeQuery();
        
        List<Event> events = new ArrayList<>();
        
        while (r.next()) {
            events.add(new Event(r.getString("date"), r.getString("event"), r.getString("type"), r.getDouble("sum")));
        }
        
        r.close();
        p.close();
        conn.close();
        
        return events;
        
    }
    
}
