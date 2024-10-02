package jp.co.kisarazu.j.fukuoka.zweichannel.facade.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.kisarazu.j.fukuoka.zweichannel.facade.LoginPageFacade;
import jp.co.kisarazu.j.fukuoka.zweichannel.logic.impl.SessionManagementLogicImpl;
import jp.co.kisarazu.j.fukuoka.zweichannel.model.LoginPageMdl;

import java.io.IOException;
import java.io.Serializable;

public class LoginPageFacadeImpl extends HttpServlet implements LoginPageFacade, Serializable {
    private final static long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionManagementLogicImpl.screenNavigator(request, response, "home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        LoginPageMdl mdl = new LoginPageMdl(username, password);
    }

}
