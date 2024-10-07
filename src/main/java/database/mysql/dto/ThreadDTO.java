package database.mysql.dto;

import struct.ThreadStatus;
import struct.ThreadType;

import java.util.ArrayList;
import java.util.UUID;

public class ThreadDTO {
    private UUID threadUID;
    private String threadTitle;
    private String threadCategory;
    private UUID threadOwner;
    private ArrayList<UUID> threadMembers;
    private int impressionCount;
    private int likeCount;
    private ThreadStatus threadStatus;
    private ThreadType threadType;

    public ThreadDTO(UUID threadUID, String threadTitle, String threadCategory, UUID threadOwner, ArrayList<UUID> threadMembers, int impressionCount, int likeCount, ThreadStatus threadStatus, ThreadType threadType) {
        this.threadUID = threadUID;
        this.threadTitle = threadTitle;
        this.threadCategory = threadCategory;
        this.threadOwner = threadOwner;
        this.threadMembers = threadMembers;
        this.impressionCount = impressionCount;
        this.likeCount = likeCount;
        this.threadStatus = threadStatus;
        this.threadType = threadType;
    }

    public UUID getThreadUID() {
        return threadUID;
    }

    public void setThreadUID(UUID threadUID) {
        this.threadUID = threadUID;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public String getThreadCategory() {
        return threadCategory;
    }

    public void setThreadCategory(String threadCategory) {
        this.threadCategory = threadCategory;
    }

    public UUID getThreadOwner() {
        return threadOwner;
    }

    public void setThreadOwner(UUID threadOwner) {
        this.threadOwner = threadOwner;
    }

    public ArrayList<UUID> getThreadMembers() {
        return threadMembers;
    }

    public void setThreadMembers(ArrayList<UUID> threadMembers) {
        this.threadMembers = threadMembers;
    }

    public int getImpressionCount() {
        return impressionCount;
    }

    public void setImpressionCount(int impressionCount) {
        this.impressionCount = impressionCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public ThreadStatus getThreadStatus() {
        return threadStatus;
    }

    public void setThreadStatus(ThreadStatus threadStatus) {
        this.threadStatus = threadStatus;
    }

    public ThreadType getThreadType() {
        return threadType;
    }

    public void setThreadType(ThreadType threadType) {
        this.threadType = threadType;
    }
}
