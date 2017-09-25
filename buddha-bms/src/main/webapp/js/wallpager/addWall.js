$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addWall', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});