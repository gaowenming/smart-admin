<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问被拒绝</title>
<link href="<%=basePath%>resource/css/error.css" rel="stylesheet" />
</head>

<body>
	<div class="wrapper">
		<div class="innerWrapper">
			<!--header-->
			<div class="errheaderWarpper">
				<div class="errinnerHeader"></div>
			</div>
			<!--header-->
			<table width="100%" border="0">
				<tr>
					<td>
						<div class="demo">
							<p>
								<span>4</span><span>0</span><span>3</span>
							</p>
							<p>访问被拒绝,没有访问权限(´･ω･`)</p>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
