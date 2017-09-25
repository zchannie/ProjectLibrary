$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddBuddha');
		$("#win").window({
			maximized : true
		});
		$("#win").window('open');
	});

	// 删除
	$("#btnUnRec").click(function() {
		var selRow = $('#list').datagrid('getSelections')
		// 判断是否选中行
		if (selRow.length == 0) {
			alert("请选择要删除的行!");
			return;
		} else {
			var temID = "";
			// 批量获取选中行的评估模板ID
			for (i = 0; i < selRow.length; i++) {
				if (temID == "") {
					temID = selRow[i].buddhaId;
				} else {
					temID = selRow[i].buddhaId + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delBuddha',
					data : {
						buddhaId : temID
					},
					async : false,
					success : function(data) {
						var result = data;// data.message;
						$.messager.show({
							title : "系统消息",
							msg : result.message
						});
					}
				});
				$("#list").datagrid('reload');
			})
		}

	});

	var sortName = 'createTime';
	var sortOrder = 'desc';

	var index;
	$("#list").datagrid(
	{
		url : 'getBuddhaByPage',
		method : 'GET',
		pagination : true,
		pagePosition : 'bottom',
		singleSelect : false,
		sortName : sortName,
		sortOrder : sortOrder,
		columns : [ [
				{
					field : 'ck',
					checkbox : true,
					width : '30'
				},
				{
					field : 'buddhaId',
					title : '佛教主键',
					width : 70,
					sortable : true
				},{
					field : 'imgUrl',
					title : '佛教图片',
					width : 150,
					sortable : true,
					height : 100,
					formatter : function(value, rowData,
							rowIndex) {
						return "<img src='"+ domain 
								+ value
								+ "' style='width:120px;height:90px'/>";
					}
				},{
					field : 'buddhaName',
					title : '佛教名称',
					width : 220,
					sortable : true
				},{
					field : 'createTime',
					title : '发布日期',
					width : 220,
					sortable : true,
					formatter : function(val, row) {
						return new Date(val).format();
					}
				}
				] ],
		onDblClickRow : function(index, row) {
			$("#iframe").attr('src',
					'toEditBuddha?buddhaId=' + row.buddhaId);
			$("#win").window({
				maximized : true
			});
			$("#win").window('open');

		}
	});

    //搜索按钮点击事件
	$("#btnSearch").click(function() {
		var keywordName = $("#keywordName").val();
		if (keywordName != "") {
			keywordName = encodeURI(keywordName);
		}
		
		$("#list").datagrid("load", {
			'buddhaName' : keywordName
		});
	});

});