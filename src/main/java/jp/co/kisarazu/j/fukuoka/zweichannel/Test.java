package jp.co.kisarazu.j.fukuoka.zweichannel;

import jp.co.kisarazu.j.fukuoka.zweichannel.database.mysql.main.impl.MySQLManagerImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("test", true);
        mySQLManager.execute("INSERT INTO users(user_id, username, mail_address, password) VALUES('userid', 'username', 'mail@gmail.com', 'pass');");
    }
}
