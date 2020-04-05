
package ui;

import domain.Event;
import domain.EventLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListEventsUi {
    
    private EventLogic eventLogic;
    
    public ListEventsUi(EventLogic eventLogic) {
        this.eventLogic = eventLogic;
    }
    
    public Scene getListEventsUiScene(Stage stage2) {
        
        ListView<Event> list = new ListView<>();
        ObservableList<Event> events = FXCollections.observableArrayList(eventLogic.getEvents());
        list.setItems(events);
        list.setPrefSize(500, 500);
        
        VBox components = new VBox();
        
        components.getChildren().addAll(list);
        
        Scene scene = new Scene(components, 500, 500);
        
        return scene;
        
    }
    
}
