
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saluitto
 */
public class FakeEventDao implements EventDao {

    @Override
    public void create(Object object) throws SQLException {
        
    }

    @Override
    public List list(String key) throws SQLException {
        return new ArrayList<>();
    }
    
}
