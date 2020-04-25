
package domain;

import dao.UserDao;
import java.sql.SQLException;
import java.util.HashMap;


public class FakeUserDao implements UserDao<User, String> {
    
    HashMap<String, User> usersTesting = new HashMap<>();

    @Override
    public void create(User object) throws SQLException {
        usersTesting.put(object.getUsername(), object);
    }

    @Override
    public User read(String object) throws SQLException {
        if (usersTesting.containsKey(object)) {
            return this.usersTesting.get(object);
        } else {
            return null;
        }
    }
    
}
