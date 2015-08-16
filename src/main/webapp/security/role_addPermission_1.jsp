<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/includes.jsp"%>
<%@ include file="/common/style.jsp"%>
    
    <script type="text/javascript">
     var treedata = '${itemJson}' ;
     var obj = eval('(' + treedata + ')');
    function load() {        
        var o = { showcheck: true
        //onnodeclick:function(item){alert(item.text);},        
        };
        o.data = obj;                  
        $("#tree").treeview(o);            
    }   
      $(document).ready(load);
      
      function submitId(){
    	  //var s=$("#tree").getCheckedNodes();
         // if(s !=null)
          //var ids = s.join(",") ;
          var idStr = "";
              var nodes =  $("#tree").getTSNs(true);//获取所有的勾选节点，包括半勾选
              $.each(nodes, function(i,value){      
                  var id = value.id;
                  if(id!='null'){
                     idStr += (id+",");
                  }
              });
          $("#permissionIds").attr("value",idStr); //填充内容 
          document.contentForm.submit();;
      }
    </script>
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
						<div id="tree">
                        </div>
                        
                        <input type="hidden" name="permissionIds"  id="permissionIds" hidden="hidden" />
					</td>
				</tr>


				<tr>
					<td class="text-right"></td>
					<td class="text-left">
						<button type="button" class="btn btn-primary" onclick="submitId()">
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