/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import telegrameventbot.dao.TelegramEventBotDao;
import telegrameventbot.domain.Event;
import telegrameventbot.domain.Event;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotDaoTest {
    TelegramEventBotDao db;
    Event event;
    Event event1;
    
    public TelegramEventBotDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        event = new Event(1, "party", "10.10.2010");
        event1 = new Event(2, "picnic", "11.11.2011");
        try {
            db = new TelegramEventBotDao("test.db");
        } catch (SQLException ex) {
            Logger.getLogger(TelegramEventBotDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        File file = new File("test.db");
        file.delete();
    }

    @Test
    public void addingNewEventAndGettingItByNameSucceeds() throws SQLException{
        db.insertNewEvent(event);
        Event sameEvent = db.getOneEventByNameAndChatId(event.getName(), event.getChatId());
        assertEquals(sameEvent.getName(), event.getName());
    }
    
    @Test
    public void gettingAllEventsSucceeds() throws SQLException{
        db.insertNewEvent(event);
        db.insertNewEvent(event1);
        List<Event> events = db.getAllEvents(1);
        assertEquals(events.get(0).getName(), event.getName());
    }
    
}