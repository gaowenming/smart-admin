<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin管理平台--对不起，您访问的页面出错了</title>
</head>
<body>
	<%
		Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
		if (error == null)
			error = (Throwable) request.getAttribute("javax.servlet.jsp.jspException");
		String errorMsg = "";
		if (error != null)
			errorMsg = error.getMessage();
	%>
	<div class="wrapper">
		<div class="innerWrapper">
			<!--header-->
			<div class="errheaderWarpper">
				<div class="errinnerHeader"></div>
			</div>
			<!--header-->
			<table width="600" border="0">
				<tr>
					<td width="120" valign="top"><img
						src="${pageContext.request.contextPath}/img/error.jpg"
						alt="System Error" /></td>
					<td width="480">
						<h2>对不起，系统出错了！</h2>
						<div class="errorinfo">
							<strong>错误信息</strong>
						</div>
						<div class="error">
							<span> <%=errorMsg%>
							</span>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
