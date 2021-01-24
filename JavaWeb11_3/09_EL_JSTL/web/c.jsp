<%@ page import="cn.zph.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2020/11/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person=new Person();
    person.setName("张三");
    List<String> cityList=new ArrayList<String>();
    cityList.add("北京");
    cityList.add("南京");
    cityList.add("东京");
    person.setCities(cityList);

    person.setPhones(new String[]{"18016231369","18816412636","13765498265"});

    Map<String,Object> map=new HashMap<String,Object>();
    map.put("key1","value1");
    map.put("key2","value2");
    person.setMap(map);

    pageContext.setAttribute("person",person);

%>
输出Person:${person}<br/>
输出Person的name属性:${person.name}<br/>
输出Person的phones数组属性值:${person.phones[0]}<br/>
输出cities集合中的元素值:${person.cities}<br/>
输出Person的Map集合:${person.map}<br/>
输出Person的Map集合中某个key的值1:${person.map.key1}<br/>


</body>
</html>
