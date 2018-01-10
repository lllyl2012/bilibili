<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" scope="request" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bilibili登录</title>
<link rel="stylesheet" href="${base}/css/common.css">
<link rel="stylesheet" href="${base}/css/nav.css">
<link rel="stylesheet" href="${base}/css/login/login.css">
</head>
<body>
<!-- 这个是导航-->
  <c:import url="/WEB-INF/inc/nav.jsp"/>
  <!-- 登录页面 -->
  <img id="login-img1" src="${base}/image/login/login1.png">
  <div id="login-content">
    <img id="login-img2" src="${base}/image/login/login2.png">
    <div id="login-userpwd">
        <div id="login-left"></div>${loginfail}
        <form action="${base}/loginvalidate.do" method="post">
            <input name="mobile" id="username" type="text" placeholder=" 你的手机号/邮箱">
            <input name="password" id="password" type="password" placeholder=" 密码">
            <img id="login-img3" src="${base}/getCode.do"><input onblur="checkyz()" id="yanzheng" type="text" placeholder="请输入验证码">
            <span id="theresultofyz"></span>
<%--             <img id="login-img3" src="${base}/image/login/login3.png"> --%>
            <div id="remembermediv">
                <div>
                    <input id="rememberme" type="checkbox"><label for="rememberme">记住我</label><span id="remembermespan1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;不是自己的电脑不要勾选此项</span>
                </div>
                <a href="#"><span id="remembermespan2">无法验证？</span></a>
                <a href="#"><span id="remembermespan3">忘记密码？</span></a>
            </div>
            <input id="login" type="submit">
            <a href="${base}/register.do"><div id="register">注册</div></a>
            <div id="login-useother">
                
                <a href="#"><div><img src="${base}/image/login/login4.png"><p>微博帐号登录</p></div></a>
                <a href="#"><div><img src="${base}/image/login/login5.png"><p>qq帐号登录</p></div></a>
            </div>
        </form>
    </div>
  </div>
  <!-- 这个是尾部 -->
  <!--   <c:import url="/WEB-INF/inc/footer.jsp"/> -->
  <c:import url="/WEB-INF/inc/footer.jsp"/>
    <script src="${base}/js/jquery-1.11.1.js"></script>
  <script src="${base}/js/index/ajax.js"></script>
   <script src="${base}/js/lookhistory.js"></script>
   <script src="${base}/js/login/login.js"></script>
</body>
</html>