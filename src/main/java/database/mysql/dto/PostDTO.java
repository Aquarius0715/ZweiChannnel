package database.mysql.dto;

import java.util.UUID;

public class PostDTO {
    private UUID postUID;
    private UUID threadUID;
    private UUID userUID;
    private String content;
    private int likeCount;

    public PostDTO(UUID postUID, UUID threadUID, UUID userUID, String content, int likeCount) {
        this.postUID = postUID;
        this.threadUID = threadUID;
        this.userUID = userUID;
        this.content = content;
        this.likeCount = likeCount;
    }

    public UUID getPostUID() {
        return postUID;
    }

    public void setPostUID(UUID postUID) {
        this.postUID = postUID;
    }

    public UUID getThreadUID() {
        return threadUID;
    }

    public void setThreadUID(UUID threadUID) {
        this.threadUID = threadUID;
    }

    public UUID getUserUID() {
        return userUID;
    }

    public void setUserUID(UUID userUID) {
        this.userUID = userUID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
