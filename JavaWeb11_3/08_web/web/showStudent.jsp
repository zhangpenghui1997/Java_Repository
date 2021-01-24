<%@ page import="java.util.List" %>
<%@ page import="com.zph.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/19
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showStudent</title>
    <style type="text/css">
        table{
            border:3px solid greenyellow;
        }
    </style>
</head>
<body>
<table border="1" cellpadding="0">
    <tr><th>编号</th><th>姓名</th><th>年龄</th><th>电话</th></tr>
    <%
        List<Student> studentList = (List) request.getAttribute("studentList");
        for (Student student : studentList) {
    %>
    <tr> <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getPhone()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
