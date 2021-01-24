<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/23
  Time: 11:37
  To change this template use File | Settings | File Templates.
  jsp页面菜单信息公用子模块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8081/book/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
</head>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
