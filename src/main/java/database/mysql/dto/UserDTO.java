package database.mysql.dto;

import java.util.UUID;

public class UserDTO {
    private UUID userUID;
    private String username;
    private String mailAddress;
    private String password;
    private String registration_date;

    public UserDTO(UUID userUID, String username, String mailAddress, String password, String registration_date) {
        this.userUID = userUID;
        this.username = username;
        this.mailAddress = mailAddress;
        this.password = password;
        this.registration_date = registration_date;
    }

    public UserDTO() {
    }

    public UUID getUserUID() {
        return userUID;
    }

    public void setUserUID(UUID userUID) {
        this.userUID = userUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
