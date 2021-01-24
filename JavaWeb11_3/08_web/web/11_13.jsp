<%@ page import="com.zph.entity.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/23
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setId(1);
    person.setName("张三");
    List<String> phonesList = new ArrayList<String>();
    phonesList.add("15632142369");
    phonesList.add("15632142379");
    phonesList.add("15632142389");
    person.setPhones(phonesList);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    person.setMap(map);
    pageContext.setAttribute("person", person);
%>
<%--  /*使用EL表达式输出对象中的值*/--%>
id:${person.id}<br/>
name:${person.name}<br/>
phones:${person.phones[0]}&nbsp;${person.phones[1]}&nbsp;${person.phones[2]}&nbsp;<br/>
map:${person.map.key1}&nbsp;${person.map.key2}&nbsp;${person.map.key3}

<%--使用EL内置对象--%>
<br/>
id:${pageScope.person.id}<br/>
name:${pageScope.person.name}<br/>
phones:${pageScope.person.phones[0]}<br/>
map:${pageScope.person.map.keySet()}<br/>
</body>
</html>
