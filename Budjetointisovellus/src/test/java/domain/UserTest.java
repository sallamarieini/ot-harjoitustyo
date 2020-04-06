
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {
    
    private User user;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User("Pekka", "pekka004", "qwerty");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void getNimiWorks() {
        String right = "Pekka";
        assertEquals(right, user.getName());
    }
    
    @Test
    public void getUsernameWorks() {
        String right = "pekka004";
        assertEquals(right, user.getUsername());
    }
    
    @Test
    public void getPasswordWorks() {
        String right = "qwerty";
        assertEquals(right, user.getPassword());
    }
}
