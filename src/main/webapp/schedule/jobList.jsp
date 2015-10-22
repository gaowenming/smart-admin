<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
<script type="text/javascript">
	function deleteJob(name, content) {
		$.messager.confirm("操作确认", content, function() {
			window.location.href = "${_contextPath}schedule/"+name+"/delete.do";
		});
	}
	
	function stopJob(name, content) {
		$.messager.confirm("操作确认", content, function() {
			window.location.href = "${_contextPath}schedule/"+name+"/stop.do";
		});
	}
	
	function runJob(name, content) {
		$.messager.confirm("操作确认", content, function() {
			$.post("${_contextPath}schedule/"+name+"/runNow.do",
					function(data) {
						$.bootstrapGrowl(data,{width: 350});
					}, "text");
		});
	}
	
	function resumeJob(name, content) {
		$.messager.confirm("操作确认", content, function() {
			window.location.href = "${_contextPath}schedule/"+name+"/resume.do";
		});
	}
</script>
<body>
	<div class="col-sm-12" style="padding: 0px;">
		<div class="panel panel-default"
			style="background-color: #EEEEEE; padding: 0px;">
			<div class="btn-group">
				<a href="${_contextPath}schedule/add.do" class="btn btn-primary btn-sm"><i
					class="icon-plus  icon-white"></i> 添加</a>
			</div>

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

								<th width="350px">操作</th>
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
										<td>
										<a href="javascript:stopJob('${item.name}','确认暂停吗？')"
											class="btn btn-warning btn-xs">
												<li class="icon-pause icon-white"></li> 暂停
										</a>
										
										<a href="javascript:resumeJob('${item.name}','确认恢复吗？')"
											class="btn btn-info btn-xs">
												<li class="icon-repeat icon-white"></li> 恢复
										</a>
										
										<a href="javascript:runJob('${item.name}','确认立即执行吗？')"
											class="btn btn-primary  btn-xs">
												<li class="icon-play icon-white"></li> 立即执行
										</a>
										
										<a href="${_contextPath}schedule/edit.do?cronExpression=${item.cronExpression}&name=${item.name}"
											class="btn btn-info btn-xs">
												<li class="icon-edit icon-white"></li> 修改表达式
										</a>
										
										<a href="javascript:deleteJob('${item.name}','确认删除吗？')"
											class="btn btn-danger btn-xs">
												<li class="icon-trash icon-white"></li> 删除
										</a>
										</td>
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

