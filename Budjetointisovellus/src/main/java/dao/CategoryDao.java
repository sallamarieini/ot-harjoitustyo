
package dao;

import java.util.*;
import domain.Category;
import java.sql.SQLException;


public interface CategoryDao<T> {
    
    T create(Category object) throws SQLException;
    List<Category> getCategories() throws SQLException;
    Category read(String category) throws SQLException;
    
}
