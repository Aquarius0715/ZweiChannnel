package database.mysql.dao.impl;

import database.mysql.dao.UserDAO;
import database.mysql.dto.UserDTO;
import database.mysql.main.impl.MySQLManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<UserDTO> loadAllUsers() {
        return null;
    }

    @Override
    public UserDTO loadUserByUUID(UUID userUID) {
        return null;
    }

    @Override
    public UserDTO loadUserByUsernameOrEmail(String username, String email) {
        return null;
    }

    @Override
    public UserDTO loadUserByUsername(String username) {
        return null;
    }

    @Override
    public String loadPasswordByEmail(String emailAddress) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("loadPasswordByEmail");
        String sql = "SELECT password FROM users WHERE email_address = '" + mySQLManager.escapeString(emailAddress) + "';";
        ResultSet resultSet = mySQLManager.query(sql);
        try {
            if (resultSet.next()) {
                return resultSet.getString("password");
            } else {
                System.err.println("Return null because ResultSet is Empty");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

        @Override
    public String loadPasswordByUsername(String username) {
        MySQLManagerImpl mysqlManager = new MySQLManagerImpl("loadPasswordByUsername");
        String sql = "SELECT password FROM users WHERE username = '" + mysqlManager.escapeString(username) + "';";
        ResultSet resultSet = mysqlManager.query(sql);
        try {
            if (resultSet.next()) {
                return resultSet.getString("password");
            } else {
                System.err.println("Return");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public UserDTO loadUserByEmail(String emailAddress) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("loadUserByEmail");
        String sql = "SELECT * FROM users WHERE mail_address = '" + mySQLManager.escapeString(emailAddress) + "';";
        ResultSet resultSet = mySQLManager.query(sql);
        UserDTO userDTO;
        try {
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setUserUID(UUID.fromString(resultSet.getString("user_uid")));
                userDTO.setUsername(resultSet.getString("username"));
                userDTO.setPassword(resultSet.getString("password"));
                userDTO.setMailAddress(resultSet.getString("mail_address"));
            } else {
                System.err.println("[loadUserByEmail]ResultSet is Empty");
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mySQLManager.close();
        return userDTO;
    }

    @Override
    public boolean storeUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean storeUsers(ArrayList<UserDTO> userDTOs) {
        return false;
    }
}
