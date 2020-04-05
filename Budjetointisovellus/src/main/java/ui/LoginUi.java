
package ui;

import domain.EventLogic;
import domain.UserLogic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUi {
    
    private UserLogic userLogic;
    private EventLogic eventLogic;
    private Stage stage2;
    
    public LoginUi(UserLogic userLogic, EventLogic eventLogic, Stage stage2) {
        this.userLogic = userLogic;
        this.eventLogic = eventLogic;
        this.stage2 = stage2;
    }
    
    public Scene getLoginScene(Stage window) {
        
        VBox layout = new VBox();
        
        Button registerButton = new Button("Luo uusi käyttäjätunnus");
        
        Label usernameLabel = new Label("Käyttäjätunnus");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Salasana");
        PasswordField passwordField = new PasswordField();
        
        Button loginButton = new Button("Kirjaudu sisään");
        
        Label didItWork = new Label("");
        
        layout.getChildren().addAll(registerButton, usernameLabel, usernameField, 
                passwordLabel, passwordField, loginButton, didItWork);
        
        registerButton.setOnAction((event) -> {
            
            CreateNewUserUi newUserUi = new CreateNewUserUi(userLogic);
            stage2.setScene(newUserUi.getCreateUserUi(stage2));
            stage2.show();
            
        });
        
        loginButton.setOnAction((event) -> {
            
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            boolean value = this.userLogic.logUserIn(username, password);
            
            if (value == true) {
                BudgetUi budgetUi = new BudgetUi(this.userLogic, this.eventLogic, this.stage2);
                try {
                    window.setScene(budgetUi.getMainMenuUi(stage2));
                } catch (Exception ex) {
                    didItWork.setText("Et ole kirjautunut sisään.");
                }
            } else {
                didItWork.setText("Käyttäjätunnus tai salasana on virheellinen.");
            }
            
        });
        
        layout.setPrefSize(500, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setSpacing(10);
        
        Scene scene = new Scene(layout);
        
        return scene;
        
    }
    
}
