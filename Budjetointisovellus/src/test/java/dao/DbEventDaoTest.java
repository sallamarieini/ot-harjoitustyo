
package dao;

import domain.Event;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;


public class DbEventDaoTest {
    
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();
    
    DbEventDao eventDao;
    String path;
    
    @Before
    public void setUp() throws IOException {
        
        path = temp.getRoot().getAbsolutePath() + "/test";
        
        DbDao testDb = new DbDao();
        testDb.createDatabase(path);
        
        eventDao = new DbEventDao(path);
        
        eventDao.create(new Event("22/03/2020", "palkka", "tulo", 20, "Pekka"));
        eventDao.create(new Event("14/04/2020", "opintotuki", "tulo", 200, "Kalle"));
        eventDao.create(new Event("14/04/2020", "ruoka", "meno", 20, "Kalle"));
        
    }
    
    @After
    public void tearDown() {
        this.temp.delete();
    }
    
    @Test
    public void allEventsSaved() throws SQLException {
        assertEquals(2, eventDao.list("Kalle").size());
    }
    
    @Test
    public void listWorks() throws SQLException {
        assertTrue(eventDao.list("Pekka") != null);
    }
    
    @Test
    public void listWorksInvalidUser() throws SQLException {
        assertFalse(eventDao.list("Korona") == null);
    }

}
