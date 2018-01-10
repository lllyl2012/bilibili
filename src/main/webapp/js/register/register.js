function change(t){
	var flag = t.checked;
	if(flag){
		$("#nosubmit").addClass("submit-hide");
		$("#submit").removeClass();
	}else{
		$("#nosubmit").removeClass();
		$("#submit").addClass("submit-hide");
	}
}
function checkname(){
//	console.log("this:"+$("#username"));
//	var name = $("#username").attr("value");
//	console.log("name:"+name);
	
	var name = document.getElementById("username").value;
//	console.log("name:"+name);
//	if(name==null){
//		$("#namecheckrs").html("昵称不能为空");
//	}
//	if(name.length>20){
//		$("#namecheckrs").html("昵称不要超过20个字");
//	}
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var text = xhr.responseText;
//			console.log(text);
//			if(text.length==1){
//				$("#namecheckrs").html("该昵称已经有人使用");
//			}else{
//				$("#namecheckrs").html("");
//			}
			$("#namecheckrs").html(text);
		}
	};
	xhr.open("get","/bilibili/checkname.do?name="+name,true);
	xhr.send(null);
		
}
function checkpwd(){
	var pwd = document.getElementById("password").value;
	$("#pwdcheckrs").html("");
	if(pwd.length<6 || pwd.length>12){
		$("#pwdcheckrs").html("密码长度请在6到12位之间");
	}
}
function checkmobile(){
	var mobile = document.getElementById("mobile").value;
	console.log("mobile:"+mobile);
	if(mobile==""){
		$("#mobilecheckrs").html("请填写手机号码，用于密码找回");
		return;
	}
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var text = xhr.responseText;
			console.log("text:"+text.length);
				$("#mobilecheckrs").html(text);
		}
	};
	xhr.open("get","/bilibili/checkmobile.do?mobile="+mobile,true);
	xhr.send(null);
}
