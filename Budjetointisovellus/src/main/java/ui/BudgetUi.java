
package ui;

import domain.CategoryLogic;
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

/**
 * Luokka muodostaa sovelluksen päävalikon
 * 
 */

public class BudgetUi {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    private CategoryLogic categoryLogic;
    private Stage stage2;
    private Scene loginUi;
    
    /**
     * Luokan konstruktori
     * 
     * @param userLogic käyttäjän sovelluslogiikasta vastaava luokka
     * @param eventLogic tapahtumien sovelluslogiikasta vastaava luokka
     * @param categoryLogic kategorioiden sovelluslogiikasta vastaava luokka
     * @param loginUi BudjetointisovellusUi-luokassa asetettu Scene-olio
     * @param stage2 Stage-olio, jolla luodaan alinäkymä
     */
    public BudgetUi(UserLogic userLogic, EventLogic eventLogic, CategoryLogic categoryLogic, Scene loginUi, Stage stage2) {
        this.userLogic = userLogic;
        this.eventLogic = eventLogic;
        this.categoryLogic = categoryLogic;
        this.stage2 = stage2;
        this.loginUi = loginUi;
    }

    /**
     * Luo sovelluksen päävalikon.
     * 
     * @param window BudjetointisovellusUi-luokassa asetettu Stage-olio
     * @return palauttaa päänäkymän, Scene-olio
     */
    public Scene getMainMenuUi(Stage window) {
        
        VBox layout = new VBox();
        layout.setSpacing(10);
        
        String name = "";
        //name = this.userLogic.getUser().getName();
        //String name = "Pekka";
        //Label welcomeLabel = new Label("Hei " + name + "!");
        Label welcomeLabel = new Label("Tervetuloa!");
        
        Button addEventButton = new Button("Lisää uusi tapahtuma");
        Button listEventsButton = new Button("Näytä kaikki tapahtumat");
        Button showGraphButton = new Button ("Vertaile tuloja ja menoja");
        Button showCategorySumUi = new Button("Tulot ja menot kategorioittain");
        Button logoutButton = new Button("Kirjaudu ulos");
        
        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(addEventButton);
        layout.getChildren().add(listEventsButton);
        layout.getChildren().add(showGraphButton);
        layout.getChildren().add(showCategorySumUi);
        layout.getChildren().add(logoutButton);
        
        layout.setPrefSize(500, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //Scene outlook = new Scene(layout);
        
        addEventButton.setOnAction((event) -> {
            
            AddEventUi addEventUi = new AddEventUi(eventLogic, userLogic, categoryLogic);
            stage2.setScene(addEventUi.getAddEventUiScene(stage2));
            stage2.show();
            
        });
        
        listEventsButton.setOnAction((event) -> {
            ListEventsUi listEventsUi = new ListEventsUi(eventLogic, userLogic);
            stage2.setScene(listEventsUi.getListEventsUiScene(stage2));
            stage2.show();
        });
        
        showGraphButton.setOnAction((event) -> {
            EventGraphUi eventGraphUi = new EventGraphUi(eventLogic, userLogic);
            stage2.setScene(eventGraphUi.getEventGraphUi(stage2));
            stage2.show();
        });
        
        showCategorySumUi.setOnAction((event) -> { 
            CategoriesSumUi sumUi = new CategoriesSumUi(eventLogic, userLogic);
            stage2.setScene(sumUi.getCategoriesSumScene(stage2));
            stage2.show();
        });
        
        /*Label logoutM = new Label("Olet kirjautunut ulos.");
        Label logoutM2 = new Label("Sulje kaikki ikkunat.");
        
        VBox comp = new VBox();
        comp.getChildren().addAll(logoutM, logoutM2);
        comp.setPrefSize(200, 100);
        comp.setAlignment(Pos.CENTER);
        comp.setPadding(new Insets(20, 20, 20, 20));
        
        Scene logoutMessage = new Scene(comp);*/
        
        ///logoutButton.setOnAction((event) -> {
            ///userLogic.logUserOut();
            //LoginUi loginUi = new LoginUi(userLogic, eventLogic, stage2);
            ///window.setScene(logoutMessage);
            //window.setScene(loginUi.getLoginScene(stage2));
            ///window.show();
        ///});
        //window.show();
        
        logoutButton.setOnAction((event) -> {
            logOut(window);
        });
        
        Scene outlook = new Scene(layout);
        
        return outlook;
        
        //window.setScene(outlook);
        
        //window.show();
    }
    
    /**
     * Käyttäjän uloskirjaaminen.
     * 
     * @param window Stage-olio 
     */
    public void logOut(Stage window) {
        this.userLogic.logUserOut();
        window.setScene(this.loginUi);
    }
        
    /*public static void main(String[] args) {
        launch(args);
    }*/
    
}
