package main.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Todo: complete class to be able to make connection to databases other than MySQL
 */
public class DatabaseConnection {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String ROOT_PATH = Objects.requireNonNull(Thread.currentThread()
            .getContextClassLoader()
            .getResource(""))
            .getPath();

    private static final String TIMEZONE = "UTC";

    private String dbms;
    private String dbDriver;
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUrl;
    private String dbUserName;
    private String dbPassword;

    private Properties properties;

    public DatabaseConnection(String dbms, String dbDriver, String dbHost, String dbPort, String dbUrl,
                              String dbUserName, String dbPassword) {
        this.dbms = dbms;
        this.dbDriver = dbDriver;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbUrl = dbUrl;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    public Connection getConnection() {
        Connection connection = null;
        setProperties();
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", dbUserName);
        connectionProperties.put("password", dbPassword);
        connectionProperties.put("serverTimeZone", TIMEZONE);
        try {
            connection = DriverManager.getConnection(dbUrl + dbName, connectionProperties);
        } catch (SQLException sqlException) {
            LOGGER.log(Level.SEVERE, sqlException.getMessage());
        }
        return connection;
    }

    private void setProperties() {
        this.properties = new Properties();

        try (FileInputStream input = new FileInputStream(ROOT_PATH + "application.properties")) {
            try {
                properties.load(input);
                this.dbms = properties.getProperty("dbms");
                this.dbDriver = properties.getProperty("database.driver");
                this.dbHost = properties.getProperty("database.host");
                this.dbPort = properties.getProperty("database.port");
                this.dbName = properties.getProperty("database.name");
                this.dbUrl = properties.getProperty("database.url");
                this.dbUserName = properties.getProperty("database.username");
                this.dbPassword = properties.getProperty("database.password");
            } catch (FileNotFoundException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage()); //FileNotFoundException
        }
    }
}
