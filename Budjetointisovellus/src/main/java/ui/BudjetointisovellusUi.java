
package ui;

import dao.DbDao;
import dao.DbEventDao;
import domain.EventLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BudjetointisovellusUi extends Application {
    
    private EventLogic eventLogic;
    
    public void init() throws Exception {
        
        DbEventDao eventDao = new DbEventDao();
        
        DbDao db = new DbDao();
        db.createDatabase();
        
        this.eventLogic = new EventLogic(eventDao);
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Stage stage2 = new Stage();
        
        BudgetUi budgetUi = new BudgetUi(this.eventLogic, stage2);
        Scene budgetUiScene = budgetUi.getMainMenuUi(stage);
        
        stage.setScene(budgetUiScene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
