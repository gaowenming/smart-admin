<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"
			style="background-color: #EEEEEE; padding: 0px;">
			<div class="panel-heading" style="background-color: #F9F9F9;">
				<form class="form-inline" id="queryForm" name="queryForm"
					action="${_contextPath}dic/list.do" method="post">
					<div class="form-group">
						<label for="name" class="control-label">名称</label> : <input
							type="text" class="form-control" id="name" name="name" style="width: 300px;"
							autocomplete=off value="${queryBean.name}" placeholder="名称">
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
				<a href="${_contextPath}dic/toAdd.do" class="btn btn-primary btn-sm"><i
					class="icon-plus  icon-white"></i> 创建</a>
				<button class="btn btn-danger btn-sm" id="delete">
					<i class="icon-trash icon-white"></i> 删除
				</button>
			</div>

			<form id="resultForm" name="resultsForm"
				action="${_contextPath}dic/delete.do" method="POST">
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th width="30px"><input type="checkbox" name="selectAll"
									id="selectAll" /></th>

								<th>字典名称</th>
								<th>字典值</th>
								<th>描述</th>


								<th width="100px">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${results}" var="item">
								<tr>
									<td><input type="checkbox" name="ids" value="${item.id}"
										class="noborder" /></td>
									<td>${item.name}</td>
									<td>${item.dicValue}</td>
									<td>${item.remark}</td>
									<td><a href="${_contextPath}dic/toEdit.do?id=${item.id}"
										class="btn btn-info btn-xs">
											<li class="icon-edit icon-white"></li> 编辑
									</a></td>
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

