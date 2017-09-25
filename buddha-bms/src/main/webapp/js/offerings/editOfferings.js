
$(function() {
	
	
	var picture = $("#picture").val();
	
	if(picture != ""){
		$("#imgPreview").attr('src', domain  + picture);
	}
	
	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('editOfferings', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
	
	
});