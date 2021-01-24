<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/28
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <base href="http://localhost:8080/13_cookie_session/">
</head>
<body>
<form action="loginServlet" method="post">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
