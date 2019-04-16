package telegrameventbot.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import telegrameventbot.domain.TelegramEventBot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotTest {
    private TelegramEventBot eventBot;
    
    public TelegramEventBotTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        this.eventBot = new TelegramEventBot("BotKey", "Bot");
    }
    
    @Test
    public void botReturnsCorrectUsername() {
        assertEquals("Bot", eventBot.getBotUsername());
    }
    
    @Test
    public void botReturnsCorrectApiKey() {
        assertEquals("BotKey", eventBot.getBotToken());
    }
    
    @Test
    public void checkDateFormatReturnsTrueCorrectly() {
        assertTrue(eventBot.checkDateFormat("12.01.2019"));
    }
    
    @Test
    public void checkDateFormatReturnsFalseCorrectly() {
        assertFalse(eventBot.checkDateFormat("12.01.2"));
    }
    
    @After
    public void tearDown() {
    }
    
}
