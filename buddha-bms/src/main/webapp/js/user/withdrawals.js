$(function() {
	//var roleId = $("#roleId").val();
	var index;
	$("#list").datagrid({
		url : 'getDrawals',
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
					field : 'wid',
					title : '主键',
					width : 70,
					sortable : true
				},
				{
					field : 'userId',
					title : '用户主键',
					width : 70,
					sortable : true
				},
				{
					field : 'cardId',
					title : '卡ID',
					width : 200,
					sortable : true
				},
				{
					field : 'money',
					title : '金额',
					width : 200,
					sortable : true
				},
				{
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
							'toEditWithDrawals?wid=' + row.wid + "&userId=" + row.userId);
					$("#win").window({
						maximized : true
					});
					$("#win").window('open');
				}
	});
	$("#select").combobox({
		onChange : function(n, o) {
			$("#list").datagrid('load',{
				"status" : n,
			});
		}
	});
});
