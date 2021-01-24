<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/22
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username=request.getParameter("username");
    out.write(username);
%>
<br/>
EL表达式的输出：${param.username}<br/>
EL表达式的输出（hobby）：${paramValues.hobby[0]}<br/>
EL表达式的输出（hobby）：${paramValues.hobby[1]}<br/>

header:${header}<br>
header[User-Agent]:${header["User-Agent"]}<br/>
cookie:${cookie}<br/>

username:${initParam.username}<br/>
url:${initParam.url}<br/>

</body>
</html>
