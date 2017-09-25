<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">

<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>登录页面</TITLE>

<SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="js/common/constants.js"></script>

<STYLE>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #008ead;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background: url("images/username.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 43px;
	left: 40px;
}

.p_logo {
	background: url("images/password.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 40px;
}

a {
	text-decoration: none;
}

.tou {
	background: url("images/tou.png") no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background: url("images/left_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background: url("images/right_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background: url("images/left-handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background: url("images/right_handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}
</STYLE>

<SCRIPT type="text/javascript">
 function keyLogin(e){
  var theEvent = window.event || e;
      var code = theEvent.keyCode || theEvent.which;
	  if (code==13) {  //回车键的键值为13
	 	login();  //登录事件
	  }
  }
  
	function login(){
		var username = $("#username").val();
		var pwd = $("#password").val();
		if(username == null || username == ""){
			alert("请填写用户名！");
			$("#username").focus();
			return;
		} else if (pwd == null || pwd == ""){
			alert("请填写密码！");
			$("#username").focus();
			return;
		} else {
			$("#loginForm").submit();
		}
	};
	
</SCRIPT>

<META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</HEAD>
<BODY  onkeydown="keyLogin(event);">
	<DIV class="top_div"></input></DIV>
	<form action="login" method="post" id="loginForm">
		<DIV
		style="position: relative; background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
		<DIV style="width: 165px; height: 96px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<P style="padding: 30px 0px 10px; position: relative;">
			<SPAN class="u_logo"></SPAN> <INPUT class="ipt" type="text" name="username" id="username"
				placeholder="请输入用户名或手机号" value="">
		</P>
		<P style="position: relative;">
			<SPAN class="p_logo"></SPAN> <INPUT class="ipt" name="pwd" id="password"
				type="password" placeholder="请输入密码" value="">
		</P>
		<div style='text-align:left; margin-left:30px; line-height:30px; color:red;'>${error }</div>
		<DIV
			style="position: absolute; width: 400px; bottom: 0px;height: 50px; line-height: 50px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
			
			<P style="margin: 0px 35px 20px 45px;">
				<!-- <SPAN style="float: left;">
				<A style="color: rgb(204, 204, 204);" href="#">忘记密码?</A>
				</SPAN>  -->
				<SPAN style="float: right;"><!-- <A style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">注册</A> -->
				<button style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" type="button" onclick="login()">登录</button>
			</P>
		</DIV>
	</DIV>
	</form>
	<div style="text-align:center;"></div>
</BODY>
</HTML>
