
package domain;

import dao.EventDao;
import java.sql.SQLException;
import java.util.*;

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
    public double saldo(List<Event> list) {
        return Math.round(sumIncome(list) - sumExpence(list) * 100.0) / 100.0;
    }
    
    /**
     * Laskee tapahtumien yhteissuman kategoriaa kohti
     * 
     * @param events tapahtuma-olit sisältävä lista
     * @return palauttaa HashMapin, jossa on yhteissummat kategorioittain, avaimena
     * on kategoria
     */
    public HashMap<String, Double> categoriesSum(List<Event> events) {
        
        HashMap<String, Double> list = new HashMap<>();
        
        for (Event e: events) {
            if (e.getType().equals("meno")) {
                list.put(e.getEvent(), list.getOrDefault(e.getEvent(), 0.0) - e.getSum());
            } else {
                list.put(e.getEvent(), list.getOrDefault(e.getEvent(), 0.0) + e.getSum());
            }
        }
        
        return list;
        
    }
    
    /**
     * Tarkistaa, onko syötetty rahasumma tyypiltään double
     *
     * @param sum rahasumma
     * @return palauttaa true, jos rahasumma on double, muuten false
     */
    public boolean isSumDouble(String sum) {

        try {
            Double.parseDouble(sum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
}
