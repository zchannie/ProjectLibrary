<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <script type="text/javascript">
 var basePath="<%=basePath %>"
 window.UEDITOR_HOME_URL="<%=basePath %>/ueditor/";
 </script>
<head>

<title>新闻发布</title>

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
<script type="text/javascript" src="<%=basePath%>js/news/commonNews.js"></script>
<script type="text/javascript" src="<%=basePath%>js/news/addNews.js"></script>

</head>

<body>
	<table>

		<tr>
			<td>新闻标题</td>
			<td><input id="newsTitle" style="width: 300px"
				class="easyui-textbox" type="text"  placeholder="新闻标题"  required="true"></td>
		</tr>
		<tr>
			<td>新闻简介</td>
			<td><input id="newsIntroduction" data-options="multiline:true"
				style="height: 60px; width: 300px" class="easyui-textbox"
				type="text" placeholder="新闻标题"></td>
		</tr>
		<tr>
			<td>新闻分类</td>
			<td>
			<select id="cateSelect"  class="easyui-combobox"  name="aa" style="width:200px;" data-options="required:true">  
		            <option value="0">壁纸</option>
		            <option value="1">高僧</option>
		            <option value="2">其他</option>
		    </select>  
			
			</td>
		</tr>
		<tr>
			<td>新闻图片</td>
			<td><img id="imgPreview" width="150" /> <input id="picture"
				name="picture" type="text" hidden="1" /> <input id="file"
				name="file" type="file" /> <a id="btnUpload" href="#"
				class="easyui-linkbutton">上传图片</a></td>
		</tr>
		<tr>
			<td>新闻内容</td>
			<td>
			<div style="display: none;"><p id="content" ></p></div>
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
				class="easyui-linkbutton">提交表单</a></td>
		</tr>
	</table>

</body>
</html>
