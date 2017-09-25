$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addTheme', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});