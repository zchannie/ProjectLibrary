$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addNews', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});