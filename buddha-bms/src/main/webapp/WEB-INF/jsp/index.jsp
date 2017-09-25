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
<meta charset="UTF-8">
<title>内容管理系统</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css">
<link rel="stylesheet" type="text/css"  href="<%=basePath%>easyui/css/demo.css">
<link rel="stylesheet" type="text/css"  href="<%=basePath%>easyui/css/style.css">

<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=basePath%>js/common/menu.js"></script>

</head>
<body class="easyui-layout">
	<!-- head -->
	
	<div data-options="region:'north',border:false"   style="height: 90px; background: url(images/index1_01.png); ">
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="90" colspan="2" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="38%" rowspan="2">
          <span style="color:#ffffff;margin-left:20px;font-family:宋体;font-size:30px;line-height:30px;">后台管理系统<br><span>
          <span style="font-size:13px;margin-left:50px;font-family:宋体;">www.buddhism.com</span>
          
          <!--  <img src="images/ " width="400" height="74" />-->
          </td>
          <td width="6%" rowspan="2">&nbsp;</td>
          <td width="56%" height="38" align="right">
            <table width="120" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><img src="images/index1_06.gif" width="16" height="16" /></td>
                <td align="center" class="font2"><a href="#" class="font2"><strong style="color:#ffffff;">帮助</strong></a></td>
                <td align="center"><img src="images/index1_08.gif" width="16" height="16" /></td>
                <td align="center" class="font2"><a href="${basePath }/buddha-bms/quit" class="font2"><strong  style="color:#ffffff;">退出</strong></a>&nbsp;&nbsp;&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="right">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right" class="font2">
                &nbsp;&nbsp;登陆用户：${user.username }&nbsp;|&nbsp;身份：管理员&nbsp;&nbsp;&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  </table>
	
	</div>
	
	
	
	<!-- menus -->
	<div data-options="region:'west',split:true,title:'菜单栏'"
		style="width: 13%;">
		<div id="leftAccordion" class="easyui-accordion" fit="true"
			align="center" animate="false">
			
			<c:if test="${not empty userRoleMenu}">
			 	<c:forEach items="${userRoleMenu}" var="menu" varStatus="vs">
			 		<c:if test="${vs.count > 1 and menu.pmenuId != userRoleMenu[vs.count-2].pmenuId}">
						</div>
					</c:if>
			 		
			 		<c:if test="${vs.count == 1 || menu.pmenuId != userRoleMenu[vs.count-2].pmenuId}">
			 			<div title="${menu.pmenuName}" align="center" style="padding-top: 12px; background-color: white">
			 		</c:if>
			 		
			 		<div class="menus" style="width: 100%; height: 23px; border-bottom: 1px solid gainsboro; text-align: left; line-height: 23px; padding-left: 14px; font-size: 13px"
						onMouseover="this.style.cursor= 'pointer'" title="${menu.menuName}" url="${menu.url}"><img src="images/index1_68.gif" width="11" height="14"/>&nbsp;&nbsp;${menu.menuName}</div>
					
			 	</c:forEach>
			 	
			 	</div>
			 </c:if> 
		</div>
	</div>

	<!-- 底部 -->
	<!-- <div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div> -->

	<!-- tabs -->
	<div id="tabs" class="easyui-tabs"
		data-options="tools:'#tab-tools',region:'center'"
		style="width: 700px; height: 250px"></div>

	<div id="tab-tools">
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-add'" onclick="addPanel()"></a> -->
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-remove'"
			onclick="removePanel()"></a>
	</div>

	<script type="text/javascript">
		var index = 0;

		function addPanel() {
			index++;
			$('#tabs').tabs(
					'add',
					{
						title : 'Tab' + index,
						content : '<div style="padding:10px">Contentssssssssss'
								+ index + '</div>',
						closable : true
					});
		}
		function removePanel() {
			var tab = $('#tabs').tabs('getSelected');
			if (tab) {
				var index = $('#tabs').tabs('getTabIndex', tab);
				$('#tabs').tabs('close', index);
			}
		}
	</script>
</body>
</html>