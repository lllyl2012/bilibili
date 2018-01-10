<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <!-- 这个是导航-->
  <nav>
    <ul>
      <li><a id="nav-ul-first" href="${base}/index.do">主站</a></li>
      <li><a href="#">画友</a></li>
      <li><a href="#">游戏中心</a></li>
      <li><a href="#">直播</a></li>
      <li><a href="#">会员购</a></li>
      <li><a href="#">周边</a></li>
      <li><a href="#">移动端</a></li>
    </ul>

    <div>
      <a href="${base}/user/youown.do"><img src="${base}/image/nav1.png"></a>
    </div>
    <a onmouseover="lookhistory()" onmouseout="outhistory()" id="history" href="#">历史</a> <a id="contribute" href="#">投稿</a>
    
  </nav>