package telegrameventbot.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void setUp() {
        this.eventBot = new TelegramEventBot();
    }
    
    @Test
    public void botReturnsCorrectUsername() {
        assertEquals("PrimitiveEventBot", eventBot.getBotUsername());
    }
    
    @Test
    public void readCommandReturnsErrorText() {
        assertEquals("Thats not a command", eventBot.readCommand("asdf", 1));
    }
    
    @After
    public void tearDown() {
    }
    
}
