<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"
			style="background-color: #EEEEEE; padding: 0px;">

			<form>
				<div class="table-responsive">
					<table id="resultsTable"
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th>任务名</th>
								<th>cron表达式</th>
								<th>任务类</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${results!=null && results!='[]'}">
								<c:forEach items="${results}" var="item">
									<tr>
										<td>${item.name }</td>
										<td>${item.cronExpression }</td>
										<td>${item.className }</td>
										<td>${item.status }</td>
									</tr>
								</c:forEach>
							</c:if>
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

