
package dao;

import domain.Event;
import java.sql.*;
import java.util.*;

/**
 * Event-olioiden tallentamisesta vastaava luokka.
 * 
 */

public class DbEventDao implements EventDao<Event> {
    
    private String name;
    
    /**
     * Luokan konstruktori.
     * 
     * @param name config.properties tiedostossa määritelty tietokannan nimi
     */
    public DbEventDao(String name) {
        this.name = name;
    }
    
    /**
     * Tallentaa Event-olion tietokantaan.
     * 
     * @param object Event-olio
     * @throws SQLException Tietokanta heittää poikkeuksen virhetilanteessa
     */
    @Override
    public void create(Event object) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);

        PreparedStatement p = conn.prepareStatement(
                "INSERT INTO Events (date, event, type, sum, user) VALUES (?,?,?,?,?)");

        p.setString(1, object.getDate());
        p.setString(2, object.getEvent());
        p.setString(3, object.getType());
        p.setDouble(4, object.getSum());
        p.setString(5, object.getUser());

        p.executeUpdate();

        p.close();
        conn.close();
            
        
    }

    /**
     * Listaa käyttäjän tapahtumat.
     * 
     * @param key käyttäjätunnus, jonka tapahtumia haetaan
     * @return palauttaa listan tapahtumista
     * @throws SQLException Tietokanta heittää poikkeuksen virhetilanteissa.
     */
    @Override
    public List<Event> list(String key) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);
        
        PreparedStatement p = conn.prepareStatement("SELECT * FROM Events WHERE user = ?");
        p.setString(1, key);
        
        ResultSet r = p.executeQuery();
        
        List<Event> events = new ArrayList<>();
        
        while (r.next()) {
            events.add(new Event(r.getString("date"), r.getString("event"), r.getString("type"), r.getDouble("sum"), r.getString("user")));
        }
        
        r.close();
        p.close();
        conn.close();
        
        return events;
        
    }
    
}
