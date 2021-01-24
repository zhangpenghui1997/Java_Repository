<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/23
  Time: 11:56
  To change this template use File | Settings | File Templates.

  jsp头部信息公用模块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>

<base href="<%=basePath%>"/>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css" />