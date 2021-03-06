<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"  style="background-color: #EEEEEE; padding: 0px;">
			<div class="panel-heading"  style="background-color: #F9F9F9;">
				<form class="form-inline" id="queryForm" name="queryForm"
					action="${_contextPath}systemConfig/list.do" method="post">
					<div class="form-group">
						<label for="name" class="control-label">配置名称</label> : <input
							type="text" class="form-control" id="name" name="name"
							autocomplete=off value="${queryBean.name}" placeholder="配置名称">
					</div>
					<div class="form-group">
						<label for="configKey" class="control-label">配置标识</label> : <input
							type="text" class="form-control" id="configKey"
							name="configKey" autocomplete=off
							value="${queryBean.configKey}" placeholder="配置标识">
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
				<a href="${_contextPath}systemConfig/toAdd.do"
					class="btn btn-primary btn-sm"><i class="icon-plus  icon-white"></i> 创建</a>
				<button class="btn btn-danger btn-sm" id="delete">
					<i class="icon-trash icon-white"></i> 删除
				</button>
			</div>


			<form id="resultForm" action="${_contextPath}systemConfig/delete.do"
				method="POST">
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th width="50px"><input type="checkbox" name="selectAll"
									id="selectAll" /></th>
								<th class="header">配置名称<i class="icon-sort"></i><span
									style="display: none;">name</span></th>
								<th>配置标识</th>
								<th>配置值</th>
								<th width="80px">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${results}" var="item"  varStatus="status">
								<tr>
									<td><input type="checkbox" value="${item.id}" name="ids" /> ${status.count}</td>
									<td>${item.name}</td>
									<td>${item.configKey}</td>
									<td>${item.configValue}</td>
									<td><a
										href="${_contextPath}systemConfig/toEdit.do?id=${item.id}"
										class="btn btn-primary btn-xs"><li
											class="icon-edit icon-white"></li> 编辑</a></td>
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