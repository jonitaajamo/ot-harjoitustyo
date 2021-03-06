/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrameventbot.domain.TelegramEventBot;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotUI extends Application {
    String apiKey;
    String username;
    
    public static void main(String[] args) {
        launch(args);
    }
  /**
   * Calls all the required services to launch the bot.
   * 
   * @param stage 
   * @throws Exception If launching the ui fails.
   */
    @Override
    public void start(Stage stage) throws Exception {
        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            apiKey = prop.getProperty("apiKey");
            username = prop.getProperty("username");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        connectToTelegramApi();

        stage.setTitle("Telegram Event Bot");
        Scene scene = new Scene(uiElements(), 200, 100);
        stage.setScene(scene);
        stage.show();

    }
    
   /**
    * Connects to telegram api.
    * 
    * @throws SQLException throws sql exception if db creation fails
    */
    public void connectToTelegramApi() throws SQLException {
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        TelegramEventBot telegramEventBot = new TelegramEventBot(apiKey, username);
        try {
            telegramBotsApi.registerBot(telegramEventBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
   /**
    * Builds ui with javafx.
    * 
    * @return GridPane including wanted elements.
    */
    public GridPane uiElements() {
        Label botStatus = null;
        if (apiKey.equals(null) || username.equals(null)) {
            botStatus = new Label("Token or username missing, add config.properties file.");
        } else {
            botStatus = new Label("Bot status: online");
        }
        GridPane.setConstraints(botStatus, 0, 1);
        Label usernameText = new Label("Username: " + username);
        GridPane.setConstraints(usernameText, 0, 2);
        Label apiKeyText = new Label("Apikey: " + apiKey);
        GridPane.setConstraints(apiKeyText, 0, 3);

        GridPane components = new GridPane();
        components.getChildren().addAll(botStatus, usernameText, apiKeyText);
        
        return components;
    }
}
