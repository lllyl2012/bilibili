/*历史*/
function lookhistory(){
	$("#users-history").removeClass("hide-history");
//	var xhr = getXhr();
//	xhr.onreadystatechange=function(){
//		if(xhr.readyState==4 && xhr.status==200){
//			var text1 = xhr.responseText;
//			console.log("text1:"+text1);
//			var json = JSON.parse(text1);
//			if(json[0].length>0){
//				$("#users-history").append("<p class='history-time'>今日</p>");
//				for(var i=0;i<json[0].length;i++){
//					
//				}
//			}
//			if(json[1].length>0){
//				$("#users-history").append("<p class='history-time'>昨日</p>");
//				for(var i=0;i<json[1].length;i++){
//					
//				}
//			}
//			if(json[2].length>0){
//				$("#users-history").append("<p class='history-time'>近一周</p>");
//				for(var i=0;i<json[2].length;i++){
//					
//				}
//			}
//			
//		}
//	};
//	xhr.open("get","/bilibili/myhistory.do",true);
//	xhr.send(null);
//	
}
function outhistory(){
	$("#users-history").addClass("hide-history");
}