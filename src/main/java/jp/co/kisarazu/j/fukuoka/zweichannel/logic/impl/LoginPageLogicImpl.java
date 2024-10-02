package jp.co.kisarazu.j.fukuoka.zweichannel.logic.impl;

import jp.co.kisarazu.j.fukuoka.zweichannel.logic.LoginPageLogic;
import jp.co.kisarazu.j.fukuoka.zweichannel.model.LoginPageMdl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class LoginPageLogicImpl implements LoginPageLogic {
    @Override
    public boolean checkAuthenticate(LoginPageMdl mdl) throws NoSuchAlgorithmException {
        if (mdl == null) {
            System.err.println("LoginPageMdl is null");
            BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
            return false;
        }
        return false;
    }
}
