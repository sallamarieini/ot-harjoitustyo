
package ui;

import dao.DbCategoryDao;
import dao.DbDao;
import dao.DbEventDao;
import dao.DbUserDao;
import domain.CategoryLogic;
import domain.EventLogic;
import domain.UserLogic;
import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Sovelluksen alustava ja käynnistävä luokka
 * 
 */

public class BudjetointisovellusUi extends Application {
    
    private EventLogic eventLogic;
    private UserLogic userLogic;
    private CategoryLogic categoryLogic;
    
    /**
     * Suorittaa tarvittavat alustukset.
     * 
     * @throws Exception Virheen tapahtuessa heittää poikkeuksen.
     */
    @Override
    public void init() throws Exception {
        
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        
        String dbname = properties.getProperty("dbname");
        
        DbEventDao eventDao = new DbEventDao(dbname);
        DbUserDao userDao = new DbUserDao(dbname);
        
        Properties cProperties = new Properties();
        cProperties.load(new FileInputStream("categories.txt"));
        
        /*String eka = cProperties.getProperty("a");
        categoryLogic.addNewCategory(eka);*/
        //System.out.println(cProperties.stringPropertyNames());
        
        DbCategoryDao categoryDao = new DbCategoryDao(dbname);
        
        DbDao db = new DbDao();
        db.createDatabase(dbname);
        
        this.eventLogic = new EventLogic(eventDao);
        this.userLogic = new UserLogic(userDao);
        this.categoryLogic = new CategoryLogic(categoryDao);
        
        for (String category: cProperties.stringPropertyNames()) {
            String v = cProperties.getProperty(category);
            //System.out.println(v);
            this.categoryLogic.addNewCategory(v);
        }
        
    }
    
    /**
     * Muodostaa sovelluksen ikkunan.
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        Stage stage2 = new Stage();
        
        stage2.setTitle("Budjetointisovellus");
        
        //LoginUi loginUi = new LoginUi(this.userLogic, this.eventLogic, this.categoryLogic, stage2);
        LoginUi loginUi = new LoginUi(userLogic);
        Scene loginUiScene = loginUi.getLoginScene(stage);
        
        BudgetUi budgetUi = new BudgetUi(userLogic, eventLogic, categoryLogic, loginUiScene, stage2);
        Scene menu = budgetUi.getMainMenuUi(stage);
        
        loginUi.setMenuScene(menu);
        
        stage.setTitle("Budjetointisovellus");
        stage.setScene(loginUiScene);
        stage.show();
        
    }
    
    /**
     * Käynnistää sovelluksen.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
