<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#resultState").select2();

		//重置
		$("#queryForm").find("#resetbtn").click(function() {
			$("#queryForm").find(":text").each(function() {
				this.value = '';
			});
			$("#resultState").select2('val', '');

		});
	});
</script>
<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"
			style="background-color: #EEEEEE; padding: 0px;">
			<div class="panel-heading" style="background-color: #F9F9F9;">
				<form class="form-inline" id="queryForm" name="queryForm"
					action="${_contextPath}jobRunHistory/list.do" method="post">
					<div class="form-group">
						<label for="jobName" class="control-label">任务名称</label> : <input
							type="text" class="form-control" id="jobName" name="jobName"
							autocomplete=off value="${queryBean.jobName}" placeholder="任务名称">
					</div>

					<div class="form-group">
						<label for=id class="control-label">执行结果</label> : <select
							style="width: 100px;" name="resultState" id="resultState">
							<option value=""
								<c:if test='${queryBean.resultState=="" }'> selected=selected </c:if>>全部</option>
							<option value="1"
								<c:if test='${queryBean.resultState ==1 }'> selected=selected </c:if>>成功</option>
							<option value="0"
								<c:if test='${queryBean.resultState ==0 }'> selected=selected </c:if>>失败</option>
						</select>
					</div>

					<div class="form-group">
						<label for="jobName" class="control-label">开始时间</label> : <input
							type="text" class="form-control"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
							readonly="readonly" id="startTime" name="startTime"
							style="width: 180px;" autocomplete=off
							value="<fmt:formatDate value="${queryBean.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> "
							placeholder="开始时间">
					</div>

					<div class="form-group">
						<label for="jobName" class="control-label">结束时间</label> : <input
							type="text" class="form-control"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
							readonly="readonly" id="endTime" name="endTime"
							style="width: 180px;" autocomplete=off
							value="<fmt:formatDate value="${queryBean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/> "
							placeholder="结束时间">
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

			<form>
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th width="40px"></th>
								<th>名称</th>
								<th width="100px">结果</th>
								<th width="250px">上次执行时间</th>
								<th width="250px">下次执行时间</th>
								<th width="250px">节点名称</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${results}" var="item" varStatus="status">
								<tr>
									<td align="center">${status.count}</td>
									<td>${item.jobName}</td>
									<td><c:choose>
											<c:when test="${item.result=='SUCCESS'}">成功</c:when>
											<c:otherwise>
												<font style="color: red; font-weight: bold;">失败</font>
											</c:otherwise>
										</c:choose></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.previousFireTime }" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.nextFireTime }" /></td>
									<td>${item.nodeId}</td>
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

