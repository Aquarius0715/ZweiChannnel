package jp.co.kisarazu.j.fukuoka.zweichannel.database.mysql.main.impl;

import jp.co.kisarazu.j.fukuoka.zweichannel.database.mysql.main.MySQLFunctions;
import jp.co.kisarazu.j.fukuoka.zweichannel.database.mysql.object.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFunctionsImpl implements MySQLFunctions {
    JDBC jdbc;
    Connection connection;

    public MySQLFunctionsImpl(JDBC jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Connection open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" +
                    jdbc.getHostname() +
                    ":" +
                    jdbc.getPort() +
                    "/" +
                    jdbc.getDatabase() +
                    "?allowPublicKeyRetrieval=true&useSSL=false";
            connection = DriverManager.getConnection(url, jdbc.getUsername(), jdbc.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public boolean checkConnection() {
        return connection != null;
    }

    @Override
    public void close(Connection connection) throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
