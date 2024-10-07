package database.mysql.dto;

import struct.TokenStatus;

import java.util.Date;
import java.util.UUID;

public class UserAuthenticateActivityDTO {
    private int id;
    private UUID userUID;
    private String authorizeToken;
    private Date tokenTerm;
    private TokenStatus tokenStatus;

    public UserAuthenticateActivityDTO(int id, UUID userUID, String authorizeToken, Date tokenTerm, TokenStatus tokenStatus) {
        this.id = id;
        this.userUID = userUID;
        this.authorizeToken = authorizeToken;
        this.tokenTerm = tokenTerm;
        this.tokenStatus = tokenStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUserUID() {
        return userUID;
    }

    public void setUserUID(UUID userUID) {
        this.userUID = userUID;
    }

    public String getAuthorizeToken() {
        return authorizeToken;
    }

    public void setAuthorizeToken(String authorizeToken) {
        this.authorizeToken = authorizeToken;
    }

    public Date getTokenTerm() {
        return tokenTerm;
    }

    public void setTokenTerm(Date tokenTerm) {
        this.tokenTerm = tokenTerm;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }
}
