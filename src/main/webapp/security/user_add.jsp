<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>

<body>
	<form method="post" action="${_contextPath}user/add.do"
		id="contentForm" name="contentForm" role="form"
		cssClass="form-horizontal"
		data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">

		<div class="table-responsive">
			<table width="100%" style="border: 0px;"
				class="table table-striped table-bordered">


				<tr>
					<td align="right" width="25%">用户名: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="username" id="username" data-rule="required"
						style="width: 300px;"></td>
				</tr>


				<tr>
					<td align="right" width="25%">姓名: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="fullname" id="fullname" data-rule="required"
						style="width: 300px;"></td>
				</tr>



				<tr>
					<td align="right" width="25%">密码: <span class="required">*</span>
					</td>
					<td align="left"><input type="password" class="input-sm"
						name="password" id="password" value="999999"
						style="width: 300px;">默认密码：999999</td>
				</tr>




				<tr>
					<td align="right" width="25%">邮箱: <span class="required">*</span>
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="email" id="email" data-rule="required;email"
						style="width: 300px;"></td>
				</tr>



				<tr>
					<td align="right" width="25%">手机: 
					</td>
					<td align="left"><input type="text" class="input-sm"
						name="mobile" id="mobile" data-rule="mobile"
						style="width: 300px;"></td>
				</tr>


				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="submit" class="btn btn-primary">
							<i class="icon-ok  icon-white"></i> 提交
						</button> <a href="${_contextPath}user/list.do" class="btn btn-primary"><i
							class=" icon-circle-arrow-left "></i> 返回</a>
					</td>
				</tr>


			</table>
		</div>
	</form>
</body>
</html>