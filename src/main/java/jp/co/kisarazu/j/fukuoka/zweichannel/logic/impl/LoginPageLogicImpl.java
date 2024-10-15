package jp.co.kisarazu.j.fukuoka.zweichannel.logic.impl;

import database.mysql.dao.impl.UserDAOImpl;
import jp.co.kisarazu.j.fukuoka.zweichannel.logic.LoginPageLogic;
import jp.co.kisarazu.j.fukuoka.zweichannel.model.LoginPageMdl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class LoginPageLogicImpl implements LoginPageLogic {
    @Override
    public boolean checkAuthenticate(LoginPageMdl mdl) throws NoSuchAlgorithmException {
        if (mdl == null) {
            System.err.println("LoginPageMdl is null");
            return false;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(mdl.getMailAddress(), userDAO.loadPasswordByEmail(mdl.getMailAddress()))) {
            return true;
        } else {
            System.err.println("ユーザーネームが間違っている、またはパスワードが間違っています。");
            return false;
        }
    }

    UserDAOImpl userDAO = new UserDAOImpl();
}
