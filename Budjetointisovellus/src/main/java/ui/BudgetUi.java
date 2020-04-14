
package ui;

import domain.EventLogic;
import domain.UserLogic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Layout for main view

public class BudgetUi {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    //private Scene loginScene;
    private Stage stage2;
    
    public BudgetUi(UserLogic userLogic, EventLogic eventLogic, Stage stage2) {
        this.userLogic = userLogic;
        this.eventLogic = eventLogic;
        //this.loginScene = loginScene;
        this.stage2 = stage2;
    }

    //@Override
    public Scene getMainMenuUi(Stage window) throws Exception {
        
        VBox layout = new VBox();
        layout.setSpacing(10);
        
        String name = userLogic.getUser().getName();
        Label welcomeLabel = new Label("Hei " + name + "!");
        
        Button addEventButton = new Button("Lisää uusi tapahtuma");
        Button listEventsButton = new Button("Näytä kaikki tapahtumat");
        Button logoutButton = new Button("Kirjaudu ulos");
        
        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(addEventButton);
        layout.getChildren().add(listEventsButton);
        layout.getChildren().add(logoutButton);
        
        layout.setPrefSize(500, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //Scene outlook = new Scene(layout);
        
        addEventButton.setOnAction((event) -> {
            
            AddEventUi addEventUi = new AddEventUi(eventLogic, userLogic);
            stage2.setScene(addEventUi.getAddEventUiScene(stage2));
            stage2.show();
            
        });
        
        listEventsButton.setOnAction((event) -> {
            ListEventsUi listEventsUi = new ListEventsUi(eventLogic, userLogic);
            stage2.setScene(listEventsUi.getListEventsUiScene(stage2));
            stage2.show();
        });
        
        Label logoutM = new Label("Olet kirjautunut ulos.");
        Label logoutM2 = new Label("Sulje kaikki ikkunat.");
        
        VBox comp = new VBox();
        comp.getChildren().addAll(logoutM, logoutM2);
        comp.setPrefSize(200, 100);
        comp.setAlignment(Pos.CENTER);
        comp.setPadding(new Insets(20, 20, 20, 20));
        
        Scene logoutMessage = new Scene(comp);
        
        logoutButton.setOnAction((event) -> {
            userLogic.logUserOut();
            //LoginUi loginUi = new LoginUi(userLogic, eventLogic, stage2);
            window.setScene(logoutMessage);
            //window.setScene(loginUi.getLoginScene(stage2));
            window.show();
        });
        //window.show();
        
        Scene outlook = new Scene(layout);
        
        return outlook;
        
        //window.setScene(outlook);
        
        //window.show();
    }
        
    /*public static void main(String[] args) {
        launch(args);
    }*/
    
}
