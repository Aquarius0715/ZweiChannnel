package database.mysql.dto;

import struct.ThreadActivityType;

import java.util.Date;
import java.util.UUID;

public class ThreadActivityDTO {
    private int id;
    private UUID threadUID;
    private UUID executorUID;
    private ThreadActivityType threadActivityType;
    private String activityCause;
    private Date activityDate;

    public ThreadActivityDTO(int id, UUID threadUID, UUID executorUID, ThreadActivityType threadActivityType, String activityCause, Date activityDate) {
        this.id = id;
        this.threadUID = threadUID;
        this.executorUID = executorUID;
        this.threadActivityType = threadActivityType;
        this.activityCause = activityCause;
        this.activityDate = activityDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getThreadUID() {
        return threadUID;
    }

    public void setThreadUID(UUID threadUID) {
        this.threadUID = threadUID;
    }

    public UUID getExecutorUID() {
        return executorUID;
    }

    public void setExecutorUID(UUID executorUID) {
        this.executorUID = executorUID;
    }

    public ThreadActivityType getThreadActivityType() {
        return threadActivityType;
    }

    public void setThreadActivityType(ThreadActivityType threadActivityType) {
        this.threadActivityType = threadActivityType;
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
