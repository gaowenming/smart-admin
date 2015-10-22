<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
</head>


<body>

	<form action="${_contextPath }schedule/save.do" id="contentForm"
		method="post"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">
				<tr>
					<td align="right" width="25%">任务名: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="name" id="name" data-rule="required" style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">表达式: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="cronExpression" id="cronExpression" data-rule="required" style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">任务类: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="className" id="className" data-rule="required" style="width: 300px;"></td>
				</tr>


				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok  icon-white"></i> 提交
						</button> <a href="${_contextPath }schedule/list.do" class="btn btn-primary">
							<i class=" icon-circle-arrow-left "></i> 返回
					</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>

