<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		
	<script type="text/javascript">
		$(function(){
			$('#tt2').tabs({
						plain:true,
						onSelect:function(title)
						{
						  // alert(title);
						}
						
			});
		});
		
		function showDestory(leaveId)
		{
			$('<div id="dlg23" class="easyui-dialog" style="width:550px;height:400px;padding:10px 20px" closed="true">').dialog({
		                title: "审批历史",
						modal: true,
						shadow: false,
						closed: false,
						href:'buse/approvedHistory.action?leaveId='+leaveId,
						onClose:function(){
						    //close方法触发的onClose事件,去调用destory方法
						    $('#dlg23').dialog('destroy')
						},
						buttons:[{
								text:'关闭',
								handler:function(){
								    //调用dialog的close方法
								    $('#dlg23').dialog('close');
								}
							}]
		         }
			   
			   );
		
		}
		
		function showProcessImage2(workflowId,leaveId)
		{
		   
		   $('<div id="dlg24" class="easyui-dialog" style="width:650px;height:500px;padding:10px 20px" closed="true">').dialog({
		                title: "当前流程",
						modal: true,
						shadow: false,
						closed: false,
						href:'buse/processImage.action?workflowId='+workflowId+"&leaveId="+leaveId,
						onClose:function(){
						    //close方法触发的onClose事件,去调用destory方法
						    $('#dlg24').dialog('destroy')
						},
						buttons:[{
								text:'关闭',
								handler:function(){
								    //调用dialog的close方法
								    $('#dlg24').dialog('close');
								}
							}]
		         }
			   
			   );
		}
		
	</script>
</head>
<body>
		<div id="tt2">
			<div title="待审批" cache="false" style="padding:10px;" href="buse/approve.action?type=noApprove">
			</div>
			<div title="已审批" cache="false" style="padding:10px;" href="buse/approve.action?type=hasApprove">
			</div>

		</div>

</body>
</html>