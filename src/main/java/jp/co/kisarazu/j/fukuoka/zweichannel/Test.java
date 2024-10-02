package jp.co.kisarazu.j.fukuoka.zweichannel;

import database.mysql.main.impl.MySQLManagerImpl;

public class Test {
    public static void main(String[] args) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("test", true);
        mySQLManager.execute("INSERT INTO users(user_uid, username, mail_address, password) VALUES('userid', 'username', 'mail@gmail.com', 'pass');");
    }
}
