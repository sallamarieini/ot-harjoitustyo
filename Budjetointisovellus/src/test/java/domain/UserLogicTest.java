
package domain;

import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserLogicTest {
    
    private FakeUserDao userDao;
    private UserLogic userLogic;
    
    @Before
    public void setUp() {
        
        userDao = new FakeUserDao();
        userLogic = new UserLogic(userDao);
        userLogic.addUser("Kalle", "kalle002", "qwerty");
        userLogic.addUser("Noora", "nopa", "12345");
        
    }
    
    @Test
    public void nameSaved() throws SQLException {
        assertEquals("Kalle", this.userDao.read("kalle002").getName());
    }
    
    @Test
    public void usernameSaved() throws SQLException {
        assertEquals("nopa", this.userDao.read("nopa").getUsername());
    }
    
    @Test
    public void passwordSaved() throws SQLException {
        assertEquals("12345", this.userDao.read("nopa").getPassword());
    }
    
    @Test
    public void logInlogsIn() {
        assertEquals(true, this.userLogic.logUserIn("kalle002", "qwerty"));
    }
    
    @Test
    public void wrongPasswordLogIn() {
        assertEquals(false, this.userLogic.logUserIn("kalle002", "moi"));
    }
    
    @Test
    public void wronUsernameLogIn() {
        assertEquals(false, this.userLogic.logUserIn("kalle001", "qwerty"));
    }
    
    @Test
    public void logUserOutWorks() {
        this.userLogic.logUserIn("kalle002", "qwerty");
        this.userLogic.logUserOut();
        assertEquals(null, this.userLogic.getUser());
    }
    
}
