<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" scope="request" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bilibili注册页面</title>
<link rel="stylesheet" href="${base}/css/common.css">
<link rel="stylesheet" href="${base}/css/nav.css">
<link rel="stylesheet" href="${base}/css/register/register.css">
</head>
<body>
  <!-- 这个是导航-->
  <c:import url="/WEB-INF/inc/nav.jsp"/>
  <!-- 注册页面 -->
  <img id="register-img1" src="${base}/image/register/register1.png">
  <form action="${base}/save.do" method = "post">
    <input onblur="checkname()" id="username" name="username" type="text" placeholder="昵称（例：bilibili）"><span id="namecheckrs" class="checkPart"></span>
    <input onblur="checkpwd()" id="password" name="password" type="password" placeholder="密码（6-12位之间）"><span id="pwdcheckrs" class="checkPart"></span>
    <div id="telephone">
      <select name = "country">
        <option value="China">中国</option>
        <option value="America">美国</option>
        <option value="England">英国</option>
      </select> 
      <input id="mobile" name="mobile"  onchange="checkmobile(this)"  type="text" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" placeholder="常用手机号码">
      <span id="mobilecheckrs" class="checkPart">${registerError}</span>
    </div>
    <div id="read">
      <input onchange="change(this)" id="checkboxagree" type="checkbox"> 我已同意<a href="#">《哔哩哔哩弹幕网用户使用协议》</a>和<a
        href="#">《哔哩哔哩弹幕网账号中心规范》</a>
    </div>
    <p id="nosubmit" class="">注册</p>
    <input id="submit" class="submit-hide" value="注册" type="submit">
    <a id="have" href="${base}/login.do">已有帐号，直接登录></a>
  </form>


  <!-- 这个是尾部 -->
  <!--   <c:import url="/WEB-INF/inc/footer.jsp"/> -->
  <c:import url="/WEB-INF/inc/footer.jsp"></c:import>
  <script src="${base}/js/jquery-1.11.1.js"></script>
  <script src="${base}/js/index/ajax.js"></script>
  <script src="${base}/js/register/register.js"></script>
   <script src="${base}/js/lookhistory.js"></script>
</body>
</html>