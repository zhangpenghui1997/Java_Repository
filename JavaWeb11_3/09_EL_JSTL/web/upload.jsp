<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/22
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8081/09_EL_JSTL/">
</head>
<body>
<form method="post" enctype="multipart/form-data" action="uploadServlet">
    姓名：<input type="text" name="username"><br/>
    头像：<input type="file" name="hp" id=""><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>
