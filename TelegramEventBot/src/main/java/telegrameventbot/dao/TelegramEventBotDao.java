/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import telegrameventbot.domain.Event;

/**
 *
 * @author jonitaajamo
 */
public class TelegramEventBotDao {

    private String database;

    public TelegramEventBotDao(String databaseName) throws SQLException {
        this.database = databaseName;
        initDatabase();
    }

    private Connection connect() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + database;
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to DB has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void initDatabase() throws SQLException {
        Connection connection = connect();
        PreparedStatement createEventTable = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS Event (\n"
                + " id integer PRIMARY KEY,\n"
                + " chatId integer NOT NULL,\n"
                + " name varchar(50) NOT NULL, \n"
                + " date Date NOT NULL);"
        );
        createEventTable.execute();
        createEventTable.close();

        PreparedStatement createRegistrationTable = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS Registration (\n"
                + " id integer PRIMARY KEY,\n"
                + " event_id integer NOT NULL,\n"
                + " name varchar(50) NOT NULL,\n"
                + " FOREIGN KEY(event_id) REFERENCES Event(id));"
        );
        createRegistrationTable.execute();
        createRegistrationTable.close();

        connection.close();
    }

    public boolean insertNewEvent(Event event) throws SQLException {
        if (eventIsInDb(event)) {
            return false;
        }

        Connection connection = connect();
        PreparedStatement newEvent = connection.prepareStatement(
                "INSERT INTO Event(\n"
                + " chatId, name, date)\n"
                + " VALUES (?, ?, ?);"
        );

        newEvent.setLong(1, event.getChatId());
        newEvent.setString(2, event.getName());
        newEvent.setString(3, event.getDate());

        newEvent.executeUpdate();
        newEvent.close();
        connection.close();

        return true;
    }

    public List<Event> getAllEvents(long chatid) throws SQLException {
        List<Event> events = new ArrayList<>();

        Connection connection = connect();

        PreparedStatement getEventsQuery = connection.prepareStatement("SELECT * FROM Event WHERE chatid = ?;");
        
        getEventsQuery.setLong(1, chatid);
        ResultSet resultSet = getEventsQuery.executeQuery();

        while (resultSet.next()) {
            Event event = new Event(resultSet.getLong("chatId"), resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date"));
            events.add(event);
        }

        getEventsQuery.close();
        resultSet.close();
        connection.close();

        return events;
    }

    public boolean eventIsInDb(Event event) throws SQLException {
        List<Event> eventsInDb = getAllEvents(event.getChatId());
        for (Event e : eventsInDb) {
            if (e.getName().toLowerCase().equals(event.getName().toLowerCase()) && e.getChatId() == event.getChatId()) {
                return true;
            }
        }
        return false;
    }

    public List<String> getEventAttendees(Event event) throws SQLException {
        ArrayList<String> attendees = new ArrayList<>();

        Connection connection = connect();

        PreparedStatement getRegistrationsQuery = connection.prepareStatement(
                "SELECT Registration.name FROM Registration"
                + " LEFT JOIN Event"
                + " ON Registration.event_id = Event.id"
                + " WHERE Event.id = ?");

        getRegistrationsQuery.setInt(1, event.getId());

        ResultSet resultSet = getRegistrationsQuery.executeQuery();

        while (resultSet.next()) {
            attendees.add(resultSet.getString("name"));
        }

        getRegistrationsQuery.close();
        resultSet.close();
        connection.close();

        return attendees;
    }

    public Event getOneEventByNameAndChatId(String name, long chatId) throws SQLException {
        Connection connection = connect();

        PreparedStatement getEventQuery = connection.prepareStatement("SELECT * FROM Event"
                + " WHERE chatId = ? AND name = ?;");
        getEventQuery.setLong(1, chatId);
        getEventQuery.setString(2, name);

        ResultSet resultSet = getEventQuery.executeQuery();

        Event event = new Event(resultSet.getLong("chatId"), resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date"));

        getEventQuery.close();
        resultSet.close();
        connection.close();

        return event;
    }

    public boolean isAttendingEvent(String name, Event event) throws SQLException {
        List<String> attendees = getEventAttendees(event);
        if (attendees.contains(name.toLowerCase())) {
            return true;
        }
        return false;
    }

    public boolean attendEvent(String name, Event event) throws SQLException {
        if (isAttendingEvent(name, event) || !eventIsInDb(event)) {
            return false;
        }

        Connection connection = connect();
        PreparedStatement attendEventQuery = connection.prepareStatement("INSERT INTO Registration"
                + "(event_id, name) VALUES "
                + " (?,?)");

        attendEventQuery.setLong(1, event.getId());
        attendEventQuery.setString(2, name);

        attendEventQuery.executeUpdate();
        attendEventQuery.close();
        connection.close();

        return true;
    }
}
