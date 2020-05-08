
package ui;

import domain.Event;
import domain.EventLogic;
import domain.UserLogic;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Tulojen ja menojen vertailun visuaalisaatiosta vastaava luokka
 * 
 */

public class EventGraphUi {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    
    /**
     * Luokan konstruktori.
     * 
     * @param eventLogic tapahtumien sovelluslogiikasta vastaava luokka
     * @param userLogic käyttäjän sovelluslogiikasta vastaava luokka
     */
    public EventGraphUi(EventLogic eventLogic, UserLogic userLogic) {
        this.eventLogic = eventLogic;
        this.userLogic = userLogic;
    }
    
    /**
     * Luo näkymän, jossa on visualisaatio tuloista ja menoista
     * 
     * @param stage2 BudjetointisovellusUi-luokassa annettu Stage-olio
     * @return palauttaa näkymän Scene-olion
     */
    public Scene getEventGraphUi(Stage stage2) {
        
        Label text = new Label("Tulojen ja menojen vertailu");
        Label saldo = new Label("Tulojesi ja menojesi erotus on ");
        
        List<Event> events = this.eventLogic.getEvents(this.userLogic.getUser().getUsername());
        
        double saldoNumber = this.eventLogic.saldo(events);
        saldo.setText("Tulojesi ja menojesi erotus on "+ saldoNumber);
        
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        BarChart<String, Number> graph = new BarChart<>(x, y);
        
        graph.setLegendVisible(false);
        
        XYChart.Series content = new XYChart.Series();
        content.getData().add(new XYChart.Data("Tulot", this.eventLogic.sumIncome(events)));
        content.getData().add(new XYChart.Data("Menot", this.eventLogic.sumExpence(events)));
        
        graph.getData().add(content);
        
        VBox layout = new VBox();
        layout.getChildren().addAll(text, saldo, graph);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene scene = new Scene(layout, 600, 450);
        
        return scene;
        
    }
    
}
