<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/18
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/errorPage.jsp" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- int i = 12 / 0; --%>
<%-- 声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<!--静态初始化块-->
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("k1", "v1");
        map.put("k2", "v2");
    }

%>
<!--定义成员方法-->
<%!
    public int a() {
        return 1;
    }
%>
<!--定义内部类-->
<%!
    public static class A {
        private int a = 1;
        private String b = "a";
    }
%>
<%=1%><br/>
<%=1.1%><br/>
<%="字符串"%><br/>
    <%=map%></br>
<%=request.getParameter("username")%><br/>

<%
    int i = 12;
    if (i == 12) {
        System.out.println("i==12");
    } else {
        System.out.println("i!=12");
    }
%>
<%
    for (i = 0; i < 10; ++i) {
        System.out.println(i);
    }
%>

<%
    String username = request.getParameter("username");
    System.out.println("username:" + username);
%>
<%
    for (i = 0; i < 12; ++i) {
%>
<%=i%><br/>
<%
    }
%>
<table border="1" cellpadding="0">
    <%
        for (i = 0; i < 10; ++i) {
    %>
    <tr>
        <td>第<%=i + 1%>行</td>
    </tr>
    <%
        }
    %>
    <!--html注释-->

    <%
        //java单行注释
        /*java多行注释*/
    %>

    <%--这是jsp注释
    --%>

    <%
        out.write("out输出1<br/>");
        out.flush();
        out.write("out输出2<br/>");
    %>
    <%
        response.getWriter().write("response输出1<br/>");
        response.getWriter().write("response输出2<br/>");
    %>

    <table border="1" cellpadding="0">
    <%
     for(i=1;i<10;++i){
            out.write("<tr>");
         for (int j=1;j<=i;++j){
    %>
            <td><%=j%>*<%=i%>=<%=i*j%></td>
        <%
                }
                out.write("</tr>");
            }
        %>
</table>


</body>
</html>
