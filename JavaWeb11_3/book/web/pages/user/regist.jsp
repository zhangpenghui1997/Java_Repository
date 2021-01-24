<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        /*// 页面加载完成之后
        $(function(){

            // 给注册按钮添加事件
            $("#sub_btn").click(function(){

                // 获取用户名
                var usernameValue = $("#username").val();
                // 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
                var usernameReg = /^\w{5,15}$/;
                // 验证用户信息
                if (!usernameReg.test(usernameValue)) {
                    // 提示用户
                    alert("用户名不合法！");
                    return false;
                }

                // 获取密码
                var passwordValue = $("#password").val();
                // 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
                var passwordReg = /^\w{5,15}$/;
                // 验证用户信息
                if (!passwordReg.test(passwordValue)) {
                    // 提示用户
                    alert("密码不合法！");
                    return false;
                }

                // 获取确认密码
                var repwdValue = $("#repwd").val();
                // 验证确认密码和密码一致
                if (passwordValue != repwdValue) {
                    // 提示用户
                    alert("确认密码和密码不一致！");
                    return false;
                }

                // 获取用户名
                var emailValue = $("#email").val();
                // 验证邮件输入是否合法。
                var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

                if (!emailReg.test(emailValue)) {
                    // 提示用户
                    alert("邮件输入不合法！");
                    return false;
                }


                // 获取验证码信息
                var codeValue = $("#code").val();
                // 验证验证码不为空！
                if (codeValue == "") {
                    alert("验证码不能为空！");
                }

                return true;
            });

        });*/


        //@author zph
        //date  2020-11-16

        $(function () {

            //给验证码图片绑定单击事件
            $("#codeImg").click(function () {
                // alert("${basePath}"); //            --->  http://localhost:8081/book/
                this.src = "${basePath}kaptcha.jpg?id=" + new Date().getTime();
            });

            $("#sub_btn").click(function () {
                var username = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(username)) {
                    //alert("用户名不合法");
                    $(".errorMsg").text("用户名不合法");
                    return false;
                }

                var password = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    //alert("密码不合法");
                    $(".errorMsg").text("密码不合法");
                    return false;
                }

                var repwd = $("#repwd").val();
                if (repwd != password) {
                    $(".errorMsg").text("两次输入的密码不一致！");
                    return false;
                }

                var email = $("#email").val();
                var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!emailPatt.test(email)) {
                    //alert("邮箱格式不合法");
                    $(".errorMsg").text("邮箱格式不合法");
                    return false;
                }


                var code = $("#code").val();
                code = $.trim(code);
                if (code == "" || code == null) {
                    //alert("验证码不能为空");
                    $(".errorMsg").text("验证码不能为空");
                    return false;
                }
                return true;
            });

            $("#username").blur(function () {
                         var username=this.value;
                         if(username!=null&&username!=""){
                             $.getJSON("http://localhost:8081/book/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
                                 //console.log(data);
                                  if(data.message===true){
                                     //用户名已存在
                                     $(".errorMsg").text("用户名已存在");
                                 }else{
                                      $(".errorMsg").text("");
                                  }
                             });
                         }else{
                             $(".errorMsg").text("用户名不能为空");
                         }

            });

        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <!--工程中一般写到工程路径,永远固定相对路径的跳转结果-->

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif"><!--去掉base标签后要修改-->
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <a href="pages/user/login.jsp" style="color: green">去登录</a>
                    <span style="font-size: 18px" class="errorMsg">${requestScope.message}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
                               tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
                               tabindex="1" name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width:80px;" id="code" name="code"/>
                        <img alt="" src="kaptcha.jpg" style="height:39px;float: right; margin-right: 30px"
                             id="codeImg"/>
                        <br/>
                        <div height="30px"></div>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>