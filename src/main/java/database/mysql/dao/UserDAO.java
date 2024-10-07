package database.mysql.dao;

import database.mysql.dto.UserDTO;

import java.util.ArrayList;
import java.util.UUID;

public interface UserDAO {
    ArrayList<UserDTO> loadAllUsers();
    UserDTO loadUserByUUID(UUID userUID);
    UserDTO loadUserByUsername(String username);
    UserDTO loadUserByEmail(String email);
    boolean storeUser(UserDTO userDTO);
    boolean storeUsers(ArrayList<UserDTO> userDTOs);
}
