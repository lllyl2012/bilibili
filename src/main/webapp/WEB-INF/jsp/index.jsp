<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="base" scope="request" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base}/css/common.css">
<link rel="stylesheet" href="${base}/css/footer.css">
<link rel="stylesheet" href="${base}/css/suspend.css">
<link rel="stylesheet" href="${base}/css/nav.css">
<link rel="stylesheet" href="${base}/css/header.css">
<link rel="stylesheet" href="${base}/css/content.css">
<link rel="stylesheet" href="${base}/css/hot/hot-commend.css">
<link rel="stylesheet" href="${base}/css/hot/animate.css">
<link rel="stylesheet" href="${base}/css/hot/history.css">
<title>bilibili</title>
</head>
<body>

  <a name="tophead"></a>
  <c:import url="/WEB-INF/inc/nav.jsp"/>
  <!-- 这个是头部 -->
  <div class="header">
    <a href="#"><div id="allrank">
        <img src="${base}/image/header1.png">排行榜
      </div></a>
    <form action="" method="post" id="form">
      <input type="text" name="search"> <a href="#"><img
        src="${base}/image/header2.png"></a>
        
    </form>
  </div>
  <!-- 这个是内容 -->
  <div class="content">
    <!-- 内容导航  -->
    <div id="content-nav">
      <ul>
        <li><a href="#"><img src="${base}/image/content-nav.png">首页</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">动画</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">番剧</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">国创</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">音乐</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">舞蹈</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">游戏</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">科技</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">生活</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">鬼畜</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">时尚</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">广告</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">娱乐</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">影视</a></li>
        <li><a href="#"><img src="${base}/image/content-nav.png">放映厅</a></li>
      </ul>
      <ol>
      <li><a href="#"><img src="${base}/image/content-nav2.png">专栏</a></li>
      <li><a href="#"><img src="${base}/image/content-nav3.png">广场</a></li>
      <li><a href="#"><img src="${base}/image/content-nav4.png">直播</a></li>
      <li><a href="#"><img src="${base}/image/content-nav5.png">小黑屋</a></li>
      </ol>
      <img id="content-nav1" src="${base}/image/content-nav1.gif">
    </div>
    <!-- 热门推荐 -->
    <div id="hot-commend">
        <div id="tiaoye" onmouseover="displaytiaoyemore()" onmouseout="undisplaytiaoyemore()">
            <a href="#"><div value="1" onmouseover="stoponit2(this)" onmouseout="startagain2(this)" id="lunbo-div1" class=""><img  class="lunbo-img" src="${base}/${hot0}"></div></a>
            <a href="#"><div value="2" onmouseover="stoponit2(this)" onmouseout="startagain2(this)" id="lunbo-div2" class="tiaoye-on"><img class="lunbo-img" src="${base}/${hot1}"></div></a>
            <a href="#"><div value="3" onmouseover="stoponit2(this)" onmouseout="startagain2(this)" id="lunbo-div3" class="tiaoye-on"><img class="lunbo-img" src="${base}/${hot2}"></div></a>
            <a href="#"><div value="4" onmouseover="stoponit2(this)" onmouseout="startagain2(this)" id="lunbo-div4" class="tiaoye-on"><img class="lunbo-img" src="${base}/${hot3}"></div></a>
            <a href="#"><div value="5" onmouseover="stoponit2(this)" onmouseout="startagain2(this)" id="lunbo-div5" class="tiaoye-on"><img class="lunbo-img" src="${base}/${hot4}"></div></a>
            <ul>
                <li id="lunbo-li5" value="5" onmouseover="stoponit(this)" onmouseout="startagain(this)" class=""></li>
                <li id="lunbo-li4" value="4" onmouseover="stoponit(this)" onmouseout="startagain(this)" class=""></li>
                <li id="lunbo-li3" value="3" onmouseover="stoponit(this)" onmouseout="startagain(this)" class=""></li>
                <li id="lunbo-li2" value="2" onmouseover="stoponit(this)" onmouseout="startagain(this)" class=""></li>
                <li id="lunbo-li1" value="1" onmouseover="stoponit(this)" onmouseout="startagain(this)" class="tiaoyelight"></li>
            </ul>
            <a href="#"><p id="tiaoye-more" class="tiaoye-more-nosee">更多></p></a>
        </div>
         <c:forEach var="hotcommend" items="${hotrights}" varStatus="stat">      
            <div onmouseover="hidedescribe(this)" onmouseout="showdescribe(this)" class="hot-commend-right">
                <img class="hot-commend-right-img"  src="${base}/${hotcommend.path}">
                <div  class="hot-commend-hide-describe hot-commend-hideit">
                    <div class="hot-commend-describe">${hotcommend.describecontent}</div>
                    <div class="hot-commend-up">up主:${hotcommend.user}</div>
                    <div class="hot-commend-collnum">收藏量:${productname.collnum}</div>
                    <img onmouseover="showcollit(this)" onmouseout="hidecollit(this)" src="${base}/image/hot/hotcommed.png" class="hot-commend-collit"></img>
                    <div  class="hot-commend-wantcoll hot-commend-wantcollhide">收藏它</div>
                </div>
            </div>
       </c:forEach>
    </div>
        
    
  </div>
  <!-- 历史 -->
  <div id="users-history" class="hide-history" >
