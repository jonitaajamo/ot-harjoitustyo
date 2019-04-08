/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.ui;

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
        ApiContextInitializer.init();
        
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        TelegramEventBot telegramEventBot = new TelegramEventBot();
        try {
            telegramBotsApi.registerBot(telegramEventBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
        stage.setTitle("Telegram Event Bot");
        
        Label botStatus = new Label("Bot status: online");
        
        
        FlowPane components = new FlowPane();
        components.getChildren().add(botStatus);
        
        
        Scene scene = new Scene(components, 200, 100);
        stage.setScene(scene);
        stage.show();
        
        
    }
}
