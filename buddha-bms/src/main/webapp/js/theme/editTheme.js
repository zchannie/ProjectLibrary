
$(function() {
	
	
	var picture = $("#picture").val();
	
	if(picture != ""){
		$("#imgPreview").attr('src', domain  + picture);
	}
	
	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('editTheme', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
	
	
});