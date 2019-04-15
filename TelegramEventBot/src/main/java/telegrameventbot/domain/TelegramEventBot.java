/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.domain;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBot extends TelegramLongPollingBot {
    private String apiKey;
    private String userName;
    
    public TelegramEventBot(String apiKey, String username) {
        this.apiKey = apiKey;
        this.userName = username;
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String messageText = message.getText();
            long chatId = update.getMessage().getChatId();

            readCommand(messageText, chatId);
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return apiKey;
    }

    public Message sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(text);
        try {
            return execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readCommand(String messageText, long chatId) {
        String command = messageText.split(" ")[0];
        String answer = "Something went terribly wrong.";

        if (command.startsWith("/")) {
            switch (command) {
                case "/addevent":
                    answer = "Tried to add event, but failed";
                case "/attend":
                    answer = "Tried to attend event, but failed";
            }
        } else {
            answer = "Thats not a command";
        }

        sendMessage(answer, chatId);
        return answer;
    }
    
    public void addEvent(String event, long chatId) {
        
    }
}
