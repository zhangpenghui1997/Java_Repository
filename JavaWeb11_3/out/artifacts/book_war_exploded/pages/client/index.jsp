<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $(".btnClass").click(function () {
                var pnValue = $("input#pn_input").val();
                if (pnValue == null || pnValue == "") {
                    alert("页码值不能为空！");
                    return;
                } else if (pnValue < 0 || pnValue >${requestScope.page.pageTotal}) {
                    alert("页码值非法！");
                    return;
                }
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pnValue;
            });

            $("#submitBtn").click(function () {
                var minValue = $("#min").val();
                var maxValue = $("#max").val();
                if (minValue == "" || minValue == null || minValue < 0) {
                    alert("价格最小值非法");
                    return false;
                } else if (maxValue == "" || maxValue == null) {
                    alert("价格最大值非法");
                    return false;
                }
                return true;
            });

            $("#searchAll").click(function () {
                //alert("${pageScope.basePath}client/bookServlet?action=page&pageNo=1");
                location.href = "${pageScope.basePath}client/bookServlet?action=page&pageNo=1";
            });

            //给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
                var bookId = $(this).attr("bookId");
                //location.href="${pageScope.basePath}cartServlet?action=addItem&id="+bookId;
                $.getJSON("http://localhost:8081/book/cartServlet", "action=ajaxAddItem&id=" + bookId, function (data) {
                    $("#totalCountSpan").text("您的购物车中有" + data.totalCount + "件商品");
                    $("#lastNameSpan").text(data.lastName);
                });
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <%--用户未登录，显示以下内容--%>
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <%--用户已经登录，显示用户信息--%>
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                <input type="hidden" name="pageNo" value="${requestScope.page.pageNo}">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" id="submitBtn" value="查询"/>
                <button><a style="text-decoration: none"
                           href="${requestScope.basePath}client/bookServlet?action=page&pageNo=1">显示所有书籍</a></button>

            </form>

        </div>
        <div style="text-align: center">
            <c:if test="${not empty sessionScope.cart.items}">
                <%--购物车不为空的输出--%>
                <span id="totalCountSpan"></span><%--${sessionScope.cart.totalCount}--%>

                <div>
                    您刚刚将<span style="color: red" id="lastNameSpan"></span>加入到了购物车中
                        <%--${sessionScope.lastName}--%>
                </div>
            </c:if>
            <%--购物车为空的输出--%>

            <c:if test="${empty sessionScope.cart.items}">
                <span id="lastNameSpan">您的购物车中没有商品</span>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="item">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${item.img_path}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${item.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${item.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${item.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${item.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${item.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${item.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%@include file="/pages/common/page_nav.jsp" %>


    <%@include file="/pages/common/footer.jsp" %>
</body>
</html>