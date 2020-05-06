
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FakeEventDao implements EventDao<Event> {

    Map<String, List<Event>> events = new HashMap<>();
    
    @Override
    public void create(Event object) throws SQLException {
        
        events.putIfAbsent(object.getUser(), new ArrayList<>());
        events.get(object.getUser()).add(object);
        
    }

    @Override
    public List list(String key) throws SQLException {
        return events.get(key);
    }
    
}
