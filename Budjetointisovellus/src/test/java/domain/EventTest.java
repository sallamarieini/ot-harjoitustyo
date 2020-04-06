
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// Tests for Event class in package domain

public class EventTest {
    
    private Event event;
    
    public EventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        event = new Event(1, "22.03.2020", "ruoka", "tulo", 20, "Pekka");
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
    public void toStringWorksTulo() {
        
        //Event event = new Event(1, "22.03.2020", "ruoka", "tulo", 20, "Pekka");
        String right = "22.03.2020, ruoka, tulo, 20.0 €";
        assertEquals(right, event.toString());
        
    }
    
    @Test
    public void toStringWorksMeno() {
        Event event2 = new Event(1, "22.03.2020", "ruoka", "meno", 20, "Pekka");
        String right = "22.03.2020, ruoka, meno, -20.0 €";
        assertEquals(right, event2.toString());
    }
    
    @Test
    public void getDateWorks() {
        String right = "22.03.2020";
        assertEquals(right, event.getDate());
    }
    
    @Test
    public void getTypeWorks() {
        String right = "tulo";
        assertEquals(right, event.getType());
    }
    
    @Test
    public void getSumWorks() {
        double right = 20;
        assertEquals(right, event.getSum(), 1);
    }
    
    @Test
    public void getUserWorks() {
        String right = "Pekka";
        assertEquals(right, event.getUser());
    }
    
    @Test
    public void getEventWorks() {
        String right = "ruoka";
        assertEquals(right, event.getEvent());
    }
            
}
