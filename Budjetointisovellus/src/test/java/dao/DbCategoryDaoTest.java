
package dao;

import domain.Category;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;


public class DbCategoryDaoTest {
    
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();
    
    DbCategoryDao categoryDao;
    String path;
    
    @Before
    public void setUp() throws IOException, SQLException {
        
        path = temp.getRoot().getAbsolutePath() + "/test";
        
        DbDao testDb = new DbDao();
        testDb.createDatabase(path);
        
        categoryDao = new DbCategoryDao(path);
        
        categoryDao.create(new Category("kukat"));
        categoryDao.create(new Category("palkka"));
        categoryDao.create(new Category("herkut"));
        
    }
    
    @After
    public void tearDown() {
        this.temp.delete();
    }
    
    @Test
    public void allCategoriesSaved() throws SQLException {
        assertEquals(3, categoryDao.getCategories().size());
    }
    
    @Test
    public void readReturnsNull() throws SQLException {
        assertEquals(null, this.categoryDao.read("auto"));
    }
    
    @Test
    public void readReturnsCategory() throws SQLException {
        Category right = new Category("kukat");
        assertEquals(right.toString(), this.categoryDao.read("kukat").toString());
    }

}
