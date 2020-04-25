
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoryLogicTest {
    
    FakeCategoryDao categoryDao;
    CategoryLogic categoryLogic;
    
    @Before
    public void setUp() {
        
        this.categoryDao = new FakeCategoryDao();
        this.categoryLogic = new CategoryLogic(categoryDao);
        this.categoryLogic.addNewCategory("kukat");
        this.categoryLogic.addNewCategory("palkka");
        
    }
    
    @Test
    public void categorySaved() {
        Category c = new Category("moi");
        assertEquals(true, this.categoryLogic.addNewCategory(c.getName()));
    }
    
    @Test
    public void categoryNotSaved() {
        Category c1 = new Category("kukat");
        assertEquals(false, this.categoryLogic.addNewCategory(c1.getName()));
    }
    
    @Test
    public void categoriesSaved() {
        assertEquals(2, this.categoryLogic.getAllCategories().size());
    }
}
