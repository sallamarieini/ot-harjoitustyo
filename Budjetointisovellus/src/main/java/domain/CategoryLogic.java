
package domain;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.*;


public class CategoryLogic {
    
    private CategoryDao categoryDao;
    
    public CategoryLogic(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    
    public boolean addNewCategory(String category) {
        try {
            if (this.categoryDao.read(category) == null) {
                categoryDao.create(new Category(category));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public List<Category> getAllCategories() {
        try {
            return this.categoryDao.getCategories();
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
}
