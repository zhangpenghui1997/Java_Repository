<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="cn.zph.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/22
  Time: 11:11
  To change htis template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set scope="request" var="abc" value="abcValue"/>

${requestScope.abc}

<c:if test="${1==1}">
    <p>1等于1</p>
</c:if>
<%
    request.setAttribute("height", 180);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <p>小巨人</p>
    </c:when>
    <c:when test="${requestScope.height>180}">
        <p>很高</p>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <p>还可以</p>
    </c:when>
    <c:otherwise>
        <p>剩下的情况</p>
    </c:otherwise>
</c:choose>

<c:forEach var="i" begin="1" end="10">
    ${i}<br/>
</c:forEach>
<%
    request.setAttribute("array", new String[]{"15869312412", "18688889999", "18695473214"});
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    request.setAttribute("map", map);
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        out.print(entry.getKey());
    }
%>
<c:forEach items="${requestScope.map}" var="entry">
    <h1>${entry.value}</h1>
</c:forEach>
<c:forEach items="${requestScope.array}" var="item">
    ${item}
</c:forEach>

<%
    List<Student> studentList = new ArrayList<Student>();
    for (int i = 0; i < 10; ++i) {
        studentList.add(new Student(i, "username" + i, "password" + i, 18 + i, "phone" + i));
    }
    request.setAttribute("studentList", studentList);
%>
<table border="1" cellpadding="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.studentList}"  step="2" begin="1" varStatus="status" var="student">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getUsername()}</td>
            <td>${student.getPassword()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getPhone()}</td>
            <td>${status.getIndex()}</td>
        </tr>
    </c:forEach>
    <form enctype="multipart/form-data" method="post"></form>
</table>
</body>
</html>
