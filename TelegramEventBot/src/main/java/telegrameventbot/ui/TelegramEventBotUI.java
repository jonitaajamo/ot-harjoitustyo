/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
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
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        String apiKey = "";
        String username = "";
        
        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            
            apiKey = prop.getProperty("apiKey");
            username = prop.getProperty("username");
            System.out.println("apikey: " + apiKey);
            System.out.println("username: " + username);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        ApiContextInitializer.init();
        
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        TelegramEventBot telegramEventBot = new TelegramEventBot(apiKey, username);
        try {
            telegramBotsApi.registerBot(telegramEventBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
        
        stage.setTitle("Telegram Event Bot");
        
        Label botStatus = new Label("Bot status: online");
        Label usernameText = new Label("username: " + username);
        Label apiKeyText = new Label("Your apikey: " + apiKey);
        
        FlowPane components = new FlowPane();
        components.getChildren().add(botStatus);
        components.getChildren().add(usernameText);
        components.getChildren().add(apiKeyText);
        
        Scene scene = new Scene(components, 200, 100);
        stage.setScene(scene);
        stage.show();
        
        
    }
}
