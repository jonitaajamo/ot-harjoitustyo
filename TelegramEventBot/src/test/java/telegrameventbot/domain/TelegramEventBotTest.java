package telegrameventbot.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotTest {

    private TelegramEventBot eventBot;
    private Event event;
    private Event event1;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        this.eventBot = new TelegramEventBot("BotKey", "Bot");
        event = new Event(1, "party", "10.10.2010");
        event1 = new Event(2, "picnic", "11.11.2011");
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
    
    
   @Test
   public void attendingEventIsNotSuccesfulWithFalseCommand() {
       String[] command = {"party", "testman"};
       String returnedString = eventBot.attendEvent(command);
       assertEquals("Can't attend event. Command must be in format \"/attend <eventname> <username>\"", returnedString);
   }

   @Test
   public void addingEventFailsWithFalseCommand() {
       String[] command = {"party", "testman"};
       String returnedString = eventBot.addEvent(command);
       assertEquals("Can't add event. Command must be in format \"/addevent <name> <dd.mm.yyyy>\"", returnedString);
   }
   
   @Test
   public void gettingEventsFailsWithFalseCommand() {
       String[] command = {"/events", "test"};
       String returnedString = eventBot.getEvents(command);
       assertEquals("Can't get events. Command must only contain text \"events\".", returnedString);
   }
   
   @Test
   public void gettingEventAttendeesFailsWithFalseCommand() {
       String[] command = {"party"};
       String returnedString = eventBot.getEventAttendees(command);
       assertEquals("Can't get attendees. Command must be in format \"/attending <eventname>\".", returnedString);
   }
   
}
