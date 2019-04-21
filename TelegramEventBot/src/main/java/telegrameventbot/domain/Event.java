/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.domain;

/**
 *
 * @author jonitaajamo
 */
public class Event {

    public int id;
    private long chatId;
    private String name;
    private String date;

    public Event(long chatId, int id, String name, String date) {
        this.id = id;
        this.chatId = chatId;
        this.name = name;
        this.date = date;
    }

    public Event(long chatId, String name, String date) {
        this.chatId = chatId;
        this.name = name;
        this.date = date;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.date;
    }

}
