
package ui;

import domain.Category;
import domain.CategoryLogic;
import domain.EventLogic;
import domain.UserLogic;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddEventUi {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    private CategoryLogic categoryLogic;
    
    public AddEventUi(EventLogic eventLogic, UserLogic userLogic, CategoryLogic categoryLogic) {
        this.eventLogic = eventLogic;
        this.userLogic = userLogic;
        this.categoryLogic = categoryLogic;
    }
    
    public Scene getAddEventUiScene(Stage stage) {
        
        VBox components = new VBox();
        
        Label headlineLabel = new Label("Lisää tapahtuma");
        
        Label dateLabel = new Label("Päivämäärä");
        DatePicker datePicker = new DatePicker();
        
        //TextField dateInput = new TextField();
        
        Label eventLabel = new Label("Kategoria");
        ComboBox eventInput = new ComboBox();
        //TextField eventInput = new TextField();
        
        List<Category> list = this.categoryLogic.getAllCategories();
        ObservableList<Category> cList = FXCollections.observableArrayList(list);
        eventInput.setItems(cList);
        eventInput.getSelectionModel().selectFirst();
        
        Label typeLabel = new Label("Tulo tai meno");
        ComboBox typeInput = new ComboBox();
        typeInput.getItems().add("tulo");
        typeInput.getItems().add("meno");
        typeInput.getSelectionModel().selectFirst();
        
        Label sumLabel = new Label("Rahasumma euroina (desimaaliluku sallittu)");
        TextField sumInput = new TextField();
        
        Button addButton = new Button("Lisää tapahtuma");
        
        Label didItWorkLabel = new Label("");
        
        components.getChildren().addAll(headlineLabel, dateLabel, datePicker, eventLabel,
                eventInput, typeLabel, typeInput, sumLabel, sumInput, addButton, didItWorkLabel);
        
        addButton.setOnAction((event) -> {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String date = formatter.format(datePicker.getValue());
            //String date = dateInput.getText();
            String event2 = eventInput.getValue().toString();
            String type = typeInput.getValue().toString();
            Double sum = Double.parseDouble(sumInput.getText());
            
            String username = this.userLogic.getUser().getUsername();
            
            boolean value = this.eventLogic.addEvent(date, event2, type, sum, username);
            
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
