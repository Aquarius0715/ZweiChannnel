package database.mysql.dto;

import struct.Permission;
import struct.UserActivityType;
import struct.UserStatus;

import java.util.Date;
import java.util.UUID;

public class UserActivityDTO {
    private int id;
    private UUID targetUID;
    private UUID executorUID;
    private UserActivityType activityType;
    private UserStatus statusModified;
    private Permission permissionModified;
    private String activityCause;
    private Date activityDate;

    public UserActivityDTO(int id, UUID targetUID, UUID executorUID, UserActivityType activityType, UserStatus statusModified, Permission permissionModified, String activityCause, Date activityDate) {
        this.id = id;
        this.targetUID = targetUID;
        this.executorUID = executorUID;
        this.activityType = activityType;
        this.statusModified = statusModified;
        this.permissionModified = permissionModified;
        this.activityCause = activityCause;
        this.activityDate = activityDate;
    }

    public int getId() {
        return id;
    }

    public UUID getTargetUID() {
        return targetUID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTargetUID(UUID targetUID) {
        this.targetUID = targetUID;
    }

    public UUID getExecutorUID() {
        return executorUID;
    }

    public void setExecutorUID(UUID executorUID) {
        this.executorUID = executorUID;
    }

    public UserActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(UserActivityType activityType) {
        this.activityType = activityType;
    }

    public UserStatus getStatusModified() {
        return statusModified;
    }

    public void setStatusModified(UserStatus statusModified) {
        this.statusModified = statusModified;
    }

    public Permission getPermissionModified() {
        return permissionModified;
    }

    public void setPermissionModified(Permission permissionModified) {
        this.permissionModified = permissionModified;
    }

    public String getActivityCause() {
        return activityCause;
    }

    public void setActivityCause(String activityCause) {
        this.activityCause = activityCause;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}
