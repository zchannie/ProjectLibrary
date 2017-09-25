//获取url中的参数
function getUrlParam(name) {
 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
 var r = window.location.search.substr(1).match(reg); //匹配目标参数
 if (r != null) return unescape(r[2]); return null; //返回参数值
}

//添加标签页
function AddLabelPage(title, url) {
	var jq = top.jQuery;

	if (jq("#tabs").tabs('exists', title)) {
		jq("#tabs").tabs('select', title);
	} else {
		var content = "<iframe style='border:0;width:100%;height:99.2%;margin: 0 auto;' frameborder='0' src='"
				+ url + "'></iframe>";
		jq("#tabs").tabs('add', {
			title : title,
			content : content,
			closable : true
		});
	}
}