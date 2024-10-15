package jp.co.kisarazu.j.fukuoka.zweichannel.model;

import java.io.Serializable;

public class LoginPageMdl implements Serializable {
    private String username;
    private String mailAddress;
    private String password;
    public LoginPageMdl() {}
    public LoginPageMdl(String username, String mailAddress, String password) {
        this.username = username;
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public LoginPageMdl(String mailAddress, String password) {
        this.mailAddress = mailAddress;
        this.password = password;
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
}
