/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.domain;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotService {
    TelegramBotsApi telegramBotsApi;
    TelegramEventBot telegramEventBot;
    
    public boolean registerBot(){
        ApiContextInitializer.init();
        this.telegramBotsApi = new TelegramBotsApi();
        this.telegramEventBot = new TelegramEventBot();
        try {
            telegramBotsApi.registerBot(this.telegramEventBot);
            return true;
        } catch (TelegramApiException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void stopBot() {
        //TODO
        System.out.println("Haha, can't be stopped");
    }
}
