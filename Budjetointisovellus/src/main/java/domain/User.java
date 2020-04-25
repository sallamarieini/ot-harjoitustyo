
package domain;

/**
 * Käyttäjää kuvaava olio
 * 
 */

public class User {
    
    private int id;
    private String name;
    private String username;
    private String password;
    
    /**
     * Luokan konstruktori
     * 
     * @param name käyttäjän nimi
     * @param username käyttäjän käyttäjätunnus
     * @param password käyttäjän salasana
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    /**
     * Asettaa pääavaimen
     * 
     * @param id pääavain
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Hakee käyttäjän pääavaimen
     * 
     * @return pääavain
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Hakee käyttäjän nimen
     * 
     * @return palauttaa käyttäjän nimen
     */
    public String getName() {
        return name;
    }
    
    /**
     * Hakee käyttäjän käyttäjätunnuksen
     * 
     * @return palauttaa käyttäjätunnuksen
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Hakee käyttäjän salasanan
     * 
     * @return palauttaa salasanan
     */
    public String getPassword() {
        return password;
    }
    
}
