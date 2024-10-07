package database.mysql.dto;

import struct.Permission;
import struct.UserStatus;

import java.util.Date;
import java.util.UUID;

public class UserDetailDTO {
    private UUID userUID;
    private Permission permission;
    private UserStatus userStatus;
    private Date limitEndDate;
    private Date banEndDate;
    private int disposalCount;
    private int usernameChangeCount;
    private int passwordChangeCount;

    public UserDetailDTO() {}

    public UserDetailDTO(UUID userUID, Permission permission, UserStatus userStatus, Date limitEndDate, Date banEndDate, int disposalCount, int usernameChangeCount, int passwordChangeCount) {
        this.userUID = userUID;
        this.permission = permission;
        this.userStatus = userStatus;
        this.limitEndDate = limitEndDate;
        this.banEndDate = banEndDate;
        this.disposalCount = disposalCount;
        this.usernameChangeCount = usernameChangeCount;
        this.passwordChangeCount = passwordChangeCount;
    }

    public UUID getUserUID() {
        return userUID;
    }

    public void setUserUID(UUID userUID) {
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

    public int getDisposalCount() {
        return disposalCount;
    }

    public void setDisposalCount(int disposalCount) {
        this.disposalCount = disposalCount;
    }

    public int getUsernameChangeCount() {
        return usernameChangeCount;
    }

    public void setUsernameChangeCount(int usernameChangeCount) {
        this.usernameChangeCount = usernameChangeCount;
    }

    public int getPasswordChangeCount() {
        return passwordChangeCount;
    }

    public void setPasswordChangeCount(int passwordChangeCount) {
        this.passwordChangeCount = passwordChangeCount;
    }
}
