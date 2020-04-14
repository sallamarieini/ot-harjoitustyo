
package domain;

import dao.UserDao;
import java.sql.SQLException;


public class FakeUserDao implements UserDao<User, String> {

    @Override
    public void create(User object) throws SQLException {
        
    }

    @Override
    public User read(String object) throws SQLException {
        return new User("k", "k", "k");
    }
    
}
