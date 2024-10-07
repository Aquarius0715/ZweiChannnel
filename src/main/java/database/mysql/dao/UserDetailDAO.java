package database.mysql.dao;

import database.mysql.dto.UserDetailDTO;
import struct.UserLimitationLevel;
import struct.UserStatus;

import java.util.ArrayList;
import java.util.UUID;

public interface UserDetailDAO {
    ArrayList<UserDetailDTO> loadAllUserDetails();
    UserDetailDTO loadUserDetailByUUID(UUID userUID);
    ArrayList<UserDetailDTO> loadUserDetailsByUserStatus(UserStatus userStatus);
    ArrayList<UserDetailDTO> loadUserDetailsByLimitationLevel(UserLimitationLevel userLimitationLevel);
    boolean storeUserDetail(UserDetailDTO userDetailDTO);
    boolean storeUserDetails(ArrayList<UserDetailDTO> userDetailDTOList);
}
