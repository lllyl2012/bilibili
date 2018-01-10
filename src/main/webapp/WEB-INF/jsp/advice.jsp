<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <c:set var="base" scope="request" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
<link rel="stylesheet" href="${base}/css/common.css"/>
<link rel="stylesheet" href="${base}/css/nav.css">
<link rel="stylesheet" href="${base}/css/footer.css">
<link rel="stylesheet" href="${base}/css/manager/manager.css">
</head>
<body>
     <c:import url="/WEB-INF/inc/nav.jsp"></c:import> 

  <!-- 正文 -->
  <img id="manager-head" src="${base}/image/manager/manager-head.png">
   <div id="manager">
        <p class="selfcenter">个人中心</p>
        <ul class="list">
            <li class="list-li">基本信息</li>
            <c:if test="${mobile eq '111222'}">
                <a href="${base}/user/manager.do?page=1"><li class="list-li">会员管理</li></a>
            </c:if>
            <a href="${base}/user/advice.do"><li class="list-li list-li-on">提交意见</li></a>
            <a href="${base}/user/logout.do"><li class="list-li">退出</li></a>
        </ul>
        <div class="content">
            <form action="${base}/user/mail.do" method="post">
                <span class="sign">您的建议：</span><textarea name="advice" id="sign" cols="50" rows="40"></textarea>
                <input id="suggest-submit" type="submit" value="发送">
            </form>
        </div>
  </div>
  
  <!-- 页脚 -->
<c:import url="/WEB-INF/inc/footer.jsp"></c:import>


</body>
</html>