package database.mysql.dao;

import database.mysql.dto.UserAuthenticateActivityDTO;
import struct.TokenStatus;

import java.util.ArrayList;
import java.util.UUID;

public interface UserAuthenticateActivityDAO {
    UserAuthenticateActivityDTO loadUserAuthenticateActivity(UUID userUID, String authorizeToken);
    UserAuthenticateActivityDTO loadUserAuthenticateActivity(UUID userUID, String authorizeToken, TokenStatus tokenStatus);
    ArrayList<UserAuthenticateActivityDTO> loadAllUserAuthenticateActivity();
    boolean storeUserAuthenticateActivity(UserAuthenticateActivityDTO userAuthenticateActivityDTO);
}
