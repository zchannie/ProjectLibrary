<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>首页面</title>
	<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../easyui/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	
	<script type="text/javascript" src="../easyui/js/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>
</html>