
package domain;

import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// class for EventLogic tests

public class EventLogicTest {
    
    private FakeEventDao eventDao;
    private EventLogic eventLogic;
    private List<Event> eventsPekka;
    private List<Event> eventsJorma;
    
    @Before
    public void setUp() throws SQLException {
        this.eventDao = new FakeEventDao();
        this.eventLogic = new EventLogic(eventDao);
        
        eventLogic.addEvent("14/04/2020", "ruoka", "meno", 20, "Pekka");
        eventLogic.addEvent("13/04/2020", "palkka", "tulo", 2000, "Pekka");
        
        eventLogic.addEvent("14/04/2020", "auto", "meno", 158, "Jorma");
        eventLogic.addEvent("14/04/2020", "myynti", "tulo", 15, "Jorma");
        eventLogic.addEvent("12/04/2020", "lääkäri", "meno", 43, "Jorma");
        eventLogic.addEvent("19/04/2020", "puutarha", "tulo", 1000, "Jorma");
        
        eventsPekka = eventDao.list("Pekka");
        eventsJorma = eventDao.list("Jorma");
        
    }
    
    @Test
    public void eventsAddedToUser() {
        assertEquals(4, eventsJorma.size());
    }
    
    @Test
    public void listAllSaved() throws SQLException {
        assertEquals(2, eventDao.list("Pekka").size());
    }
    
    @Test
    public void listReturnsCorrectly() throws SQLException {
        assertEquals(eventsPekka, eventDao.list("Pekka"));
    }
    
    @Test
    public void getEventsIsUser() {
        assertEquals(eventsJorma, eventLogic.getEvents("Jorma"));
    }
    
    @Test
    public void getEventsWhenFalse() {
        assertEquals(null, eventLogic.getEvents("Outi"));
    }
    
    @Test
    public void getEventsNoUser() {
        assertEquals(null, eventLogic.getEvents(""));
    }
    
    @Test
    public void sumExpenceWorks() {
        assertEquals(201, this.eventLogic.sumExpence(eventsJorma), 1);
    }
    
    @Test
    public void sumIncomesWorks() {
        assertEquals(1015, this.eventLogic.sumIncome(eventsJorma), 1);
    }
    
    @Test
    public void saldoWorks() {
        assertEquals(814, this.eventLogic.saldo(eventsJorma));
    }

}
