<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>佛教修改</title>

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
<script type="text/javascript" src="<%=basePath%>js/buddha/commonBuddha.js"></script>


</head>

<body>
	<table>
		<input id="buddhaId" type="hidden" value="${buddha.buddhaId}" />
		<tr>
			<td>佛教名称</td>
			<td><input id="buddhaName" style="width: 300px"
				class="easyui-textbox" type="text" placeholder="佛教名称"
				value="${buddha.buddhaName}" required="true"></td>
		</tr>
		<tr>
			<td>佛教图片</td>
			<td><img id="imgPreview" width="150" /> <input id="picture"
				name="picture" type="text" hidden="1" value="${buddha.imgUrl}" />
				<input id="file" name="file" type="file" />
				<a id="btnUpload" href="#" class="easyui-linkbutton">上传图片</a></td>
		</tr>
		<tr>
			<td>佛教描述</td>
			<td>
			<input id="content"  class="easyui-textbox" data-options="multiline:true" value="${buddha.content}"   style="width:300px;height:100px"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a id="btnSubmit" href="#"
				class="easyui-linkbutton">更新表单</a></td>
		</tr>
	</table>
	<script type="text/javascript" src="<%=basePath%>js/buddha/editBuddha.js"></script>
</body>
</html>
