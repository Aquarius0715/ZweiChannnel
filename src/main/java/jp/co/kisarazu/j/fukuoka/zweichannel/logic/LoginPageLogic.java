package jp.co.kisarazu.j.fukuoka.zweichannel.logic;

import jp.co.kisarazu.j.fukuoka.zweichannel.model.LoginPageMdl;

import java.security.NoSuchAlgorithmException;

public interface LoginPageLogic {
    public boolean checkAuthenticate(LoginPageMdl mdl) throws NoSuchAlgorithmException;
}
