<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<form method="post" action="${_contextPath}role/edit.do"
		id="contentForm" name="contentForm"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<input type="hidden" id="id" name="id" value="${dataObj.id}" />
		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">
				<tr>
					<td align="right" width="25%">角色名称 <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="name" id="name" data-rule="required"
						value="${dataObj.name }" style="width: 300px;"></td>
				</tr>
				
				<tr>
					<td align="right" width="25%">角色代码 <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm" value="${dataObj.roleCode }" 
						name="roleCode" id="roleCode" data-rule="required" style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">备注: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="remark" id="remark" value="${dataObj.remark }"
						data-rule="required" style="width: 300px;"></td>
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
	</form>
</body>
</html>