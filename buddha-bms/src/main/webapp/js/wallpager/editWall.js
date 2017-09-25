
$(function() {
	
	
	var picture = $("#picture").val();
	
	if(picture != ""){
		$("#imgPreview").attr('src', domain  + picture);
	}
	
/*	var content = $("#content").html();
	UM.getEditor('myEditor').setContent(content);*/

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('editWall', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
	
	
});