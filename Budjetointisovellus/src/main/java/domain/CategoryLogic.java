
package domain;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.*;

/**
 * Kategorioihin liittyvä sovelluslogiikka.
 * 
 */

public class CategoryLogic {
    
    private CategoryDao categoryDao;
    
    /**
     * Luokan konstruktori.
     * 
     * @param categoryDao Luokka, joka tarjoaa Dao-toiminnallisuudet
     */
    public CategoryLogic(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    
    /**
     * Lisää uuden kategorian tietokantaan.
     * 
     * @param category kategorian nimi
     * @return palauttaa true, jos kategorian lisääminen onnistuu, muuten false
     */
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
    
    /**
     * Listaa kaikki tietokannassa olevat kategoriat.
     * 
     * @return 
     */
    public List<Category> getAllCategories() {
        try {
            return this.categoryDao.getCategories();
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
}
