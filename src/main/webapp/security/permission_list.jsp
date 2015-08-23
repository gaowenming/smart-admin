<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"
			style="background-color: #EEEEEE; padding: 0px;">
			<div class="panel-heading" style="background-color: #F9F9F9;">
				<form class="form-inline" id="queryForm" name="queryForm"
					action="${_contextPath}/permission/list.do" method="post">
					<div class="form-group">
						<label for=id class="control-label">权限名称</label> : <input
							type="text" class="form-control" id="permName" name="permName"
							autocomplete=off value="${queryBean.permName}" placeholder="权限名称">
					</div>
					<div class="form-group">
						<label for=id class="control-label">权限地址</label> : <input
							type="text" class="form-control" id="permUrl" name="permUrl"
							autocomplete=off value="${queryBean.permUrl}" placeholder="权限地址">
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
				<a href="${_contextPath}permission/toAdd.do"
					class="btn btn-primary btn-sm"><i class="icon-plus  icon-white"></i> 创建</a>
				<button class="btn btn-danger btn-sm" id="delete">
					<i class="icon-trash icon-white"></i> 删除
				</button>
			</div>

			<form id="resultForm" name="resultsForm"
				action="${_contextPath}/permission/delete.do" method="POST">
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th width="50px"><input type="checkbox" name="selectAll"
									id="selectAll" /></th>
								<th class="header"><span style="display: none;">perm_name</span>权限名称<i
									class="icon-sort"></i></th>

								<th class="header"><span style="display: none;">perm_url</span>权限地址<i
									class="icon-sort"></i></th>


								<th class="header" width="10%"><span style="display: none;">perm_type</span>类别<i
									class="icon-sort"></i></th>

								<th class="header" width="8%"><span style="display: none;">perm_order</span>顺序<i
									class="icon-sort"></i></th>

								<th>备注</th>

								<th width="80px">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${results}" var="item" varStatus="status">
								<tr>
									<td>
									<c:if test="${item.id!=1 }">
									<input type="checkbox" name="ids" value="${item.id}"
										class="noborder" />
									</c:if>	
										 ${status.count}</td>
									<td>${item.permName}</td>
									<td>${item.permUrl}</td>
									<td><c:choose>
											<c:when test="${item.permType == 1}">
												页面操作
											</c:when>
											<c:otherwise>
												导航菜单
											</c:otherwise>
										</c:choose></td>
									<td>${item.permOrder}</td>
									<td>${item.remark}</td>
									<td>
									<c:if test="${item.id!=1 }">
									<a
										href="${_contextPath}/permission/toEdit.do?id=${item.id}"
										class="btn btn-primary btn-xs">
											<li class="icon-edit icon-white"></li> 编辑
									</a>
									</c:if>
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

