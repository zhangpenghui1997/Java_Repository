<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //pageContext.setAttribute("key1","pageContext");
    //request.setAttribute("key1","request");
    application.setAttribute("key1","application");
   // session.setAttribute("key1","session");


%>
${key1}
</body>
</html>
