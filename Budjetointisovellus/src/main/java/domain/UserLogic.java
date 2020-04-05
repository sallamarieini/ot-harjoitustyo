
package domain;

import dao.UserDao;
import java.sql.SQLException;

// Class for managing app logic related to users

public class UserLogic {
    
    private UserDao userDao;
    private User user;
    
    public UserLogic(UserDao userDao) {
        this.userDao = userDao;
        this.user = null;
    }
    
    // method for adding a new user into database
    public boolean addUser(String name, String username, String password) {
        try {
            userDao.create(new User(name, username, password));
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    // method for logging user in
    public boolean logUserIn(String username, String password) {
        
        try {
            
            User login = (User) this.userDao.read(username);
            
            if (login != null && login.getPassword().equals(password)) {
                this.user = login;
                return true;
            }
            return false;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    
    // method for logging user out
    public void logUserOut() {
        this.user = null;
    }
    
    // method for getting user that is currently logged in
    public User getUser() {
        return this.user;
    }
    
}
