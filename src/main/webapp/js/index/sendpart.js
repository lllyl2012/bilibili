function changeGuichu(){
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var text1=xhr.responseText;
			var gui = JSON.parse(text1);
//			console.log("/"+gui[0].path);
//			console.log($(".guichuEveryImg")[0]);
//			$(".guichuEveryImg").attr("src","/mybili/"+gui[0].path);
			var guichus =$(".guichuEveryImg");
			var guichusDesc = $(".guichu-everyday-describe");
			var guichuProductCollnum = $(".guichuProductCollnum");
			var guichuProductShot = $(".guichuProductShot");
			for(var i=0;i<10;i++){
				$(guichus[i]).attr("src",gui[i].path);
				$(guichusDesc[i]).html(gui[i].describecontent);
				$(guichuProductCollnum[i]).html(gui[i].collnum);
				$(guichuProductShot[i]).html(gui[i].shot);
			}
		}
	};
	xhr.open("get","/bilibili/changeGuichu.do",true);
	xhr.send(null);
}