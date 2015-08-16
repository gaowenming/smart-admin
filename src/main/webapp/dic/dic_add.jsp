<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
</head>


<body>

	<form action="${_contextPath }dic/add.do" id="contentForm"
		method="post"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">
				<tr>
					<td align="right" width="25%">字典名称: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="name" id="name" data-rule="required" style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">字典值: <span class="required">*</span>
					</td>
					<td align="left"><textarea type="text" data-rule="required"
							style="width: 50%; height: 150px;" name="dicValue" id="dicValue"></textarea>
						</textarea></td>
				</tr>

				<tr>
					<td align="right" width="25%">描述: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="remark" id="remark" data-rule="required"
						style="width: 300px;"></td>
				</tr>

				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok  icon-white"></i> 提交
						</button> <a href="${_contextPath }dic/list.do" class="btn btn-primary">
							<i class=" icon-circle-arrow-left "></i> 返回
					</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>

