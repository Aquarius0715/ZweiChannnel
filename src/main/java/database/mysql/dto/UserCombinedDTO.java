package database.mysql.dto;

import struct.Permission;
import struct.UserLimitationLevel;
import struct.UserStatus;

import java.util.Date;
import java.util.UUID;

public class UserCombinedDTO {
    private UUID userUID;
    private String username;
    private String mailAddress;
    private String password;
    private Permission permission;
    private UserStatus userStatus;
    private UserLimitationLevel userLimitationLevel;
    private Date limitationEndDate;
    private Date banEndDate;
    private int disposalCount;
    private int usernameChangeCount;
    private int passwordChangeCount;
}
