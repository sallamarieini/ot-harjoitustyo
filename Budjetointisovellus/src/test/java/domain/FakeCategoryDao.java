
package domain;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakeCategoryDao implements CategoryDao {
    
    List<Category> testCategories = new ArrayList<>();

    @Override
    public Object create(Category object) throws SQLException {
        this.testCategories.add(object);
        
        return object;
    }

    @Override
    public List getCategories() throws SQLException {
        return testCategories;
    }

    @Override
    public Category read(String category) throws SQLException {
        for (Category c: this.testCategories) {
            if (c.getName().equals(category)) {
                Category newC = new Category(c.getName());
                return newC;
            } else {
                return null;
            }
        }
        return null;
    }
    
    
    
}
