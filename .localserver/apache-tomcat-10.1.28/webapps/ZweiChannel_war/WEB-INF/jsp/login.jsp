<%--
  Created by IntelliJ IDEA.
  User: ji1wx
  Date: 9/10/2024
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生徒登録</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <header>
        <h1>&nbsp;CitronKidsManager</h1>
        <text>&emsp;ver 1.0.0-SNAPSHOT</text>
    </header>
    <br><br><br>
</head>
<body>
<center>
    <div class="text-align: center">
        <br>
        <form action="Login" method="post">
            <label>
                ユーザー名:
                <input type="text" name="user">
            </label><br>
            <label>
                パスワード:
                <input type="password" name="pass">
            </label><br>
            <input type="submit" value="ログイン">
        </form>
    </div>
</center>
</body>
</html>
