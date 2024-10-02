package jp.co.kisarazu.j.fukuoka.zweichannel.object;

import jp.co.kisarazu.j.fukuoka.zweichannel.struct.Status;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String mailAddress;
    private long lastLoginDate;

    public Session() {}
    public Session(String username, String mailAddress, long lastLoginDate, Status authenticateStatus) {
        this.username = username;
        this.mailAddress = mailAddress;
        this.lastLoginDate = lastLoginDate;
        this.authenticateStatus = authenticateStatus;
    }

    public Status getAuthenticateStatus() {
        return authenticateStatus;
    }

    public void setAuthenticateStatus(Status authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    private Status authenticateStatus;

    public String getUsername() {
        return username;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setLastLoginDate(long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
