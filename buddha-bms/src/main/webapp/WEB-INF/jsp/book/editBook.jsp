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
 
<title>经书修改</title>
<script type="text/javascript">
 var basePath="<%=basePath %>";
 window.UEDITOR_HOME_URL="<%=basePath %>/ueditor/";
 </script>
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


<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>ueditor/themes/iframe.css"/> 

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/book/commonBook.js"></script>


</head>

<body>
	<table>
		<input id="bookId" type="hidden" value="${book.bookId}" />
		<tr>
			<td>经书标题</td>
			<td><input id="bookTitle" style="width: 300px"
				class="easyui-textbox" type="text" placeholder="经书标题"
				value="${book.bookTitle}" required="true"></td>
		</tr>
		<tr>
			<td>经书简介</td>
			<td><input id="bookIntroduction" data-options="multiline:true"
				style="height: 60px; width: 300px" class="easyui-textbox"
				type="text" placeholder="经书标题" value="${book.bookIntroduction}"></td>
		</tr>
		<tr>
			<td>经书内容</td>
			<td><input id="bookIntroduction" data-options="multiline:true"
				style="height: 100px; width: 300px" class="easyui-textbox"
				type="text" placeholder="经书内容" value="${book.bookContent}"></td>
		</tr>
		<tr>
			<td>经书图片</td>
			<td><img id="imgPreview" width="150" /> <input id="picture"
				name="picture" type="text" hidden="1" value="${book.picture}" />
				<input id="file" name="file" type="file" /> <%-- <input id="pic" type="hidden" value="${book.picture}" /> --%>
				<a id="btnUpload" href="#" class="easyui-linkbutton">上传图片</a></td>
		</tr>
        <tr>
			<td>经书HTML</td>
			<td>
			   	<div style="display: none;"><p id="content" >${book.htmlUrl }</p></div>
				<div id="myEditor"  style="width: 600px; height: 300px;">
				<script type="text/javascript" charset="utf-8">
						var editor = new baidu.editor.ui.Editor();
						editor.render("myEditor");
					</script>
				</div>	
		 </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a id="btnSubmit" href="#"
				class="easyui-linkbutton">更新表单</a></td>
		</tr>
	</table>

	<script type="text/javascript" src="<%=basePath%>js/book/editBook.js"></script>
</body>
</html>
