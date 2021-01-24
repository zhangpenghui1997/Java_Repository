<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2021/1/21
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var person ={
            name:"张三",
            age:18,
            gender:"男"
        };
        console.log(person);
        var str = JSON.stringify(person);
        console.log(str);

        var json =JSON.parse(str);
        console.log(json);
    </script>
</head>
<body>

</body>
</html>
