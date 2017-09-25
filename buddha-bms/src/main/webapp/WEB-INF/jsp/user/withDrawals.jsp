<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>
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
<script type="text/javascript" src="<%=basePath%>js/user/withdrawals.js"></script>
</head>
<body class="easyui-layout">
	<%-- <input type="hidden" value="${roleId }" id="roleId" /> --%>
	<div data-options="region:'center',iconCls:'icon-ok'" title="Center" style="padding: 5px">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true" style="height: 150px">
				<table>
					<tr>
						<td>
							<select class="easyui-combobox" style="width: 100px;" id="select">
								<option value="-1">全部</option>
								<option value="0">待审核</option>
								<option value="1">审核通过</option>
								<option value="2">审核未通过</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div data-options="region:'center'">
				<div id="list"></div>
			</div>
		</div>
	</div>
	<div id="win" style="padding: 5px; width: 750px; height: 350px; overflow: hidden" 
		class="easyui-window" closed="true" modal="true" maximized='false'>
		<iframe name="iframe" id="iframe" scrolling="yes" frameborder="0" style=" width:100%; height:100%;"></iframe>
	</div>
</body>
</html>
