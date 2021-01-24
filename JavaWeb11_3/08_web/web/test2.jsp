<%@ page import="com.zph.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/19
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--输出一个表格，含有10个学生的信息--%>

<%
    List<Student> studentList = new ArrayList<Student>();
    for (int i = 0; i < 10; ++i) {
        int t=i+1;
        studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
    }
%>

<table border="1" cellpadding="0">
    <tr><th>id</th><th>name</th><th>age</th><th>phone</th><th>operate</th></tr>
   <%
       for(int i=0;i<10;i++){
   %>
    <tr>
        <td><%=studentList.get(i).getId()%></td>
        <td><%=studentList.get(i).getName()%></td>
        <td><%=studentList.get(i).getAge()%></td>
        <td><%=studentList.get(i).getPhone()%></td>
        <td>delete\update</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
