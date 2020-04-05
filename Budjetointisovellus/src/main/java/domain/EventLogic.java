
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.*;

// Class for app logic related to event handling

public class EventLogic {
    
    private EventDao eventDao;
    
    public EventLogic(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    
    // method for adding new event to database
    public boolean addEvent(String date, String event, String type, double sum, String user) {
        
        try {
            eventDao.create(new Event(date, event, type, sum, user));
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    // method for getting all added events from database
    public List<Event> getEvents(String user) {
        try {
            return eventDao.list(user);
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
}
