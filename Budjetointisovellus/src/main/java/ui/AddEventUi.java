
package ui;

import domain.EventLogic;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddEventUi {
    
    private EventLogic eventLogic;
    
    public AddEventUi(EventLogic eventLogic) {
        this.eventLogic = eventLogic;
    }
    
    public Scene getAddEventUiScene(Stage stage) {
        
        VBox components = new VBox();
        
        Label headlineLabel = new Label("Lisää tapahtuma");
        
        Label dateLabel = new Label("Päivämäärä");
        TextField dateInput = new TextField();
        
        Label eventLabel = new Label("Tapahtuman kuvaus (esim. ruoka)");
        TextField eventInput = new TextField();
        
        Label typeLabel = new Label("Tulo tai meno");
        ComboBox typeInput = new ComboBox();
        typeInput.getItems().add("tulo");
        typeInput.getItems().add("meno");
        typeInput.getSelectionModel().selectFirst();
        
        Label sumLabel = new Label("Rahasumma euroina (desimaaliluku sallittu)");
        TextField sumInput = new TextField();
        
        Button addButton = new Button("Lisää tapahtuma");
        
        Label didItWorkLabel = new Label("");
        
        components.getChildren().addAll(headlineLabel, dateLabel, dateInput, eventLabel,
                eventInput, typeLabel, typeInput, sumLabel, sumInput, addButton, didItWorkLabel);
        
        addButton.setOnAction((event) -> {
            
            String date = dateInput.getText();
            String event2 = eventInput.getText();
            String type = typeInput.getValue().toString();
            Double sum = Double.parseDouble(sumInput.getText());
            
            boolean value = this.eventLogic.addEvent(date, event2, type, sum);
            
            if (value == true) {
                didItWorkLabel.setText("Tapahtuma lisätty.");
            } else {
                didItWorkLabel.setText("Virhe. Tapahtuman lisääminen ei onnistunut.");
            }
            
        });
        
        components.setPadding(new Insets(15));
        
        Scene scene = new Scene(components);
        
        return scene;
        
    }
    
}
