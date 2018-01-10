function checkyz(){
		var yz = document.getElementById("yanzheng").value;
		var xhr = getXhr();
		console.log(yz);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var text1=xhr.responseText;
				console.log(text1);
				$("#theresultofyz").html(text1);
			}
		};
		xhr.open("get","/bilibili/checkyz.do?code="+yz,true);
		xhr.send(null);
	
}