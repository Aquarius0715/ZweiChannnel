package jp.co.kisarazu.j.fukuoka.zweichannel.database.mysql.main;

import java.sql.Connection;
import java.sql.SQLException;

public interface MySQLFunctions {
    Connection open();
    boolean checkConnection();
    void close(Connection connection) throws SQLException;
}
