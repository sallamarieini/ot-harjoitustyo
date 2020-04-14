
package ui;

import dao.DbDao;
import dao.DbEventDao;
import dao.DbUserDao;
import domain.EventLogic;
import domain.UserLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BudjetointisovellusUi extends Application {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    
    @Override
    public void init() throws Exception {
        
        DbEventDao eventDao = new DbEventDao("budget.db");
        DbUserDao userDao = new DbUserDao("budget.db");
        
        DbDao db = new DbDao();
        db.createDatabase("budget.db");
        
        this.eventLogic = new EventLogic(eventDao);
        this.userLogic = new UserLogic(userDao);
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Stage stage2 = new Stage();
        
        stage2.setTitle("Budjetointisovellus");
        //BudgetUi budgetUi = new BudgetUi(this.userLogic, this.eventLogic, stage2);
        //Scene budgetUiScene = budgetUi.getMainMenuUi(stage);
        LoginUi loginUi = new LoginUi(this.userLogic, this.eventLogic, stage2);
        Scene loginUiScene = loginUi.getLoginScene(stage);
        
        stage.setTitle("Budjetointisovellus");
        //stage.setScene(budgetUiScene);
        stage.setScene(loginUiScene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
