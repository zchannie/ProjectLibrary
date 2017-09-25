//获取表单数据
function getParameter() {
	var newsid = $("#newsid").val();
	var newsTitle = $("#newsTitle").val();
	var picture = $("#picture").val();
	var newsIntroduction = $("#newsIntroduction").val();
	var categoryId = $("#cateSelect").combobox('getValue');
	
	var newsContent = UE.getEditor('myEditor').getContent();//主题描述，用于生成html页面
	var htmlUrl=$("#content").html();//编辑页面用，原htmlurl链接

	if (newsTitle == "") {
		alert("请输入新闻标题");
		return false;
	}

	if (categoryId == "") {
		alert("请选择新闻分类");
		return false;
	}
	

	var parameter = {
		newsid : newsid,
		newsTitle : newsTitle,
		newsIntroduction : newsIntroduction,
		picture : picture,
		type : categoryId,
		htmlUrl : newsContent,
		param:htmlUrl
	};
	return parameter;

}

$(function() {

	// 实例化编辑器
	$("#categoryId").combobox({
		url : "../pub/category/100006",
		valueField : 'categoryId',
		textField : 'categoryName'
	});

	$("#btnUpload").click(
			function() {
				// $("#imgWait").show();
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file").files[0]);
				$.ajax({
					url : "upload/pictrue",
					type : "POST",
					data : formData,
					/**
					 * 必须false才会自动加上正确的Content-Type
					 */
					contentType : false,
					/**
					 * 必须false才会避开jQuery对 formdata 的默认处理 XMLHttpRequest会对
					 * formdata 进行正确的处理
					 */
					processData : false,
					success : function(data) {
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview").attr("src",
								domain  + data.object);
						$("#picture").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			});

});