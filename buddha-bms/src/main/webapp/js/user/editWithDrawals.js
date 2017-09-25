$(function() {

	var wid = $("#wid").val();

	$("#btnPass").click(function() {
		var parameter = {
			wid : wid,
			status : 1
		}
		curd('editWithDraStatus', parameter);
		parent.$("#list").datagrid('reload');

	});

	$("#btnRefuse").click(function() {
		var parameter = {
			wid : wid,
			status : 2
		}
		curd('editWithDraStatus', parameter);
		parent.$("#list").datagrid('reload');

	});

});