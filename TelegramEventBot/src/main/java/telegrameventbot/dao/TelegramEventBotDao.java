/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrameventbot.dao;

import java.sql.*;
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
    
    public void insertNewEvent(long chatId, String name, String date) throws SQLException {
        Connection connection = connect();
        PreparedStatement newEvent = connection.prepareStatement(
                "INSERT INTO Event(\n"
                + " chatId, name, date)\n"
                + " VALUES (?, ?, ?);"
        );
        
        newEvent.setLong(1, chatId);
        newEvent.setString(2, name);
        newEvent.setString(3, date);
        
        newEvent.executeUpdate();
        newEvent.close();
        connection.close();
    }
}
