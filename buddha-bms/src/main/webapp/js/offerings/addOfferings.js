$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addOfferings', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});