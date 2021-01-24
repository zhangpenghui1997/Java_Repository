<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("req",request);
%>
<%=request.getScheme()%><br/>
协议：${req.scheme}<br/>
服务器ip：${pageContext.request.serverName}<br/>
服务器port：${pageContext.request.serverPort}<br/>
工程路径：${pageContext.request.contextPath}<br/>
请求方式：${pageContext.request.method}<br/>
客户端ip地址：${pageContext.request.remoteHost}<br/>
会话id编号：${pageContext.session.id}<br/>


</body>
</html>
