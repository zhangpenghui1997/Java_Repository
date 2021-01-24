<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key","value");
%>
表达式脚本输出：<%=request.getAttribute("key1")%>
<%
    out.write("<br/>");
%>
EL表达式输出：${key1}


</body>
</html>
