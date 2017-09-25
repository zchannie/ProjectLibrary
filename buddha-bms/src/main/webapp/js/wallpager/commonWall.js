//获取表单数据
function getParameter() {
	var id = $("#id").val();
	var imgUrl = $("#picture").val();
	var thumbnail=imgUrl.replace(".jpg",'_thum.jpg');
	var themeSelect = $("#themeSelect").combobox("getValue");
	var parameter = {
			id : id,
			picture : imgUrl,
			thumbnail:thumbnail,
			pid:themeSelect
	};
	return parameter;

}

$(function() {

	// 实例化编辑器
	

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