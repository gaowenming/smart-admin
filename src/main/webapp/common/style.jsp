<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<title>会议签到</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="X-UA-Compatible" content="IE=IE9" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${_contextPath}resource/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${_contextPath}resource/css/font-awesome.min.css" />
<link href="${_contextPath}resource/css/jquery.validator.css" rel="stylesheet" />
<link href="${_contextPath}resource/css/smart.css" rel="stylesheet" />
<link href="${_contextPath}resource/select2/select2.css" rel="stylesheet"/>

<script src="${_contextPath}resource/js/jquery-1.11.0.min.js"></script>
<script src="${_contextPath}resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='${_contextPath}resource/js/jquery.mobile.custom.min.js'>"+ "<"+"/script>");
</script>
<script src="${_contextPath}resource/js/typeahead-bs2.min.js"></script>
<script src="${_contextPath}resource/laydate/laydate.dev.js">
<script src="${_contextPath}resource/js/bootbox.min.js"></script> 
<script src="${_contextPath}resource/js/jquery.bootstrap-growl.min.js"></script>
<script src="${_contextPath}resource/js/smart.js"></script>
<script src="${_contextPath}resource/js/jquery.bootstrap.js"></script>
<script type="text/javascript" src="${_contextPath}resource/js/jquery.validator.js"></script>
<script type="text/javascript" src="${_contextPath}resource/js/i18n/jquery.validator.zh_CN.js"></script> 
<script type="text/javascript" src="${_contextPath}resource/select2/select2.min.js"></script>
<script type="text/javascript" src="${_contextPath}resource/select2/select2_locale_zh-CN.js"></script>
<script type="text/javascript">
	$(function() {
		var message = "${message}";
		if (message != "" && message != "null") {
			$.bootstrapGrowl(message,{width: 350});
		}
	});
	laydate.skin('yahui'); //初始化
<%request.removeAttribute("message");  //清理%>
</script>

<!-- wdtree -->
<link href="${_contextPath}resource/wdTree/css/tree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${_contextPath}resource/wdTree/src/Plugins/jquery.tree.js" ></script>
<!-- wdtree -->

</head>
