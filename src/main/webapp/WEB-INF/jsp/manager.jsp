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
            <a href="${base}/user/youown.do"><li class="list-li">基本信息</li></a>
            <li class="list-li list-li-on">会员管理</li>
            <a href="${base}/user/logout.do"><li class="list-li">退出</li></a>
        </ul>
        <div class="content">
            <div id="title"><p class="title-content">用户管理</p></div>
            <ul class="huiyuan-content">
                <li class="content-li">
                    <p class="name-title" style="font-size:17px">昵称</p>
                    <p class="mobile-title" style="font-size:17px">电话</p>
                    <p class="password-title" style="font-size:17px">密码</p>
                    <p class="lv-title" style="font-size:17px">等级</p>
                    <p class="role-title" style="font-size:17px">角色</p>
                    <p class="remove-title" style="font-size:17px">删除角色</p>
                </li>
                <c:forEach var="user" items="${users}" varStatus="stat">
                  <li id="user${stat.index}" class="content-li">
                      <p class="name-title">${user.username}</p>
                      <p class="mobile-title">${user.mobile}</p>
                      <p class="password-title">${user.password}</p>
                      <p class="lv-title">${user.lv}</p>
                      <p class="role-title">${user.rolename}</p>
                      <a onclick="return confirm()" class="removeUser button" href="${base}/user/removeUser.do?mobile=${user.mobile}" ><p class="remove-title">删除</p></a>
<%--                       <a onclick="return confirm('要删除${user.username}吗？')" class="removeUser" href="${base}/user/removeUser.do?mobile=${user.mobile}"><p class="remove-title">删除</p></a> --%>
                  </li>
                </c:forEach>
               
            </ul>
             <ul id="fenye">
                <span class="button" id="beforePage" onclick="toThisPage(this.title)" title="${beforePage}"><li>上一页</li></span>
                      <c:forEach var="i" begin="1" end="${pageAll}" step="1">
                        <span class="button" onclick="toThisPage(this.title)" title="${i}" ><li id="fenye${i}" <c:if test="${i eq page}"> class="fenye-light"</c:if> >${i}</li></span>
                      </c:forEach>
                <span class="button" id="afterPage" onclick="toThisPage(this.title)" title="${afterPage}"><li>下一页</li></span>
            </ul>
<!--             <ul id="fenye"> -->
<%--                 <a href="${base}/user/manager.do?page=${beforePage}"><li>上一页</li></a> --%>
<%--                       <c:forEach var="i" begin="1" end="${pageAll}" step="1"> --%>
<%--                         <a href="${base}/user/manager.do?page=${i}" ><li <c:if test="${i eq page}"> class="fenye-light"</c:if> >${i}</li></a> --%>
<%--                       </c:forEach> --%>
<%--                 <a href="${base}/user/manager.do?page=${afterPage}"><li>下一页</li></a> --%>
<!--             </ul> -->
        </div>
    </div>
    
<!-- 页脚 -->
<c:import url="/WEB-INF/inc/footer.jsp"></c:import>
<script src="${base}/js/jquery-1.11.1.js"></script>
<script src="${base}/js/manager/manager.js" type="text/javascript"></script>

</body>
</html>