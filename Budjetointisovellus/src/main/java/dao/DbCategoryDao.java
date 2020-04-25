
package dao;

import domain.Category;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;


public class DbCategoryDao implements CategoryDao<Category> {
    
    private String name;
    
    public DbCategoryDao(String name) {
        this.name = name;
    }

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
