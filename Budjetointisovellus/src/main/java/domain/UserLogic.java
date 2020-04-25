
package domain;

import dao.UserDao;
import java.sql.SQLException;

/**
 * Käyttäjiin liittyvä sovelluslogiikka.
 * 
 */

public class UserLogic {
    
    private UserDao userDao;
    private User user;
    
    /**
     * Luokan konstruktori.
     * 
     * @param userDao Luokka, joka tarjoaa Dao-ominaisuudet
     */
    public UserLogic(UserDao userDao) {
        this.userDao = userDao;
        this.user = null;
    }
    
    /**
     * Lisää käyttäjän tietokantaan
     * 
     * @param name käyttäjän nimi
     * @param username käyttäjän käyttäjätunnus
     * @param password käyttäjän salasana
     * @return palauttaa true, jos lisääminen onnistuu ja palauttaa false, jos
     * tapahtuu virhe
     */
    public boolean addUser(String name, String username, String password) {
        try {
            userDao.create(new User(name, username, password));
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    /**
     * Käyttäjän sisäänkirjautuminen
     * 
     * @param username käyttäjän käyttäjätunnus
     * @param password käyttäjän salasana
     * @return palauttaa true, jos sisäänkirjautuminen onnistuu ja false, jos
     * tapahtuu virhe
     */
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
    
    /**
     * Kirjaa käyttäjän ulos
     */
    public void logUserOut() {
        this.user = null;
    }
    
    /**
     * Hakee sisäänkirjautuneena olevan käyttäjän
     * 
     * @return palauttaa käyttäjän, joka on kirjautunut sisään
     */
    public User getUser() {
        return this.user;
    }
    
}
