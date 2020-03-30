
package domain;

import java.time.LocalDate;

// Class for events

public class Event {
    
    private int id;
    private String date;
    private String event;
    private String type; // tulo vai meno
    private double sum;
    
    // konstruktori testejä varten
    public Event(int id, String date, String event, String type, double sum) {
        this.id = id;
        this.date = date;
        this.event = event;
        this.type = type;
        this.sum = sum;
    }
    
    public Event(String date, String event, String type, double sum) {
        this.date = date;
        this.event = event;
        this.type = type;
        this.sum = sum;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getEvent() {
        return this.event;
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getSum() {
        return this.sum;
    }
    
    @Override
    public String toString() {
        
        if (this.type.equals("tulo")) {
            return this.date + ", " + this.event + ", "+ this.type + ", " + this.sum + " €";
        } else {
            return this.date + ", " + this.event + ", " + this.type + ", -" + this.sum + " €";
        }
        
    }
    
    
}
