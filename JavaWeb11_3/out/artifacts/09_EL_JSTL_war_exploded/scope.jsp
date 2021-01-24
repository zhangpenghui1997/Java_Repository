<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key1", "pageContext1");
    pageContext.setAttribute("key2", "pageContext2");
%>
${pageScope.key1}<br/>
${pageContext}
</body>
</html>
