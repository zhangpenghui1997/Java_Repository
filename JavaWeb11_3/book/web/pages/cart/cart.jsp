<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a#clearCart").click(function () {
                return confirm("你确定清空购物车吗？")
            });

            $("a#delete").click(function () {
                return confirm("你确定删除[" + $(this).parent().parent().find("td:first").text() + "]吗？")
            });

            $(".subBtn").click(function () {
                var countStr=$(this).parent().find("span").text();
                var count=Number(countStr);
                if(count>1){
                    count-=1;
                    var id=$(this).attr("bookId");

                    location.href="${basePath}cartServlet?action=updateCount&id="+id+"&count="+count;
                }
            });
            $(".addBtn").click(function () {
                var countStr=$(this).parent().find("span").text();
                var count=Number(countStr);
                    count+=1;
                    var id=$(this).attr("bookId");
                    location.href="${basePath}cartServlet?action=updateCount&id="+id+"&count="+count;
            });
        });
    </script>

</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/info_menu.jsp" %>
    <%--指定jsp静态包含标签--%>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">亲，当前购物车空空如也！<a href="${basePath}">快去添加商品吧</a></td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td><button bookId="${entry.value.id}" class="subBtn">-</button><span>${entry.value.count}</span><button bookId="${entry.value.id}" class="addBtn">+</button></td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItem&id=${entry.value.id}" id="delete">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <%--购物车非空输出下面的内容--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear" id="clearCart">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>
<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>