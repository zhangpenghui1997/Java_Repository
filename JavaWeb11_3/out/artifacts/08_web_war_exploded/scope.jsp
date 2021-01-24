<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/19
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scope</title>
</head>
<body>
<%

    //往四个域中分别保存了数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域中是否有值：<%=pageContext.getAttribute("key")%><br/>
request域中是否有值：<%=request.getAttribute("key")%><br/>
session域中是否有值：<%=session.getAttribute("key")%><br/>
application域中是否有值：<%=application.getAttribute("key")%><br/>

<%--<%
    request.getRequestDispatcher("/scope2.jsp").forward(request, response);
%>--%>

<jsp:forward page="/scope2.jsp"></jsp:forward>

</body>
</html>
