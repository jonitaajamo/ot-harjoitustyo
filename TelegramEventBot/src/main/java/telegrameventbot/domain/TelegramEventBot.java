/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.domain;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrameventbot.dao.TelegramEventBotDao;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBot extends TelegramLongPollingBot {

    private String apiKey;
    private String userName;
    private TelegramEventBotDao db;

    public TelegramEventBot(String apiKey, String username) throws SQLException {
        this.apiKey = apiKey;
        this.userName = username;
        this.db = new TelegramEventBotDao("event.db");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            long chatId = update.getMessage().getChatId();

            readCommand(message, chatId);
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

    public String readCommand(Message message, long chatId) {
        String[] command = message.getText().split(" ");
        String answer = "Something went terribly wrong. Contact my creator.";

        if (command[0].startsWith("/")) {
            switch (command[0]) {
                case "/addevent":
                    answer = addEvent(command, chatId);
                    break;
                case "/attend":
                    answer = attendEvent(command, chatId);
                    break;
            }
        } else {
            answer = "Thats not a command";
        }

        sendMessage(answer, chatId);
        return answer;
    }

    public String addEvent(String[] command, long chatId) {
        if (command.length == 3 && checkDateFormat(command[2])) {
            Event newEvent = new Event(chatId, command[1], command[2]);
            try {
                boolean addedSuccesfully = db.insertNewEvent(newEvent);
                if (!addedSuccesfully) {
                    return "Event with the name " + newEvent.getName() + " is already added, try a different one.";
                }
                return command[1] + " saved succesfully for " + command[2] + ". You can now use /attend <eventname> <username>";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Something went wrong, event not saved.";
            }
        }
        return "Can't add event. Command must be in format \"/addevent <name> <dd.mm.yyyy>\"";
    }

    public boolean checkDateFormat(String date) {
        if (date.matches("^([0-2][0-9]||3[0-1]).(0[0-9]||1[0-2]).([0-9][0-9])?[0-9][0-9]$")) {
            return true;
        }
        return false;
    }

    public String attendEvent(String[] command, long chatId) {
        if (command.length == 3) {
            try {
                Event eventToAttend = db.getOneEventByNameAndChaId(command[1], chatId);
                if (db.isAttendingEvent(command[2], eventToAttend)) {
                    return command[2] + " is already attending " + eventToAttend.getName();
                }
                if (db.attendEvent(command[1], eventToAttend)) {
                    return command[2] + " is now attending " + eventToAttend.getName() + " on " + eventToAttend.getDate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelegramEventBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Can't attend event. Command must be in format \"/attend <eventname> <username>";
    }
}
