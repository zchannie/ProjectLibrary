$(function() {
	var roleId = $("#roleId").val();
	var index;
	$("#list").datagrid({
		url : 'getUserByPage?roleId=' + roleId,
		method : 'GET',
		pagination : true,
		pagePosition : 'bottom',
		singleSelect : false,
		columns : [ [
				{
					field : 'ck',
					checkbox : true,
					width : '30'
				},
				{
					field : 'userId',
					title : '主键',
					width : 70,
					sortable : true
				},
				{
					field : 'username',
					title : '用户名',
					width : 70,
					sortable : true
				},
				{
					field : 'phone',
					title : '电话',
					width : 200,
					sortable : true
				},
				{
					field : 'picture',
					title : '头像',
					width : 150,
					sortable : true,
					height : 100,
					formatter : function(value, rowData,
							rowIndex) {
						return "<img src='"
								+ domain
								+ value
								+ "' style='width:120px;height:90px'/>";
					}
				}, {
					field : 'roleNames',
					title : '角色',
					width : 200,
					sortable : true
				}, {
					field : 'status',
					title : '状态',
					width : 150,
					sortable : true,
					formatter : function(value, row, index) {
						if (value == '0') {
							return '待审核'
						} else if (value == '1') {
							return '审核通过'
						} else if (value == '2') {
							return '审核未通过'
						}
					}
				} ] ],
				onDblClickRow : function(index, row) {
					$("#iframe").attr('src',
							'toEditUser?userId=' + row.userId + "&roleId=" + roleId);
					$("#win").window({
						maximized : true
					});
					$("#win").window('open');
				}
	});
	$("#select").combobox({
		onChange : function(n, o) {
			$("#list").datagrid('load',{
				'roleId' : roleId ,
				"status" : n,
			});
		}
	});
});
