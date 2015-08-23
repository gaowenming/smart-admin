<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
<script type="text/javascript">
	$(window).on('load', function() {
		show();
		$("#permType").select2(); 
		$("#pid").select2(); 
	});

	function show() {
		$.ajax({
			url : '${_contextPath }permission/findAll.do',
			type : 'POST',
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#pid").append(
							"<option value='"+data[i].id+"'>"
									+ data[i].permName + "</option>");
				}
			}
		});
	}
</script>

<body>

	<form action="${_contextPath }/permission/add.do" id="contentForm"
		method="post"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">
				<tr>
					<td align="right" width="25%">权限名称: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permName" id="permName" data-rule="required"
						style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">权限值: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permUrl" id="permUrl" data-rule="required"
						style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">顺序: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="permOrder" id="permOrder"
						data-rule="required,integer,range[~999]" style="width: 300px;"></td>
				</tr>

				<tr>
					<td align="right" width="25%">类型: <span class="required">*</span>
					</td>
					<td align="left"><select 
						style="width: 300px;" name="permType" id="permType"
						data-rule="required">
							<option value="1">URL</option>
							<option value="2">导航菜单</option>
					</select></td>
				</tr>

				<tr>
					<td align="right" width="25%">上级权限:</td>
					<td align="left"><select c
						style="width: 300px;" data-width="300px"
						name="pId" id="pid">
					</select></td>
				</tr>

				<tr>
					<td align="right" width="25%">备注:
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="remark" id="remark" 
						style="width: 300px;"></td>
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

