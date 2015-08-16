<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
<div class="col-sm-12" style="padding: 0px;">
	<div class="panel panel-default"  style="background-color: #EEEEEE; padding: 0px;">
		<div class="panel-heading"  style="background-color: #F9F9F9;">
		<form class="form-inline" id="queryForm" name="queryForm"
				action="${_contextPath}loginLog/list.do" method="post" >
				<div class="form-group">
					<label for="username" class="control-label">用户名</label>  :  <input type="text" class="form-control" id="username"
						name="username" autocomplete=off value="${queryBean.username}" style="width: 200px;"
						placeholder="用户名">
				</div>

				<input type="hidden" name="sortName" id="sortName" value="${sorter.sortName}" />
				<input type="hidden" name="sortType" id="sortType" value="${sorter.sortType}" />
					
				<button type="submit" id="submitbtn" class="btn btn-primary btn-sm"><i class="icon-search  icon-white"></i> 搜索</button>
				<button type="button" id="resetbtn" class="btn btn-primary btn-sm" ><i class="icon-refresh  icon-white"></i> 重置</button>
			</form>
</div>

<div class="table-responsive">
<table id="resultsTable"
			class="table table-striped table-bordered table-condensed table-hover">
	<thead>
		<tr>
		<th>用户名</th>
			
		<th>登录IP</th>
			
		<th class="header" ><span
				style="display: none;">loginTime</span>登录时间<i
						class="icon-sort"></i></th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results}" var="item">
					<tr>
			 <td >${item.username}</td>
			 <td >${item.clientIp}</td>
			 <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.loginTime }" /></td>
					</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
<br>
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

