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
import telegrameventbot.domain.TelegramEventBotService;

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
        TelegramEventBotService telegrameventbot = new TelegramEventBotService();
        telegrameventbot.registerBot();
        
        stage.setTitle("Telegram Event Bot");
        
        Label botStatus = new Label("Bot status: ");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(botStatus);
        
        
        Scene scene = new Scene(components, 200, 100);
        stage.setScene(scene);
        stage.show();
        
        
    }
}
