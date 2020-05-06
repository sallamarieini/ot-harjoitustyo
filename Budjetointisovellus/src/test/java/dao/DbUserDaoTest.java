
package dao;

import domain.User;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class DbUserDaoTest {
    
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();
    
    DbUserDao userDao;
    String path;
    
    @Before
    public void setUp() throws SQLException {
        
        path = temp.getRoot().getAbsolutePath() + "/test";
        
        DbDao testDb = new DbDao();
        testDb.createDatabase(path);
        
        userDao = new DbUserDao(path);
        
        userDao.create(new User("Pekka", "pekka004", "qwerty"));
        userDao.create(new User("Kalle", "kalleOnParas", "123456"));
        
    }
    
    @After
    public void tearDown() {
        this.temp.delete();
    }
    
    @Test
    public void readSavesPassword() throws SQLException {
        assertEquals("qwerty", userDao.read("pekka004").getPassword());
    }
    
    @Test
    public void readSavesUsername() throws SQLException {
        assertEquals("pekka004", userDao.read("pekka004").getUsername());
    }
    
    @Test
    public void readSavesName() throws SQLException {
        assertEquals("Kalle", userDao.read("kalleOnParas").getName());
    }
    
}
