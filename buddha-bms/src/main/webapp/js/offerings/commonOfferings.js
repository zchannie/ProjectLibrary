//获取表单数据
function getParameter() {
	var offeringsId = $("#offeringsId").val();
	var offeringsName = $("#offeringsName").val();
	var content = $("#content").val();
	var imgUrl = $("#picture").val();
	var meritCoin = $("#meritCoin").val();
	var type = $("#type").val();

	if (offeringsName == "") {
		alert("请输入供品名称");
		return false;
	}

	if (type == "") {
		alert("请选择供品分类");
		return false;
	}

	var parameter = {
		offeringsId : offeringsId,
		offeringsName : offeringsName,
		imgUrl : imgUrl,
		meritCoin : meritCoin,
		type : type,
		content:content
	};
	return parameter;

}

$(function() {

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