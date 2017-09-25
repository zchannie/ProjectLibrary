$(function() {

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		if(parameter){
			curd('addBuddha', parameter);
			parent.$("#list").datagrid('reload');
			
		}
	});

});