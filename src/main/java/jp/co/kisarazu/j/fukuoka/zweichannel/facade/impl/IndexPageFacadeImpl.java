package jp.co.kisarazu.j.fukuoka.zweichannel.facade.impl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.kisarazu.j.fukuoka.zweichannel.facade.IndexPageFacade;
import jp.co.kisarazu.j.fukuoka.zweichannel.logic.impl.SessionManagementLogicImpl;

import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "index", value = "/")
public class IndexPageFacadeImpl extends HttpServlet implements IndexPageFacade, Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionManagementLogicImpl.screenNavigator(request, response, "home.jsp");
    }
}