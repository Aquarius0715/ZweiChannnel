package database.mysql.main.impl;

import database.mysql.main.MySQLFunctions;
import database.mysql.main.MySQLManager;
import database.mysql.object.JDBC;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLManagerImpl implements MySQLManager {
    private JDBC jdbc;
    private boolean isDebugMode;
    private boolean isConnected;
    private Statement statement;
    private Connection connection;
    private MySQLFunctions mySQLFunctions;
    private final String connectionName;

    public MySQLManagerImpl(String connectionName) {
        this.connectionName = connectionName;
        isDebugMode = false;
        jdbc = new JDBC();
        loadConfig();
        isConnected = false;
    }

    public MySQLManagerImpl(String connectionName, boolean isDebugMode) {
        this.connectionName = connectionName;
        this.isDebugMode = isDebugMode;
        jdbc = new JDBC();
        loadConfig();
        isConnected = false;
    }
    private void loadConfig() {
        String path = "src/main/resources/JDBC_config.properties";
        Properties properties = new Properties();
        try {
            properties.load(Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jdbc.setHostname(properties.getProperty("hostname"));
        jdbc.setDatabase(properties.getProperty("database"));
        jdbc.setUsername(properties.getProperty("username"));
        jdbc.setPassword(properties.getProperty("password"));
        jdbc.setPort(properties.getProperty("port"));
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean connect(JDBC jdbc) throws SQLException {
        this.jdbc = jdbc;
        mySQLFunctions = new MySQLFunctionsImpl(jdbc);
        connection = mySQLFunctions.open();
        if (connection == null) {
            System.err.println("Failed to Open MySQL(In MySQLManager connect Function)");
            return false;
        }
        StringBuilder msg;
        try {
            statement = connection.createStatement();
            isConnected = true;
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Connected to the database");
            System.out.println(msg);
        } catch (SQLException e) {
            isConnected = false;
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Could not connect to the database");
            e.fillInStackTrace();
        }
        mySQLFunctions.close(connection);
        return isConnected;
    }

    @Override
    public boolean connectCheck() throws SQLException {
        return connect(this.jdbc);
    }

    @Override
    public boolean execute(String query) {
        StringBuilder msg;
        mySQLFunctions = new MySQLFunctionsImpl(jdbc);
        connection = mySQLFunctions.open();
        if (connection == null) {
            System.err.println("Failed to open MySQL");
            return false;
        }
        boolean ret = true;
        if (isDebugMode) {
            System.out.println(query);
        }
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Error executing statement: ");
            msg.append(e.getErrorCode());
            msg.append(":");
            msg.append(e.getMessage());
            System.err.println(msg);
            ret = false;
        }
        close();
        return ret;
    }

    @Override
    public ResultSet query(String query) {
        StringBuilder msg;
        mySQLFunctions = new MySQLFunctionsImpl(jdbc);
        connection = mySQLFunctions.open();
        ResultSet resultSet = null;
        if (connection == null) {
            System.err.println("failed to open MySQL");
            return null;
        }
        if (isDebugMode) {
            System.out.println(query);
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.fillInStackTrace();
            msg = new StringBuilder();
            msg.append(connectionName);
            msg.append("] Error executing query: ");
            msg.append(e.getErrorCode());
            msg.append(":");
            msg.append(e.getMessage());
            msg.append(e.getMessage());
            System.err.println(msg);
        }
        return resultSet;
    }

    @Override
    public void close() {
        try {
            statement.close();
            connection.close();
            mySQLFunctions.close(connection);
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    public void setDebugMode(boolean isDebugMode) {
        this.isDebugMode = isDebugMode;
    }
    public boolean getDebugMode() {
        return isDebugMode;
    }
}
