$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	var newNodeNum = 0;
	var updateRowId = '';
	$("#tg").treegrid(
			{
				url : 'getCategorys',
				method : 'GET',
				rownumbers : true,
				singleSelect : false,
				idField : 'categoryId',
				treeField : 'categoryName',
				toolbar : [ {
					text : "保存新增",
					iconCls : "icon-save",
					handler : function() {// 回调函数
						for (var i = 1; i <= newNodeNum; i++) {
							$("#tg").treegrid("endEdit", "newNode" + i);
						}
						newNodeNum = 0;
						var getChangeRows = $("#tg").treegrid("getChanges");

						if (getChangeRows.length < 0) {
							// jQuery.messager.alert("提示","请选择需要修改的条目");
							return;
						}
						$(getChangeRows).each(function(i, row) {
							var categoryName = row.categoryName;
							var status = row.status;
							var parentId = row.parentId;
							var parameter = {
								categoryName : categoryName,
								parentId : parentId,
								status : status
							};

							curd('insertCategory', parameter);
							$("#tg").treegrid('reload');
							$("#tg").treegrid('acceptChanges');
						});
					}
				}, {
					text : "删除",
					iconCls : "icon-remove",
					handler : function() {
						var temID = "";
						var selRow = $('#tg').datagrid('getSelections');
						// 判断是否选中行
						if (selRow.length == 0) {
							alert("请选择要删除的行!");
							return;
						} else {
							// 批量获取选中行的评估模板ID
							for (i = 0; i < selRow.length; i++) {
								if(selRow[i].parentId == 0){
									alert("不允许删除一级分类");
									return;
								}else{
									if (temID == "") {
										temID = selRow[i].categoryId;
									} else {
										temID = selRow[i].categoryId + "," + temID;
									}
								}
							}
						}
						$.messager.confirm('提示', '是否删除选中数据?', function(r) {
							if (!r) {
								return;
							}
							$.ajax({
								url : 'delCategory',
								data : {
									categoryId : temID
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
							$("#tg").treegrid('reload');
						})
					}
				} ],
				columns : [ [ {
					field : 'ck',
					checkbox : true,
					width : '30'
				}, {
					field : 'categoryId',
					title : '分类Id',
					width : 300,
					editor : 'textbox',
					hidden : true
				}, {
					field : 'categoryName',
					title : '分类名称',
					width : 300,
					editor : 'textbox',
					sortable : true
				}, {
					field : 'status',
					title : '状态',
					width : 100,
					sortable : true,
					formatter : function(value, rowData, rowIndex) {
						return value == 0 ? "无效" : "有效";
					},
					editor : {
						type : 'combobox',
						options : {
							data : [ {
								"value" : "0",
								"text" : "无效",
								"selected" : true
							}, {
								"value" : "1",
								"text" : "有效"
							} ],
							valueField : "value",
							textField : "text",
							editable : false,
							panelHeight : 70
						}
					}
				},{
					field : 'picture',
					title : '图标',
					width : 150,
					editor : 'textbox',
					sortable : true,
					height : 50,
					formatter : function(value, rowData,
							rowIndex) {
						return "<img src='"+ domain 
								+ value
								+ "' style='width:50px;height:50px'/>";
					},
				}, ] ],
				onLoadSuccess : function(row, data) {
					$.each(data, function(i, val) {
						$('#tg').treegrid('collapseAll', data[i].id)
					})
				},
				onClickRow : function(r) {
					if (updateRowId) {
						$('#tg').treegrid('endEdit', updateRowId);
					}
					var updatedRows = $('#tg')
							.treegrid('getChanges', 'updated');
					$(updatedRows).each(function(index, row) {
						var categoryId = row.categoryId;
						var categoryName = row.categoryName;
						var status = row.status;
						var picture=row.picture;

						var parameter = {
							categoryId : categoryId,
							categoryName : categoryName,
							status : status,
							picture: picture
						};

						curd('updateCategory', parameter);
						$("#tg").treegrid('reload');
						$("#tg").treegrid('acceptChanges');

					});
				},
				onDblClickRow : function(row) {
					// console.log(index);
					$('#tg').treegrid('beginEdit', row.categoryId);

					updateRowId = row.categoryId;
				},
				onContextMenu : function(e, row) {
					e.preventDefault();
					$('#mm').menu(
							'show',
							{
								left : e.pageX,
								top : e.pageY,
								onClick : function(item) {
									newNodeNum++;
									$('#tg').treegrid(
											'append',
											{
												parent : row.categoryId,
												data : [ {
													categoryId : "newNode"
															+ newNodeNum, // 标记新增
													parentId : row.categoryId,
													status : 0
												} ]
											});
									var newNode = $("#tg").treegrid("find",
											"newNode" + newNodeNum);

									$("#tg").treegrid("expandTo",
											newNode.categoryId);
									$("#tg").treegrid("select",
											newNode.categoryId);
									$("#tg").treegrid("beginEdit",
											newNode.categoryId);

								}
							});

				}
			});

});