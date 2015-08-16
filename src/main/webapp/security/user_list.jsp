<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<script type="text/javascript">
	function changeStatus(id, content) {
		$.messager.confirm("操作确认", content, function() {
			window.location.href = "${_contextPath}user/changeStatus.do?id="
					+ id;
		});
	}
</script>
<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default" style="background-color: #EEEEEE; padding: 0px;">
			<div class="panel-heading" style="background-color: #F9F9F9;">
				<form class="form-inline" id="queryForm" name="queryForm"
					action="${_contextPath}user/list.do" method="post">
					<div class="form-group">
						<label for=username class="control-label">用户名</label> : <input
							type="text" class="form-control" id="username" name="username"
							autocomplete=off value="${queryBean.username}" placeholder="用户名">
					</div>
					<div class="form-group">
						<label for=fullname class="control-label">姓名</label> : <input
							type="text" class="form-control" id="fullname" name="fullname"
							autocomplete=off value="${queryBean.fullname}" placeholder="姓名">
					</div>

					<input type="hidden" name="sortName" id="sortName"
						value="${sorter.sortName}" /> <input type="hidden"
						name="sortType" id="sortType" value="${sorter.sortType}" />

					<button type="submit" id="submitbtn" class="btn btn-primary btn-sm">
						<i class="icon-search  icon-white"></i> 搜索
					</button>
					<button type="button" id="resetbtn" class="btn btn-primary btn-sm">
						<i class="icon-refresh  icon-white"></i> 重置
					</button>
				</form>
			</div>

			<div class="btn-group">
				<a href="${_contextPath}user/toAdd.do"
					class="btn btn-primary btn-sm"><i class="icon-plus  icon-white"></i> 创建</a>
				<button class="btn btn-danger btn-sm" id="delete">
					<i class="icon-trash icon-white"></i> 删除
				</button>
			</div>


			<form id="resultForm" action="${_contextPath}/user/delete.do"
				method="POST">
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th width="50px"><input type="checkbox" name="selectAll"
									id="selectAll" /></th>
								<th class="header">用户名<i class="icon-sort"></i><span
									style="display: none;">username</span></th>
								<th class="header">姓名<i class="icon-sort"></i><span
									style="display: none;">fullname</span></th>
								<th>手机号</th>
								<th>邮箱</th>
								<th>状态</th>
								<th width="200px">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${results}" var="item" varStatus="status">
								<tr>
									<td><input type="checkbox" value="${item.id}" name="ids" /> ${status.count}</td>
									<td>${item.username}</td>
									<td>${item.fullname}</td>
									<td>${item.mobile}</td>
									<td>${item.email}</td>
									<td><c:choose>
											<c:when test="${item.status == 1}">
									启用
								</c:when>
											<c:otherwise>
									禁用
								</c:otherwise>
										</c:choose></td>

									<td><a href="${_contextPath}user/toEdit.do?id=${item.id}"
										class="btn btn-primary btn-xs"><li
											class="icon-edit icon-white"></li> 编辑</a> <c:choose>
											<c:when test="${item.status==1}">
												<a href="javascript:changeStatus('${item.id}','确认禁用吗？')"
													class="btn btn-warning btn-xs"><li
													class="icon-warning-sign icon-white"></li> 禁用</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:changeStatus('${item.id}','确认启用吗？')"
													class="btn btn-success btn-xs"><li
													class="icon-ok-sign icon-white"></li> 启用</a>
											</c:otherwise>
										</c:choose>
										
										<a href="${_contextPath}user/toAddRole.do?userId=${item.id}"
										class="btn btn-info btn-xs"><li
											class="icon-user icon-white"></li> 角色管理</a> 
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			<div>
				<div>
					<div class="row" style="margin: 0px;">
						<c:import url="/common/pagination.jsp" />
					</div>
				</div
			</div>
		</div>
	</div>
</body>
<!-- /.table-responsive -->