<!--   	<p class="history-time">今日</p> -->
<!-- 		<p class="history-time">昨日</p> -->
		
		<c:if test="${yesterdayHistory.size()>0}">
			<p class="history-time">近一周</p>
			<ul>
   		<c:forEach var="history" items="${yesterdayHistory}" varStatus="stat">
        <li class="users-history-li">${history}</li>
   		</c:forEach>
			</ul>
		</c:if>
       
       <a href="#"><p id="lookmorehistory">查看更多></p></a>
  </div>
  <!-- 番剧 -->
  <div class="animate">
    <div class="dayshow">
        <div id="dayshow-head">
            <img src="${base}/image/hot/hot3.png">
            <a href="#"><span>番剧</span></a>
            <ul onclick="animatetoday(event)">
                <li id="animateto1" class="dayshow-head-li dayshow-head-li-on">最新</li>
               <li id="animateto2" class="dayshow-head-li">一</li>
                <li id="animateto3" class="dayshow-head-li">二</li>
                <li id="animateto4" class="dayshow-head-li">三</li>
                <li id="animateto5" class="dayshow-head-li">四</li>
                <li id="animateto6" class="dayshow-head-li">五</li>
                <li id="animateto7" class="dayshow-head-li">六</li>
                <li id="animateto8" class="dayshow-head-li">日</li>
            </ul>
            <a href="#"><div id="dayshow-head-time">新番时间表 ></div></a>
            <div id="dayshow-head-underline"></div>
        </div>
        <div id="animate-everyday">
            <c:forEach var="animateNew" items="${aniamteNews}" varStatus="stat">
                <div class="animate-everyday-animateName">
                    <img class="animate-everyday-animateName-img" src="${base}/${animateNew.path}">
                    <p class="animate-everyday-animateName-title">${animateNew.productname}</p>
                    <p class="animate-everyday-animateName-to">更新至</p>
                    <p class="animate-everyday-animateName-index">${animateNew.indexnum}话</p>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="animate-rank">
        <span>排行</span>
        <ul id="animate-rank-ul">
             <c:forEach var="animateaa" items="${animaterank}" varStatus="stat"> 
                <li><p class="animate-rank-li-no1to3">${stat.index+1}</p>
                <a href="#"><p class="animate-rank-li-name">${animateaa.productname}
                <span class="animate-rank-li-index">更新至第${animateaa.indexnum}话</span></p></a></li> 
            </c:forEach> 
            <c:forEach var="animatebb" items="${animaterank2}" varStatus="stat"> 
                <li><p class="animate-rank-li-no">${stat.index+4}</p>
                <a href="#"><p class="animate-rank-li-name">${animatebb.productname}
                <span class="animate-rank-li-index">更新至第${animatebb.indexnum}话</span></p></a></li> 
            </c:forEach> 
        </ul>
        <a href="#"><div class="animate-rank-readmore">查看更多></div></a>
    </div>
  </div>
  <!--鬼畜 -->
  <div class="guichu">
    <div class="guichu-dayshow">
        <div id="guichu-head">
            <img id="guichu-head-img1" src="${base}/image/hot/hot4.png">
            <a href="#"><p id="guichu-head-guichu">鬼畜</p></a>
            <ul>
                <a href="#"><li>有新动态</li></a>
                <a href="#"><li>最新投稿</li></a>
            </ul>
            <a href="#"><img id="guichu-head-img2" src="${base}/image/hot/guichu/guichu1.png"><p id="guichu-head-luxun">鲁迅：这话我还真说过</p></a>
            <p onclick="changeGuichu()" id="guichu-head-change">换一批</p>
            <a href="#"><p id="guichu-head-more">更多 ></p></a>
        </div>
        <div id="guichu-everyday">
              <c:forEach var="guichuNew" items="${guichuNews}" varStatus="stat">
                 <div  class="guichu-everyday-guichuName">
                     <img class="guichuEveryImg" class="guichu-everyday-guichuimg" src="${base}/${guichuNew.path}">
                     <p  class="guichu-everyday-describe">${guichuNew.describecontent}</p>
                     <p id="aaa" class="guichu-everyday-collandshot">
                     <img class="guichu-everyday-collnumimg" src="${base}/image/collnum.png"><span class="guichuProductCollnum">${guichuNew.collnum}</span> 
                        <img class="guichu-everyday-shotimg" src="${base}/image/shot.png"><span class="guichuProductShot">${guichuNew.shot}</span>
                     </p> 
                 </div>
             </c:forEach>
        </div>
    </div>
    <div class="guichu-rank">
        <span>排行</span>
        <ul>
             <c:forEach var="guichuaa" items="${guichurank}" varStatus="stat"> 
                <li><p class="animate-rank-li-no1to3">${stat.index+1}</p>
                <a href="#"><p class="animate-rank-li-name">${guichuaa.describecontent}
                </p></a></li> 
             </c:forEach> 
             <c:forEach var="guichubb" items="${guichurank2}" varStatus="stat"> 
                <li><p class="animate-rank-li-no">${stat.index+4}</p>
                <a href="#"><p class="animate-rank-li-name">${guichubb.describecontent}
                </p></a></li> 
            </c:forEach> 
        </ul>
        <a href="#"><div class="animate-rank-readmore">查看更多></div></a>
    </div>
  </div>
  <!-- 右侧悬浮栏 -->
  <div id="suspend">
    <ul>
     <a href="#"> <li>直播</li></a>
     <a href="#"> <li>动画</li></a>
     <a href="#"><li>番剧</li></a>
     <a href="#"> <li>国创</li></a>
     <a href="#"><li>音乐</li></a>
     <a href="#"> <li>舞蹈</li></a>
     <a href="#"> <li>鬼畜</li></a>
     <a href="#"> <li>广告</li></a>
     <a href="#"> <li>娱乐</li></a>
     <a href="#"> <li>电影</li></a>
     
    </ul>
    <a href="#tophead"><img id="suspendimg" src="${base}/image/suspend.png"></a>
  </div>
  <!-- 这个是尾部 -->
  <!--   <c:import url="/WEB-INF/inc/footer.jsp"/> -->
   <c:import url="/WEB-INF/inc/footer.jsp"/>
  
  <script src="${base}/js/jquery-1.11.1.js"></script>
  <script src="${base}/js/index/ajax.js"></script>
  <script src="${base}/js/index/tiaoye.js"></script>
  <script src="${base}/js/index/sendpart.js"></script>
  <script src="${base}/js/lookhistory.js"></script>
</body>
</html>