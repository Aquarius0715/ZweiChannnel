package jp.co.kisarazu.j.fukuoka.zweichannel.logic.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.kisarazu.j.fukuoka.zweichannel.logic.SessionManagementLogic;
import jp.co.kisarazu.j.fukuoka.zweichannel.object.Session;
import jp.co.kisarazu.j.fukuoka.zweichannel.struct.ConvertedToSeconds;
import jp.co.kisarazu.j.fukuoka.zweichannel.struct.SessionStatus;

import java.io.IOException;
import java.util.Date;

public class SessionManagementLogicImpl implements SessionManagementLogic {
    public static SessionStatus checkSession(HttpServletRequest request, HttpServletResponse response) {
        Session session = (Session) request.getSession().getAttribute("session");
        if (session == null) {
            return SessionStatus.INVALID;
        }
        long currentDate = new Date().getTime();
        long differenceOfTime = currentDate - session.getLastLoginDate();
        long allowedTime = ConvertedToSeconds.DAY.ordinal();
        if (differenceOfTime > allowedTime) {
            return SessionStatus.EXCEED;
        } else {
            return SessionStatus.VALID;
        }
    }

    public static void screenNavigator(HttpServletRequest request, HttpServletResponse response, String destination) throws ServletException, IOException {
        SessionStatus sessionStatus = checkSession(request, response);
        switch (sessionStatus) {
            case VALID:
                request.getRequestDispatcher("WEB-INF/jsp/" + destination)
                        .forward(request, response);
                break;
            case INVALID:
                request.getSession().setAttribute("message", "Welcome to the ZweiChannel");
                request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
                        .forward(request, response);
                break;
            case EXCEED:
                request.getSession().setAttribute("message", "ログインしてから一定時間が経過したため、ログインページに遷移しました。");
                request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
                        .forward(request, response);
        }
    }
}
