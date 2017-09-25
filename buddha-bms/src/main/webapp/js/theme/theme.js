$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddTheme');
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
					temID = selRow[i].themeId;
				} else {
					temID = selRow[i].themeId + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delTheme',
					data : {
						themeId : temID
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
//		sortName : sortName,
//		sortOrder : sortOrder,
		columns : [ [
				{
					field : 'ck',
					checkbox : true,
					width : '30'
				},
				{
					field : 'themeId',
					title : '主题主键',
					width : 70,
					sortable : true
				},{
					field : 'themeImg',
					title : '主题图片',
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
					field : 'themeName',
					title : '主题名称',
					width : 220,
					sortable : true
				},{
					field : 'type',
					title : '主题分类',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
					   if (value == 1) {          return '高僧';
						} else if (value == 2) {return '人生';
						} else if (value == 3) {return '运势';
						} else if (value == 4) {return '素食';
						} else{
							return '壁纸';
						}
					}
				},{
					field : 'htmlUrl',
					title : '页面访问链接',
					width : 450,
					sortable : true
				},{
					field : 'createTime',
					title : '发布时间',
					width : 200,
					sortable : true
//				},{
//					field : 'zanTotal',
//					title : '赞总数',
//					width : 100,
//					sortable : true
//				},{
//					field : 'downloadTotal',
//					title : '下载总数',
//					width : 100,
//					sortable : true
				}] ],
		onDblClickRow : function(index, row) {
			$("#iframe").attr('src',
					'toEditTheme?themeId=' + row.themeId);
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
			'themeName' : keywordName
		});
	});
	
	$("#cateId").change(function(){
		var value=$("#cateId").val();
		if (value != "9999") {
			value = encodeURI(value);
			$("#list").datagrid("load", {
				'type' :value
			});
		}else{
			$("#list").datagrid("load", {
				'type' :null
			});
		}
	});

});