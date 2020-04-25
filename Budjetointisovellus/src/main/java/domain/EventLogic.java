
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tapahtumiin liittyvä sovelluslogiikka
 * 
 */

public class EventLogic {
    
    private EventDao eventDao;
    
    /**
     * Luokan konstruktori
     * 
     * @param eventDao Luokka, joka tarjoaa Dao-ominaisuudet
     */
    public EventLogic(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    
    /**
     * Lisää uuden tapahtuman tietokantaan
     * 
     * @param date tapahtuman päivämäärä
     * @param event tapahtuman kategoria
     * @param type tapahtuman tyyppi
     * @param sum tapahtuman summa
     * @param user tapahtumaan liittyvä käyttäjä
     * @return palauttaa true, jos lisääminen onnistui, virheen tapahtuessa false
     */
    public boolean addEvent(String date, String event, String type, double sum, String user) {
        
        try {
            eventDao.create(new Event(date, event, type, sum, user));
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    /**
     * Listaa tiettyyn käyttäjään liittyvät tapahtumat tietokannasta
     * 
     * @param user haettaviin tapahtumiin liittyvä käyttäjä
     * @return palauttaa tapahtumat sisältävän listan, jos tapahtuu virhe,
     * palauttaa tyhjän listan
     */
    public List<Event> getEvents(String user) {
        try {
            return eventDao.list(user);
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
    /**
     * Poistaa Event-olion
     * 
     * @param id poistettavan tapahtuman pääavain
     * @return palauttaa true, jos tapahtuma on poistettu onnistuneesti,
     * virheen tapahtuessa false
     */
    public boolean removeEvent(int id) {
        try {
            eventDao.remove(id);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    /**
     * Laskee menojen summan
     * 
     * @param list tapahtumat sisältävä lista
     * @return palauttaa menojen summan
     */
    public double sumExpence(List<Event> list) {
        
        double sum = 0.0;
        
        for (Event event: list) {
            if (event.getType().equals("meno")) {
                sum = sum + event.getSum();
            }
        }
        
        return sum;
        
    }
    
    /**
     * Laskee tulojen summan
     * 
     * @param list tapahtumat sisältävät lista
     * @return palauttaa tulojen summan
     */
    public double sumIncome(List<Event> list) {
        
        double sum = 0.0;
        
        for (Event event: list) {
            if (event.getType().equals("tulo")) {
                sum = sum + event.getSum();
            }
        }
        
        return sum;
        
    }
    
    /**
     * Laskee tapahtumien kokonaissaldon
     * 
     * @param list tapahtumat sisältävä lista
     * @return palauttaa saldon
     */
    public long saldo(List<Event> list) {
        return Math.round(sumIncome(list) - sumExpence(list));
    }
    
}
