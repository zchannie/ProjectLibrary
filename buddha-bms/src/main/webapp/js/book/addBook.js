$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addBook', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});