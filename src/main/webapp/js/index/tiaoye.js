/*轮播*/
var time = null;
var i = 1;
$(function(){
	time = setInterval(changeHide,2000);
	$(".guichu-everyday-guichuName").mouseenter(function(){
		 var  a =$(this).children(".guichu-everyday-collandshot")[0];
		 $(a).slideUp(100);
	});
	$(".guichu-everyday-guichuName").mouseleave(function(){
		 var  a =$(this).children(".guichu-everyday-collandshot")[0];
		 $(a).slideDown(100);
	});
});


function changeHide(a){
	i++;
	if(i>5){
		i=1;
	}
	for(var a=1;a<=5;a++){
		$("#lunbo-div"+a).removeClass();
		$("#lunbo-li"+a).removeClass();
		if(a==i){
			$("#lunbo-li"+a).addClass("tiaoyelight");
			continue;
		}
		$("#lunbo-div"+a).addClass("tiaoye-on");
	}
}
function stoponit(t){
	clearInterval(time);
	for(var a=0;a<=5;a++){
		$("#lunbo-li"+a).removeClass();
		$("#lunbo-div"+a).addClass("tiaoye-on");
	}
	t.className = "tiaoyelight";
	var k = t.value;
	$("#lunbo-div"+k).removeClass();
}
function startagain(t){
	i=t.value;
	clearInterval(time);
	time=setInterval(changeHide,2000);

}
function stoponit2(t){
	clearInterval(time);
	for(var a=0;a<=5;a++){
		$("#lunbo-li"+a).removeClass();
		$("#lunbo-div"+a).addClass("tiaoye-on");
	}
	$("#lunbo-div"+i).removeClass();
	$("#lunbo-li"+i).addClass("tiaoyelight");
}
function startagain2(t){
	clearInterval(time);
	time=setInterval(changeHide,2000);

}
function displaytiaoyemore(){
	$("#tiaoye-more").removeClass();
}
function undisplaytiaoyemore(){
	$("#tiaoye-more").addClass("tiaoye-more-nosee");
}
/*热点右侧隐藏*/
function hidedescribe(t){
	
	$(t).children("div").removeClass("hot-commend-hideit");
}
function showdescribe(t){
	$(t).children("div").addClass("hot-commend-hideit");
}
function hidecollit(t){
	$(t).next().addClass("hot-commend-wantcollhide");
}
function showcollit(t){
	$(t).next().removeClass("hot-commend-wantcollhide");
}
/*分页*/
function animatetoday(e){
	var target = e.target;
	if(target.nodeName=="LI"){
		for(var i=1;i<=8;i++){
			$("#animateto"+i).removeClass();
			$("#animateto"+i).addClass("dayshow-head-li");
		}
		target.className = "dayshow-head-li dayshow-head-li-on";
	
		var xhr = getXhr();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var text1=xhr.responseText;
				var ani = JSON.parse(text1);
				console.log(ani[0]);
				console.log(ani.length);
				var animateeverydayanimateNameimg = $(".animate-everyday-animateName-img");
				var animateeverydayanimateNametitle = $(".animate-everyday-animateName-title");
				var animateeverydayanimateNameindex = $(".animate-everyday-animateName-index");
				var animateeverydayanimateName =$(".animate-everyday-animateName");
				for(var i=0;i<ani.length;i++){
					$(animateeverydayanimateNameimg[i]).attr("src",ani[i].path);
					$(animateeverydayanimateNametitle[i]).html(ani[i].productname);
					$(animateeverydayanimateNameindex[i]).html(ani[i].indexnum+"话");
					$(animateeverydayanimateName[i]).removeClass("hide-history");
				}
				
				for(var i=ani.length;i<16;i++){
					$(animateeverydayanimateName[i]).addClass("hide-history");
				}
			}
		};
		xhr.open("get","/bilibili/thisDayAnimate.do?day="+target.id,true);
		xhr.send(null);
	
	}
	
	
	
}



/*鬼畜收藏和点击动画*/
//function hideCollShot(t){
//	var  a =$(t).children(".guichu-everyday-collandshot")[0];
//	$(a).slideUp(100);
//}
//function showCollShot(t){
//	var  a =$(t).children(".guichu-everyday-collandshot")[0];
//	$(a).slideDown(100);
//}

