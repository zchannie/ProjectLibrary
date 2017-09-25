<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta content="telephone=no" name="format-detection">	
	<title>高僧</title>
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<style type="text/css">
		.contain{
			width:100%;
			height:auto;
			overflow-x:hidden;
			overflow-y:scroll;
			background:#fffcf3;
			-webkit-overflow-scrolling: touch;
		}
		.conTitle{
			width:94.68%;
			padding:20px 2.66% 0 2.66%;
			height:auto;
			line-height:36px;
			font-size: 20px;
			color:#343436;
		}
		.detail{
			width:94.68%;
			padding:20px 2.66% 20px 2.66%;
			height:40px;
			line-height: 40px;
			overflow:hidden;
		}
		.time{
			float:left;
			color:#999999;
		}
		.number{
			float:right;
			color:#999999;
		}
		.eye{
			width:16px;
			height:10px;
		}
		.people{
			width:94.68%;
			padding:0 2.66% 30px 2.66%;
		}
		.txt{
			width:94.68%;
			padding:0 2.66% 30px 2.66%;
			font-size:16px;
			color:#313035;
			line-height:30px;
		}
		.txt img {
		    width: 100%;
		}
	</style>
</head>
<body>
	<div class="contain">
		<div class="conTitle">
			${title }
		</div>
		<div class="detail">
			<span class="time">${time }</span><span class="number"><img class='eye' src='../img/eye.jpg' />&nbsp;${num }人浏览</span>
		</div>
		<div class='txt'>
		${content }
		</div>
	</div>
</body>
</html>
