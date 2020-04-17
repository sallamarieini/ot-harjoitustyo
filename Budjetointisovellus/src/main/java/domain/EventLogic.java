
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    // method for removing an event
    public boolean removeEvent(int id) {
        try {
            eventDao.remove(id);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    // method for getting the sum of expences
    public double sumExpence(List<Event> list) {
        
        double sum = 0.0;
        
        for (Event event: list) {
            if (event.getType().equals("meno")) {
                sum = sum + event.getSum();
            }
        }
        
        return sum;
        
    }
    
    // method for getting the sum on incomes
    public double sumIncome(List<Event> list) {
        
        double sum = 0.0;
        
        for (Event event: list) {
            if (event.getType().equals("tulo")) {
                sum = sum + event.getSum();
            }
        }
        
        return sum;
        
    }
    
    // method for calculating saldo
    public long saldo(List<Event> list) {
        return Math.round(sumIncome(list) - sumExpence(list));
    }
    
}
