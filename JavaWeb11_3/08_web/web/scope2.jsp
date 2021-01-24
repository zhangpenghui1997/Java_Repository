<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/19
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2</title>
</head>
<body>
Scope2.jsp页面<br>
pageContext域中是否有值：<%=pageContext.getAttribute("key")%><br/>
request域中是否有值：<%=request.getAttribute("key")%><br/>
session域中是否有值：<%=session.getAttribute("key")%><br/>
application域中是否有值：<%=application.getAttribute("key")%><br/>
</body>
</html>
