<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#permType").select2();
		$("#pid").select2();
	});
</script>
<body>

	<form action="${_contextPath }/permission/edit.do" id="contentForm"
		method="post"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">
				<c:if test="${not empty dataObj.id }">
					<input type="hidden" id="id" name="id" style="width: 300px;"
						value="${dataObj.id}" />
				</c:if>
				<tr>
					<td align="right" width="25%">权限名称: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permName" id="permName" data-rule="required"
						style="width: 300px;" value="${dataObj.permName}"></td>
				</tr>

				<tr>
					<td align="right" width="25%">权限值: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permUrl" id="permUrl" data-rule="required"
						style="width: 300px;" value="${dataObj.permUrl}"></td>
				</tr>

				<tr>
					<td align="right" width="25%">顺序: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permOrder" id="permOrder"
						data-rule="required,integer,range[~999]" style="width: 300px;"
						value="${dataObj.permOrder}"></td>
				</tr>

				<tr>
					<td align="right" width="25%">类型: <span class="required">*</span>
					</td>
					<td align="left"><select style="width: 300px;" name="permType"
						id="permType" data-rule="required">
							<option value="1"
								<c:if test='${dataObj.permType==1 }'> selected=selected </c:if>>URL</option>
							<option value="2"
								<c:if test='${dataObj.permType==2 }'> selected=selected </c:if>>导航菜单</option>
					</select></td>
				</tr>

				<tr>
					<td align="right" width="25%">上级权限:</td>
					<td align="left"><select style="width: 300px;"
						name="pId" id="pid">
						<c:forEach items="${list}" var="item">
								<option value="${item.id}" <c:if test="${item.id==dataObj.parentPermission.id }">selected=selected</c:if> >${item.permName}</option>
						</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td align="right" width="25%">备注: 
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="remark" id="remark" 
						style="width: 300px;" value="${dataObj.remark}"></td>
				</tr>

				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok  icon-white"></i> 提交
						</button> <a href="${_contextPath }/permission/list.do"
						class="btn btn-primary"> <i class=" icon-circle-arrow-left "></i>
							返回
					</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>

