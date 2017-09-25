$(function() {

	var userId = $("#userId").val();
	var roleId = $("#roleId").val();

	$("#btnPass").click(function() {
		var parameter = {
			userId : userId,
			roleId : roleId,
			status : 1
		}
		curd('editUserRoleRelation', parameter);
		parent.$("#list").datagrid('reload');

	});

	$("#btnRefuse").click(function() {
		var parameter = {
			userId : userId,
			roleId : roleId,
			status : 2
		}
		curd('editUserRoleRelation', parameter);
		parent.$("#list").datagrid('reload');

	});

});