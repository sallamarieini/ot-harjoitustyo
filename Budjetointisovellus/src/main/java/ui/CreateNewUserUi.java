
package ui;

import domain.UserLogic;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateNewUserUi {
    
    private UserLogic userLogic;
    
    public CreateNewUserUi(UserLogic userLogic) {
        this.userLogic = userLogic;
    }
    
    public Scene getCreateUserUi(Stage stage) {
        
        VBox components = new VBox();
        
        Label headlineLabel = new Label("Rekisteröidy käyttäjäksi");
        
        Label nameLabel = new Label("Nimi");
        TextField nameField = new TextField();
        Label usernameLabel = new Label("Käyttäjänimi");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Salasana");
        PasswordField passwordField = new PasswordField();
        Button registerButton = new Button("Luo käyttäjätunnus");
        
        Label didItWorkLabel = new Label("");
        
        components.getChildren().addAll(headlineLabel, nameLabel, nameField, usernameLabel, 
                usernameField, passwordLabel, passwordField, registerButton, didItWorkLabel);
        
        registerButton.setOnAction((event) -> {
            
            String name = nameField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            boolean value = this.userLogic.addUser(name, username, password);
            
            if (value == true) {
                didItWorkLabel.setText("Rekisteröityminen onnistui.");
            } else {
                didItWorkLabel.setText("Virhe. Rekisteröityminen epäonnistui.");
            }
        
        });
        
        components.setPadding(new Insets(15));
        
        Scene scene = new Scene(components);
        
        return scene;
        
    }
    
}
