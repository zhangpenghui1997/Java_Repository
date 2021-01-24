<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("keyNull",null);
    request.setAttribute("keyStr","");
    request.setAttribute("keyArr",new String[]{});
    request.setAttribute("keyList",new ArrayList<String>());
    request.setAttribute("keyMap",new HashMap<Object,Object>());
%>
keyNull:${empty key}<br/>
keyStr:${empty keyStr}<br/>
keyArr:${empty keyArr}<br/>
keyList:${empty keyList}<br/>
keyMap:${empty keyMap}<br/>
</body>
</html>
