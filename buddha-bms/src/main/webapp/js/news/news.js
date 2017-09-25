$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddNews');
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
					temID = selRow[i].newsid;
				} else {
					temID = selRow[i].newsid + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delNews',
					data : {
						newsid : temID
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

	var sortName = 'publishDate';
	var sortOrder = 'asc';

	var index;
	$("#list")
			.datagrid(
					{
						url : 'getNewsByPage',
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
								},{
									field : 'newsid',
									title : '新闻主键',
									width : 70,
									sortable : true
								},{
									field : 'newsTitle',
									title : '新闻标题',
									width : 100,
									sortable : true
								},{
									field : 'newsIntroduction',
									title : '新闻简介',
									width : 300,
									sortable : true
								},{
									field : 'type',
									title : '新闻类型',
									width : 100,
									sortable : true,
									formatter : function(value, row, index) {
										if (value == 0) {
											return '壁纸';
										} else if (value == 1) {
											return '高僧';
										}
									}
								},{
									field : 'picture',
									title : '新闻图片',
									width : 150,
									sortable : true,
									height : 100,
									formatter : function(value, rowData,
											rowIndex) {
										return "<img src='"+ domain 
												+ value
												+ "' style='width:120px;height:90px'/>";
									}
								}, {
									field : 'publishDate',
									title : '发布日期',
									sortable : true,
									formatter : function(val, row) {
										return new Date(val).format();
									}},{
										field : 'htmlUrl',
										title : 'HTML链接',
										width : 100,
										sortable : true
								} ] ],
						onDblClickRow : function(index, row) {
							$("#iframe").attr('src',
									'toEditNews?newsid=' + row.newsid);
							$("#win").window({
								maximized : true
							});
							$("#win").window('open');

						}
					});

});