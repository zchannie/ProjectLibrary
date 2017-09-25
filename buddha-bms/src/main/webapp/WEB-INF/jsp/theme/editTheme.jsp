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
<script type="text/javascript" src="<%=basePath%>js/theme/commonTheme.js"></script>


</head>

<body>
	<table style="line-height: 35px;">
		<input id="themeId" type="hidden" value="${theme.themeId}" />
		<tr>
			<td>主题名称：</td>
			<td><input id="themeName" style="width: 300px"
				class="easyui-textbox" type="text" placeholder="主题名称"
				value="${theme.themeName}" required="true"></td>
		</tr>
		<tr>
			<td>主题图片：</td>
			<td style=" border: 1px solid #7EC0EE;padding-top: 5px;border-radius: 5px;"><img id="imgPreview" width="150" /> <input id="picture"
				name="picture" type="text" hidden="1" value="${theme.themeImg}" />
				<input id="file" name="file" type="file" />
				<a id="btnUpload" href="#" class="easyui-linkbutton">上传图片</a></td>
		</tr>
		<tr>
		<td>主题类型：</td>
			<td>
			<select id="themeSelect"  class="easyui-combobox"  name="aa" style="width:200px;" data-options="required:true">  
		            <option value="0"  <c:if test="${theme.type==0}">selected</c:if>>壁纸</option>
		            <option value="1"  <c:if test="${theme.type==1}">selected</c:if>>高僧</option>
		            <option value="2"  <c:if test="${theme.type==2}">selected</c:if>>人生</option>
		            <option value="3"  <c:if test="${theme.type==3}">selected</c:if>>运势</option>
		            <option value="4"  <c:if test="${theme.type==4}">selected</c:if>>素食</option>  
		    </select>  
			</td>
	    </tr>	
		<tr>
			<td>主题内容：</td>
			<td>
			<input id="themeContent"  type="text"  class="easyui-textbox" data-options="multiline:true" style="width:300px;height:100px"   value="${theme.themeContent}">
			</td>
		</tr>
		<tr>
		      <td>页面链接：</td>
			  <td>
			  <p id="content" >${theme.htmlUrl }</p>
			  </td>
		</tr>
			<tr>
			<td>主题描述</td>
			<td>
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
	<script type="text/javascript" src="<%=basePath%>js/theme/editTheme.js"></script>
</body>
</html>
