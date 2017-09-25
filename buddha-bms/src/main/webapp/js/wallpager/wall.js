$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddWall');
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
					temID = selRow[i].id;
				} else {
					temID = selRow[i].id + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delWall',
					data : {
						id : temID
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
		url : 'getInfoByPage',
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
					field : 'id',
					title : '壁纸主键',
					width : 70,
					sortable : true
				},{
					field : 'thumbnail',
					title : '壁纸图片',
					width : 150,
					sortable : true,
					height : 100,
					formatter : function(value, rowData,
							rowIndex) {
						return "<img src='"+ domain 
								+ value
								+ "' style='width:150px;height:100px'/>";
					}
				},{
					field : 'pid',
					title : '所属主题',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						if (value == '1') {
							return '观世音菩萨';
						} else if (value == '2') {
							return '阿弥陀佛';
						} else if (value == '3') {
							return '虔诚祈福';
						} else if (value == '4') {
							return '释迦摩尼';
						} else if (value == '5') {
							return '地藏王菩萨';
						} else if (value == '6') {
							return '禅意人生';
						} else if (value == '7') {
							return '文殊菩萨';
						} else if (value == '8') {
							return '佛字在我心';
						} else if (value == '9') {
							return '弥勒菩萨';
						} else if (value == '10') {
							return '禅香';
						} else if (value == '11') {
							return '一花一世界';
						} else if (value == '12') {
							return '一叶一菩提';
						} else if (value == '13') {
							return '人生感悟';
						} else if (value == '14') {
							return '禅语';
						} else if (value == '15') {
							return '佛珠';
						} else if (value == '16') {
							return '小和尚';
						} else if (value == '17') {
							return '清幽寺院';
						} else if (value == '18') {
							return '淡雅荷花';	
						} else if (value == '19') {
							return '素食养生';
						} else if (value == '20') {
							return '放生灵魂';
						} else if (value == '21') {
							return '茶道';
						} else if (value == '22') {
							return '水墨画';
						} else{
							return '其他主题';
						}
					}
				},{
					field : 'collectionTotal',
					title : '收藏总数',
					width : 220,
					sortable : true
				},{
					field : 'zanTotal',
					title : '赞总数',
					width : 220,
					sortable : true
				},{
					field : 'downloadTotal',
					title : '下载总数',
					width : 220,
					sortable : true
				}] ],
		onDblClickRow : function(index, row) {
			$("#iframe").attr('src',
					'toEditWall?id=' + row.id);
			$("#win").window({
				maximized : true
			});
			$("#win").window('open');

		}
	});

    //搜索按钮点击事件
	/*$("#btnSearch").click(function() {
		var keywordName = $("#keywordName").val();
		if (keywordName != "") {
			keywordName = encodeURI(keywordName);
		}
		
		$("#list").datagrid("load", {
			'WallName' : keywordName
		});
	});*/

});