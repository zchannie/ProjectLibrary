$(function(){
	//左侧添加图片
	$(".accordion-header").find(".panel-title").prepend('<img src="images/index1_54.gif" class="am"  width="15" height="11">&nbsp;&nbsp;');
	
	//遍历菜单 添加单击事件
	$(".menus").each(function(index,dom){
		//获取标题
		var title = $(dom).attr('title');
		//获取url地址
		var url = $(dom).attr('url');
		$(dom).click(function(){
			//根据title获取选项卡
			var tab = $("#tabs").tabs("getTab",title);
			//如果tab为空则 表明该选项卡 还未曾 添加过
			if(tab == null){
				//添加新选项卡
				jQuery("#tabs").tabs('add',{
					title:title,  
				    content:"<iframe style='border:0;width:100%;height:99.2%;margin: 0 auto;' frameborder='0' src='"+url+"'></iframe>",  
				    closable:true 
				});
			}else{
				//如果tab有值则表明 该选项卡已经 添加过了，直接选中即可
				$("#tabs").tabs("select",title);
			}		
		});
	});
});