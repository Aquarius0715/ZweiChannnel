package database.mysql.dao;

import database.mysql.dto.UserCombinedDTO;
import struct.UserLimitationLevel;
import struct.UserStatus;

import java.util.ArrayList;
import java.util.UUID;

public interface UserCombinedDAO {
    ArrayList<UserCombinedDTO> loadAllUserCombined();
    UserCombinedDTO loadUserCombinedByUUID(UUID uuid);
    UserCombinedDTO loadUserCombinedByUsername(String username);
    UserCombinedDTO loadUserCombinedByEmail(String email);
    ArrayList<UserCombinedDTO> loadUserCombinedByUserStatus(UserStatus userStatus);
    ArrayList<UserCombinedDTO> loadUserCombinedByLimitationLevel(UserLimitationLevel userLimitationLevel);
    boolean storeUserCombined(UserCombinedDTO userCombinedDTO);
    boolean storeUsersCombined(ArrayList<UserCombinedDTO> userCombinedDTOs);
}
