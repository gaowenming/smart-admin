<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta http-equiv="x-ua-compatible" content="ie=ie9" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />
<title>管理平台</title>
<script type="text/javascript"
	src="${basePath}resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='${basePath}resource/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script type="text/javascript"
	src="${basePath}resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${basePath}resource/js/typeahead-bs2.min.js"></script>
<script type="text/javascript"
	src="${basePath}resource/js/ace-elements.min.js"></script>
<script type="text/javascript" src="${basePath}resource/js/ace.min.js"></script>
<link href="${basePath}resource/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="${basePath}resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="${basePath}resource/css/ace.min.css" />
<link rel="stylesheet" href="${basePath}resource/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${basePath}resource/css/ace-skins.min.css" />
<link href="${basePath}resource/jshow/css/bootstrap-modal-bs3patch.css"
	rel="stylesheet" />
<link href="${basePath}resource/jshow/css/bootstrap-modal.css"
	rel="stylesheet" />
<script src="${basePath}resource/js/ace-extra.min.js"></script>
<script src="${basePath}resource/jshow/js/bootstrap-modalmanager.js"></script>
<script src="${basePath}resource/jshow/js/bootstrap-modal.js"></script>
<script src="${basePath}resource/jshow/js/modal.manager.plugin1.0.js"></script>
<script src="${basePath}resource/jshow/js/jshow.utils.js"></script>
<script src="${basePath}resource/jshow/js/bootbox.js"></script>
</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 管理平台
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue" style="height: 50px;"><a
						data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
							class="nav-user-photo"
							src="${basePath}resource/images/avatar.gif" /> <span
							class="user-info"> <small>欢迎光临</small> <%=request.getUserPrincipal().getName()%>
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#responsive" data-toggle="modal"
								data-target="#responsive"> <i class="icon-cog"></i> 修改密码
							</a></li>

							<li><a href="${basePath}j_spring_security_logout"> <i
									class="icon-off"></i> 退出
							</a></li>
						</ul></li>

				</ul>
				<!-- /.ace-nav -->
			</div>

			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>


	<!-- 密码修改 -->
	<div id="responsive" class="modal fade" tabindex="-1" data-width="450"
		style="display: none;">
		<div class="modal-header">
			<h4 class="modal-title">修改密码</h4>
		</div>
		<div class="modal-body">
			<div class="row">
				<div class="col-md-12">
					<p>
						<label>原密码:</label> <input class="form-control" type="password"
							maxlength="30" id="oldPwd" name="oldPwd" />
					</p>
					<p>
						<label>新密码:</label> <input class="form-control" type="password"
							maxlength="30" id="newPwd" name="newPwd" />
					</p>
					<p>
						<label>确认密码:</label> <input class="form-control" type="password"
							maxlength="30" id="newPwdConfig" name="newPwdConfig" />
					</p>
					<p align="right">
						<button type="button" class="btn btn-info" id="changePassword"
							name="changePassword">
							<i class="icon-ok  icon-white"></i> 提交
						</button>
						<button type="button" data-dismiss="modal" class="btn btn-default">
							<i class="icon-remove-sign"></i> 取消
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>



	<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success no-hover"
							style="width: 100%; height: 40px;">
							<span>导航菜单</span>
						</button>
					</div>

				</div>
				<!-- #sidebar-shortcuts -->

				<!-- 导航栏 start -->
				<ul class="nav nav-list">

					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="#" class="dropdown-toggle"
							style="color: #2B7DBC"> <i class="icon-cog"></i> <span
								style="font-weight: bold; color: #2B7DBC" class="menu-text">系统管理</span>
								<b class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">

								<li><a href="${basePath}user/list.do"
									target="contentIframe"> <i class="icon-star"></i> <span
										class="menu-text">用户管理</span>
								</a></li>
								<li><a href="${basePath}role/list.do"
									target="contentIframe"> <i class="icon-star"></i> <span
										class="menu-text">角色管理</span>
								</a></li>
								<li><a href="${basePath}permission/list.do"
									target="contentIframe"> <i class="icon-star"></i> <span
										class="menu-text">权限管理</span>
								</a></li>

								<li><a href="${basePath}systemConfig/list.do"
									target="contentIframe"> <i class="icon-star"></i> <span
										class="menu-text">系统配置</span>
								</a></li>

								<li><a href="${basePath}dic/list.do" target="contentIframe">
										<i class="icon-star"></i> <span class="menu-text">字典管理</span>
								</a></li>

							</ul></li>
					</sec:authorize>



					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="#" class="dropdown-toggle"
							style="color: #2B7DBC"> <i class="icon-eye-open"></i> <span
								style="font-weight: bold; color: #2B7DBC" class="menu-text">系统监控</span>
								<b class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">

								<li><a href="${basePath}loginLog/list.do"
									target="contentIframe"> <i class="icon-star"></i> <span
										class="menu-text">登录日志</span>
								</a></li>

							</ul></li>
					</sec:authorize>


				</ul>
				<!-- /.nav-list -->
				<!-- 导航栏 end -->



				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="">首页</a></li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content" id="page-content" style="padding: 0px;">
					<iframe id="contentIframe" class="well well-sm" src="blank.html"
						name="contentIframe"
						style="position: relative; width: 100%; height: 100%; border: 0; margin: 0px;"></iframe>

				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

		</div>
		<!-- /.main-container-inner -->

	</div>
	<!-- /.main-container -->


	<script type="text/javascript">
		jQuery(function($) {
			$(window).resize(
					function() {
						if (/chrome/.test(navigator.userAgent.toLowerCase())) {
							//	$("#main-container").height($(window).height()-$("#navbar").height()-50);
						}
						$("#contentIframe").height(
								$(window).height() - $("#navbar").height()
										- $("#breadcrumbs").height() - 25);
					});
			$(window).resize();

			//修改密码
			$("#changePassword")
					.click(
							function() {

								if ($("#oldPwd").val() == ''
										|| $("#oldPwd").val().length < 6) {
									bootbox.alert("<h4>原密码长度小于6!</h4>");
									return false;
								}
								if ($("#newPwd").val() == ''
										|| $("#newPwd").val().length < 6) {
									bootbox.alert("<h4>新密码长度小于6!</h4>");
									return false;
								}
								if ($("#newPwdConfig").val() == ''
										|| $("#newPwdConfig").val().length < 6) {
									bootbox.alert("<h4>确认密码长度小于6!</h4>");
									return false;
								}
								if ($("#newPwd").val() != $("#newPwdConfig")
										.val()) {
									bootbox.alert("<h4>2次密码不一致!</h4>");
									return false;
								}
								$
										.post(
												"${basePath}user/changePassword.do",
												{
													oldPassword : $("#oldPwd")
															.val(),
													newPassword : $(
															"#newPwdConfig")
															.val()
												},
												function(data) {
													if (data == 'ok') {
														bootbox
																.alert(
																		'<h4>密码修改成功，请用新密码重新登录！</h4>',
																		function() {
																			window.location.href = '${basePath}j_spring_security_logout';
																		});
													} else {
														bootbox.alert("<h4>"
																+ data
																+ "</h4>");
														return false;
													}
												}, "text");
							});
		});
	</script>
</body>
</html>

