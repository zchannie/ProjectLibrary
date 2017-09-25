<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>供品信息</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/demo.css">

<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>

<script type="text/javascript" src="<%=basePath%>js/offerings/offerings.js"></script>

</head>

<body class="easyui-layout">

	<div region="center" title="供品菜单">
		<div class="menus">
			<a href="javascript:void(0)" id="btnAdd" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">新增</a> <a href="javascript:void(0)"
				id="btnUnRec" class="easyui-linkbutton" iconCls="icon-no"
				plain="true">删除</a>
				
				<input type="text" class="easyui-txtbox"  style="margin-left:20px;" placeholder="请输入名称" id="keywordName"> 
				<td colspan="2"><button id="btnSearch">搜索</button>
		</div>
		<div id="list"></div>
	</div>


	<div id="win"
		style="padding: 5px; width: 750px; height: 350px; overflow: hidden"
		class="easyui-window" closed="true" modal="true" maximized='false'>
		<iframe name="iframe" id="iframe" scrolling="yes" frameborder="0"
			style="width: 100%; height: 100%;"></iframe>
	</div>

</body>
</html>
