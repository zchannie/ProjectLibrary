<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>用户审核</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css" />
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>

<link href="<%=basePath%>um/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>um/third-party/template.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>um/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/user/editUser.js"></script>
</head>

<body>
	<table>
		<input id="roleId" type="hidden" value="${roleId}" />
		<input id="userId" type="hidden" value="${pubUser.userId}" />
		<tr>
			<td>用户名</td>
			<td><input id="newsTitle" style="width: 300px"
				class="easyui-textbox" type="text" placeholder="用户名"
				value="${pubUser.username}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>用户头像</td>
			<td><img width="150" src="${pubUser.picture}" /></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input id="phone" class="easyui-textbox" type="text"
				placeholder="电话" value="${pubUser.phone}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a id="btnPass" href="#"
				class="easyui-linkbutton">审核通过</a><a id="btnRefuse" href="#"
				class="easyui-linkbutton">审核未通过</a></td>
		</tr>
	</table>
</body>
</html>
