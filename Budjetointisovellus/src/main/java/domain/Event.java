
package domain;

import java.time.LocalDate;

/**
 * Tapahtumaa kuvaava olio
 * 
 */

public class Event {
    
    private int id;
    private String date;
    private String event;
    private String type; // tulo vai meno
    private double sum;
    private String user;
    
    /**
     * Konstruktori esimerkiksi testejä varten
     * 
     * @param id tapahtuman pääavain
     * @param date tapahtuman päivämäärä
     * @param event tapahtuman kuvaus eli kategoria
     * @param type tapahtuman tyyppi (tulo/meno)
     * @param sum tapahtuman summa
     * @param user käyttäjä, johon tapahtuma liittyy
     */
    public Event(int id, String date, String event, String type, double sum, String user) {
        this.id = id;
        this.date = date;
        this.event = event;
        this.type = type;
        this.sum = sum;
        this.user = user;
    }
    
    /**
     * Luokan konstruktori, jota käytetään tapahtumien luomiseen
     * 
     * @param date tapahtuman päivämäärä
     * @param event tapahtuman kuvaus eli kategoria
     * @param type tapahtuman tyyppi (tulo/meno)
     * @param sum tapahtuman summa
     * @param user käyttäjä, johon tapahtuma liittyy
     */
    public Event(String date, String event, String type, double sum, String user) {
        this.date = date;
        this.event = event;
        this.type = type;
        this.sum = sum;
        this.user = user;
    }
    
    /**
     * Hakee Event-olion päivämäärän
     * 
     * @return palauttaa päivämäärän
     */
    public String getDate() {
        return this.date;
    }
    
    /**
     * Hakee Event-olion kategorian
     * 
     * @return palauttaa kategorian
     */
    public String getEvent() {
        return this.event;
    }
    
    /**
     * Hakee Event-olion tyypin
     * 
     * @return palauttaa tyypin
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Hakee Event-olion summan
     * 
     * @return palauttaa summan
     */
    public double getSum() {
        return this.sum;
    }
    
    /**
     * Hakee Event-olioon liittyvän käyttäjän
     * 
     * @return palauttaa käyttäjän
     */
    public String getUser() {
        return this.user;
    }
    
    /**
     * Event-olion merkkijonoesitys.
     * 
     * @return tapahtuman tyypistä riippuen palauttaa erilaisen merkkijonoesityksen
     */
    @Override
    public String toString() {
        
        if (this.type.equals("tulo")) {
            return this.date + ", " + this.event + ", " + this.type + ", " + this.sum + " €";
        } else {
            return this.date + ", " + this.event + ", " + this.type + ", -" + this.sum + " €";
        }
        
    }
    
    
}
