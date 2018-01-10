//会员管理分页功能
function toThisPage(title){
	var pathName = window.document.location.pathname;
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	for(var i=0;i<7;i++){
		for(var a=0;a<6;a++){
			$("#user"+i).children()[a].innerHTML="";
		}
	}
	$.ajax({
		"type":"get",
		"url":"thisPage.do",
		"dataType":"json",
		"data":"page="+title,
		"success":function(json){
			for(var i=1;i<=json.obj.pageAll;i++){
				$("#fenye"+i).removeClass("fenye-light");
			}
			$("#fenye"+json.obj.page).addClass("fenye-light");
			$("#afterPage").attr("title",json.obj.afterPage);
			$("#beforePage").attr("title",json.obj.beforePage);
			for(var i=0;i<json.obj.list.length;i++){
				$("#user"+i).children()[0].innerHTML=json.obj.list[i].username;
				$("#user"+i).children()[1].innerHTML = json.obj.list[i].mobile;
				$("#user"+i).children()[2].innerHTML = json.obj.list[i].password;
				$("#user"+i).children()[3].innerHTML = json.obj.list[i].lv;
				$("#user"+i).children()[4].innerHTML = json.obj.list[i].rolename;
				$("#user"+i).children()[5].innerHTML = '<p class="remove-title">删除</p>';
				$("#user"+i).children()[5].setAttribute("href",projectName+'/user/removeUser.do?mobile='+json.obj.list[i].mobile);
			}
		}
	});
}
//删除角色