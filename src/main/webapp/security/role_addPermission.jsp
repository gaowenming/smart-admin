<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<form method="post" action="${_contextPath}role/addPermission.do"
		id="contentForm" name="contentForm"
		cssClass="form-horizontal"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">

		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">

				<tr>
					<td align="right" width="25%">角色名称:</td>
					<td align="left"><input type="hidden" name="roleId"
						value="${dataObj.id }"> ${dataObj.name }</td>
				</tr>

				<tr>
					<td align="right" width="25%">权限:</td>
					<td align="left">
						<c:forEach items="${listItem}" var="chosenItem">
								<c:if test="${chosenItem.id != 0}">
									<div class="checkbox">
										<label> <input type="checkbox" name="permissionIds"  value="${chosenItem.id}"  <c:if test="${chosenItem.chosen }">checked='checked'</c:if>> ${chosenItem.value}
										</label>
									</div>
								</c:if>
						</c:forEach>
					</td>
				</tr>


				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok  icon-white"></i> 提交
						</button> <a href="${_contextPath}role/list.do" class="btn btn-primary"><i
							class=" icon-circle-arrow-left "></i> 返回</a>
					</td>
				</tr>


			</table>
		</div>
	</form>
</body>
</html>