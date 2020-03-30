
package ui;

import domain.EventLogic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Layout for main view

public class BudgetUi {
    
    private EventLogic eventLogic;
    private Stage stage2;
    
    public BudgetUi(EventLogic eventLogic, Stage stage2) {
        this.eventLogic = eventLogic;
        this.stage2 = stage2;
    }

    //@Override
    public Scene getMainMenuUi(Stage window) throws Exception {
        
        VBox layout = new VBox();
        layout.setSpacing(10);
        
        Button addEventButton = new Button("Lisää uusi tapahtuma");
        Button listEventsButton = new Button("Näytä kaikki tapahtumat");
        
        layout.getChildren().add(addEventButton);
        layout.getChildren().add(listEventsButton);
        
        layout.setPrefSize(500, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene outlook = new Scene(layout);
        
        addEventButton.setOnAction((event) -> {
            
            AddEventUi addEventUi = new AddEventUi(eventLogic);
            stage2.setScene(addEventUi.getAddEventUiScene(stage2));
            stage2.show();
            
        });
        
        return outlook;
        
        //window.setScene(outlook);
        
        //window.show();
    }
        
    /*public static void main(String[] args) {
        launch(args);
    }*/
    
}
