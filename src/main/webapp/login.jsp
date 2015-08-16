<%@ page language="java" pageEncoding="UTF-8"%>
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
<title>用户登录</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="${basePath}resource/login/login.css"
	type="text/css" />
<link rel="stylesheet"
	href="${basePath}resource/css/jquery.validator.css" type="text/css" />
<script type="text/javascript"
	src="${basePath}resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${basePath}resource/js/jquery.validator.js"></script>
<script type="text/javascript"
	src="${basePath}resource/validator/local/zh_CN.js"></script>
<script type="text/javascript">
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
<body>

	<div class="content">
		<form action="${basePath }j_spring_security_check" method="post" name="login_form"
			id="login_form" autocomplete="off"
			data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
			<table width="100%">
				<thead>
					<td colspan="2" class="thead" align="center">用户登录</td>
				</thead>
				<tbody>
					<tr>
						<th><em class="red">*</em> 用户名</th>
						<td><input type="text" name="j_username" class="email ipt"
							data-rule="required"></td>
					</tr>
					<tr>
						<th><em class="red">*</em> 密&nbsp;&nbsp;码</th>
						<td><input type="password" name="j_password"
							data-rule="required" class="password ipt"></td>
					</tr>
					<tr>
						<th class="pd15"></th>
						<td class="pd15"><input type="submit" id="submit_btn"
							style="width: 85%;" value="登录"></td>
					</tr>
					<tr>
						<th class="pd15"></th>
						<td class="pd15"><font color="red">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</font>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
