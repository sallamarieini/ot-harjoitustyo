
package ui;

import domain.Event;
import domain.EventLogic;
import domain.UserLogic;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Näytä kaikki tapahtumat-näkymän luova luokka.
 * 
 */

public class ListEventsUi {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    
    /**
     * Luokan konstruktori
     * 
     * @param eventLogic tapahtumien sovelluslogiikasta vastaava luokka
     * @param userLogic käyttäjän sovelluslogiikasta vastaava luokka
     */
    public ListEventsUi(EventLogic eventLogic, UserLogic userLogic) {
        this.eventLogic = eventLogic;
        this.userLogic = userLogic;
    }
    
    /**
     * Luo Näytä kaikki tapahtumat-näkymän
     * 
     * @param stage2 BudjetointisovellusUi-luokassa asetettu Stage-olio
     * @return palauttaa näkymän Scene-olion
     */
    public Scene getListEventsUiScene(Stage stage2) {
        
        ListView<Event> list = new ListView<>();
        if (this.userLogic.getUser() != null) {
            ObservableList<Event> events = FXCollections.observableArrayList(eventLogic.getEvents(this.userLogic.getUser().getUsername()));
            list.setItems(events);
        } else {
            ArrayList<Event> notLoggedInList = new ArrayList<>();
            notLoggedInList.add(new Event("","Et ole kirjautunut sisään", "", 0, ""));
            ObservableList<Event> events = FXCollections.observableArrayList(notLoggedInList);
            list.setItems(events);
        }
        //list.setItems(events);
        list.setPrefSize(500, 500);
        
        VBox components = new VBox();
        
        components.getChildren().addAll(list);
        
        Scene scene = new Scene(components, 500, 500);
        
        return scene;
        
    }
    
}
