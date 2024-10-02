package database.mysql.main;

import database.mysql.object.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MySQLManager {
    void commit();
    boolean connect(JDBC jdbc) throws SQLException;
    boolean connectCheck() throws SQLException;
    boolean execute(String query);
    ResultSet query(String query);
    void close();
}
