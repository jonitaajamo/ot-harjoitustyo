/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        stage.setTitle("Telegram Event Bot");
        
        Button launchButton = new Button("Launch");
        
        Scene scene = new Scene(launchButton, 200, 100);
        stage.setScene(scene);
        stage.show();
        
        
        launchButton.setOnAction(event -> {
            if(launchButton.getText().equals("Launch")) {
                System.out.println("Launched successfully");
                telegrameventbot.registerBot();
                launchButton.setText("Turn off");
            }else{
                telegrameventbot.stopBot();
            }
        });
        
        
    }
}
