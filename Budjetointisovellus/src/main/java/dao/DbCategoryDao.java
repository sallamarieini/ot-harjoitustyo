
package dao;

import domain.Category;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

/**
 * Category-olioiden tallentamisesta vastaava luokka.
 * 
 */

public class DbCategoryDao implements CategoryDao<Category> {
    
    private String name;
    
    /**
     * Luokan konstruktori.
     * 
     * @param name config.properties tiedostossa määritelty tietokannan nimi
     */
    public DbCategoryDao(String name) {
        this.name = name;
    }

    /**
     * Listaa tietokannassa olevat Category-oliot.
     * 
     * @return palautaa listan Category-olioista
     * @throws SQLException tietokanta heittää poikkeuksen virhetilanteessa
     */
    @Override
    public List<Category> getCategories() throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);
        PreparedStatement p = conn.prepareStatement("SELECT * FROM Categories");
        
        ResultSet r = p.executeQuery();
        
        List<Category> categories = new ArrayList<>();
        
        while (r.next()) {
            categories.add(new Category(r.getString("category")));
        }
        
        r.close();
        p.close();
        conn.close();
        
        return categories;
        
    }

    /**
     * Tallettaa Category-olion tietokantaan.
     * 
     * @param object Category-olio
     * @return palauttaa lisätyn Category-olion
     * @throws SQLException Tietokanta heittää poikkeuksen virhetilanteessa
     */
    @Override
    public Category create(Category object) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);
        PreparedStatement p = conn.prepareStatement("INSERT INTO Categories (category) VALUES (?)");
        p.setString(1, object.getName());
        p.executeUpdate();
        
        p.close();
        conn.close();
        
        return object;
    }

    /**
     * Lukee tietokannasta Category-olion.
     * 
     * @param category String Category-olion nimi eli kategorian nimi
     * @return palauttaa null, jos kategoriaa ei ole tietokannassa, muuten luetun Category-olion
     * @throws SQLException Tietokanta heittää poikkeuksen virhetilanteessa
     */
    @Override
    public Category read(String category) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name);
        PreparedStatement p = conn.prepareStatement("SELECT category FROM Categories WHERE category = ?");
        p.setString(1, category);
        
        ResultSet r = p.executeQuery();
        
        if (!r.next()) {
            return null;
        }
        
        Category newCategory = new Category(r.getString("category"));
        
        r.close();
        p.close();
        conn.close();
        
        return newCategory;
        
    }
    
}
