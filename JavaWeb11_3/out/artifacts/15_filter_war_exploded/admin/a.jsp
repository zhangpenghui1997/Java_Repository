<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/12/1
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp页面执行了！");
    Object user=session.getAttribute("user");
    if(user==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>
<p>a.jsp</p>
</body>
</html>
