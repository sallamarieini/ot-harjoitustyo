
package ui;

import domain.UserLogic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Luo sovelluksen kirjautumisnäkymän
 * 
 */

public class LoginUi {
    
    private Scene menu;
    private UserLogic userLogic;
    
    /**
     * Luokan konstruktori.
     * 
     * @param userLogic käyttäjän sovelluslogiikasta vastaava luokka
     */
    public LoginUi(UserLogic userLogic) {
        this.userLogic = userLogic;
        menu = null;
    }
    
    /**
     * Asettaa sovelluksen päävalikon
     * 
     * @param menu päävalikon Scene-olio
     */
    public void setMenuScene(Scene menu) {
        this.menu = menu;
    }
    
    /**
     * Muodostaa kirjautumisnäkymän.
     * 
     * @param stage BudjetointisovellusUi-luokassa luotu Stage-olio
     * @return palauttaa näkymän Scene-olion
     */
    public Scene getLoginScene(Stage stage) {
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
        
        layout.setPrefSize(500, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setSpacing(10);
        
        Scene scene = new Scene(layout);
        
        VBox layout2 = new VBox();
        Label headlineLabel = new Label("Rekisteröidy käyttäjäksi");
        
        Label nameLabel = new Label("Nimi");
        TextField nameField = new TextField();
        Label usernameLabel2 = new Label("Käyttäjänimi");
        TextField usernameField2 = new TextField();
        Label passwordLabel2 = new Label("Salasana");
        PasswordField passwordField2 = new PasswordField();
        Button registerButton2 = new Button("Luo käyttäjätunnus");
        Button previous = new Button("Takaisin");
        
        Label didItWorkLabel = new Label("");
        
        layout2.getChildren().addAll(headlineLabel, nameLabel, nameField, usernameLabel2, 
                usernameField2, passwordLabel2, passwordField2, registerButton2, didItWorkLabel, previous);
        layout2.setPrefSize(500, 400);
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(20, 20, 20, 20));
        layout2.setSpacing(10);
        
        Scene registerScene = new Scene(layout2);
        
        loginButton.setOnAction((event) -> {
            
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            boolean value = this.userLogic.logUserIn(username, password);
            
            if (value == false) {
                didItWork.setText("Käyttäjätunnus tai salasana on virheellinen.");
            } else {
                stage.setScene(menu);
                usernameField.clear();
                passwordField.clear();
                didItWork.setText("");
            }
            
        });
        
        registerButton.setOnAction((event) -> {
            
            stage.setScene(registerScene);
            
        });
        
        registerButton2.setOnAction((event) -> { 
            String name = nameField.getText();
            String username = usernameField2.getText();
            String password = passwordField2.getText();
            if (this.userLogic.usernameLength(username) == true && this.userLogic.passwordLength(password) == true && this.userLogic.nameNotEmpty(name) == true) {
                
                boolean value = this.userLogic.addUser(name, username, password);

                if (value == true) {
                    didItWorkLabel.setText("Rekisteröityminen onnistui.");
                } else {
                    didItWorkLabel.setText("Virhe. Käyttäjätunnus on jo käytössä. Valitse uusi käyttäjätunnus.");
                }
                
            } else {
                didItWorkLabel.setText("Käyttäjätunnuksen ja salasanan tulee olla vähintään 3 merkkiä, \n"
                        + "ja nimen tulee olla vähintään 1 merkin pituinen.");
            }
            
        });
        
        previous.setOnAction((event) -> { 
            stage.setScene(scene);
            usernameField2.clear();
            nameField.clear();
            passwordField2.clear();
            didItWorkLabel.setText("");
        });
        
        return scene;
    }
    
}
