//获取表单数据
function getParameter() {
	var themeId = $("#themeId").val();
	var themeName = $("#themeName").val();
	var imgUrl = $("#picture").val();
	var content = $("#themeContent").val();//主题内容
	
	var themeSelect = $("#themeSelect").combobox("getValue");

	var htmlContent = UE.getEditor('myEditor').getContent();//主题描述，用于生成html页面
	//原html链接，编辑更新用
	var htmlUrl=$("#content").html();
	
	if (themeName == "") {
		alert("请输入主题名称");
		return false;
	}
	
	var parameter = {
			themeId : themeId,
			themeName : themeName,
			themeImg : imgUrl,
			themeContent: content,
			type:themeSelect,
			htmlUrl:htmlContent,
			param:htmlUrl
	};
	return parameter;

}

$(function() {

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