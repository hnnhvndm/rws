package main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection {
    private static final Logger LOGGER = Logger.getLogger(MySqlConnection.class.getName());
    private static final String MYSQL_DB_USER = "rws";
    private static final String MYSQL_DB_PASSWORD = "RWSassignment";
    private static final String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/4pp";

    private MySqlConnection() {
        //private constructor to hide the implicit public one
    }

    public static Connection getConnection() {
        Connection connection = null;

        Properties connectionProps = new Properties();
        connectionProps.put("user", MYSQL_DB_USER);
        connectionProps.put("password", MYSQL_DB_PASSWORD);
        connectionProps.put("serverTimezone", "UTC");
        try {
            connection = DriverManager.getConnection(MYSQL_DB_URL, connectionProps);
        } catch (SQLException sqlException) {
            LOGGER.log(Level.SEVERE, sqlException.getMessage());
        }
        return connection;
    }
}
