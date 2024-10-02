package database.mysql.dto;

import struct.Permission;
import struct.UserStatus;

import java.util.Date;

public class UserDetailDTO {
    private String userUID;
    private Permission permission;
    private UserStatus userStatus;
    private Date limitEndDate;
    private Date banEndDate;

    public UserDetailDTO() {}
    public UserDetailDTO(String userUID, Permission permission, UserStatus userStatus, Date limitEndDate, Date banEndDate) {
        this.userUID = userUID;
        this.permission = permission;
        this.userStatus = userStatus;
        this.limitEndDate = limitEndDate;
        this.banEndDate = banEndDate;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Date getLimitEndDate() {
        return limitEndDate;
    }

    public void setLimitEndDate(Date limitEndDate) {
        this.limitEndDate = limitEndDate;
    }

    public Date getBanEndDate() {
        return banEndDate;
    }

    public void setBanEndDate(Date banEndDate) {
        this.banEndDate = banEndDate;
    }
}
