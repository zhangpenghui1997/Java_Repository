<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {

            $("a.deleteClass").click(function () {
                /*
                 confirm是时间提示框
                * 返回true代表确认
                * 返回false代表取消
                * */
                //先将dom对象转换为jQuery对象，取两次父元素，查找子元素的文本内容
                return confirm("你确定删除[" + $(this).parent().parent().find("td:first").text() + "]吗？")
            });
            //调到指定的页码
            $(".btnClass").click(function () {
                var pageNo = $("#pn_input").val();
                if (pageNo == "" || pageNo == null) {
                    alert("页码数不能为空！");
                    return;
                } else if (pageNo > ${requestScope.page.pageTotal} || pageNo < 1) {
                    alert("页码数不合法！");
                    return;
                }
                //alert("${requestScope.basePath}");
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<%--<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="pages/manager/book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="pages/manager/book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="pages/manager/book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="pages/manager/book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>

</div>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>
<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>