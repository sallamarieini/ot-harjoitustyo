
package ui;

import domain.Event;
import domain.EventLogic;
import domain.UserLogic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * Tulojen ja menojen vertailusta kategorioittain vastaava luokka
 * 
 */
public class CategoriesSumUi {
    
    private UserLogic userLogic;
    private EventLogic eventLogic;
    
    /**
     * Luokan konstruktori
     * 
     * @param eventLogic tapahtumien sovelluslogiikka
     * @param userLogic käyttäjän sovelluslogiikka
     */
    public CategoriesSumUi(EventLogic eventLogic, UserLogic userLogic) {
        this.eventLogic = eventLogic;
        this.userLogic = userLogic;
    }
    
    /**
     * Muodostaa menoja ja tuloja kategorioittaisen vertailun näkymän
     * 
     * @param stage2 BudjetointisovellusUi luokassa asetettu Stage-olio
     * @return palauttaa näkymän Scene-olion
     */
    public Scene getCategoriesSumScene(Stage stage2) {
        
        Label text = new Label("Tulojen ja menojen vertailu kategorioittain");
        
        List<Event> events = this.eventLogic.getEvents(this.userLogic.getUser().getUsername());
        HashMap<String, Double> sums = this.eventLogic.categoriesSum(events);
        
        CategoryAxis xSum = new CategoryAxis();
        NumberAxis ySum = new NumberAxis();
        BarChart<String, Number> graphSum = new BarChart<>(xSum, ySum);
        
        graphSum.setLegendVisible(true);
        
        XYChart.Series contentExpence = new XYChart.Series();
        contentExpence.setName("Menot");
        XYChart.Series contentIncome = new XYChart.Series();
        contentIncome.setName("Tulot");
        
        for (Map.Entry<String, Double> event: sums.entrySet()) {
            String k = event.getKey();
            Double s = event.getValue();
            
            if (s < 0) {
                contentExpence.getData().add(new XYChart.Data(k, Math.abs(s)));
            } else {
                contentIncome.getData().add(new XYChart.Data(k, s));
            }
        }
        
        graphSum.getData().add(contentExpence);
        graphSum.getData().add(contentIncome);
        
        VBox layout = new VBox();
        layout.getChildren().addAll(text, graphSum);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene scene = new Scene(layout, 600, 450);
        
        return scene;
        
    }
    
}
