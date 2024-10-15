package database.mysql.dao;

import database.mysql.dto.UserDTO;

import java.util.ArrayList;
import java.util.UUID;

public interface UserDAO {
    ArrayList<UserDTO> loadAllUsers();
    UserDTO loadUserByUUID(UUID userUID);
    UserDTO loadUserByUsernameOrEmail(String username, String email);
    UserDTO loadUserByUsername(String username);
    String loadPasswordByEmail(String emailAddress);
    String loadPasswordByUsername(String username);
    UserDTO loadUserByEmail(String emailAddress);
    boolean storeUser(UserDTO userDTO);
    boolean storeUsers(ArrayList<UserDTO> userDTOs);
}
