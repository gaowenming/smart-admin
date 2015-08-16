<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录会议签到后台管理系统</title>
<link href="${basePath}resource/css/login.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="${basePath}resource/css/jquery.validator.css" type="text/css" />
<script type="text/javascript"
	src="${basePath}resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${basePath}resource/js/jquery.validator.js"></script>
<script type="text/javascript"
	src="${basePath}resource/validator/local/zh_CN.js"></script>
<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});

	//支持Enter键登录
	document.onkeydown = function(e) {
		if (!e)
			e = window.event;
		if ((e.keyCode || e.which) == 13) {
			$("#login_form").submit();
		}
	}
</script>

</head>

<body
	style="background-color:#1c77ac; background-image:url(${basePath}resource/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<form action="${basePath }j_spring_security_check" method="post"
		name="login_form" id="login_form" autocomplete="off"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<div class="loginbody">
			<span class="systemlogo"></span>
			<div class="loginbox">
				<ul>
					<li><input name="j_username" type="text" class="loginuser"
						data-rule="required" placeholder="用户名" /></li>
					<li><input name="j_password" type="password" class="loginuser"
						data-rule="required" placeholder="密码" /></li>
					<li><input name="submit_btn" id="submit_btn" type="submit"
						class="loginbtn" value="登录" /><label> </label><input name="reset"
						type="reset" class="loginbtn" value="重置" /></li>
					<li><font color="red" style="font-size: 14px;">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</font></li>
				</ul>
			</div>
		</div>
	</form>
</body>

</html>
