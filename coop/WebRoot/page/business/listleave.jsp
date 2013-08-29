<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/demo.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		
	<script>
	
	    function showDestory2(leaveId)
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
		
		function showProcessImage(workflowId,leaveId)
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
		
		
		$(function(){
		   
			$('#tt').datagrid({
				title:'请假申请',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'buse/getLeaveAjaxData.action?type=listleave',
				fitColumns:true,
				
							
				columns:[[
				    {title:'标题',field:'title',width:100},
				    {title:'请假类型',field:'leaveType',width:100},
				    {title:'开始时间',field:'startTime',width:100},
				    {title:'结束时间',field:'endTime',width:100},
				    {title:'请假天数',field:'days',width:60},
				    {title:'状态',field:'status',width:60},
					{title:'创建时间',field:'createTime',width:100},
					{field:'opt',title:'操作',width:140,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
						    var a = "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getLeaveById2(\"edit\","+rec.id+")'></span>";
						    var b = "<span style='padding-right:10px;'><img src='../themes/icons/ok.png'\ title='提交' style='cursor:pointer;border:1px solid #7eabcd;' onclick='subInput("+rec.id+")' ></span>";
						    var c = "<span style='padding-right:10px;'><img src='../themes/icons/edit_remove.png'\ title='删除' style='cursor:pointer;'onclick='deleteLeave("+rec.id+")' ></span>";
						    var d = "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getLeaveById2(\"view\","+rec.id+")' ></span>";
						    var f = "<span style='padding-right:10px;'><img src='../themes/icons/tree_file.gif'\ title='审批历史' style='cursor:pointer'onclick='showDestory2("+rec.id+")' ></span>";
						    var g = "<span style='padding-right:10px;'><img src='../themes/icons/valid.png'\ title='当前流程' style='cursor:pointer'onclick='showProcessImage("+rec.workflow+","+rec.id+")' ></span>";
							//alert($.trim(rec.status)=='新增')
							//alert(encodeURI(rec.status));
							//alert(decodeURI('%E6%96%B0%E5%BB%BA'));
							
							if(rec.status=='新建' || rec.status=='退回修改')
							{
							   return a+b+c+d+f+g;
							}
							else if(rec.status=='完成')
							{
							   return c+d+f+g;
							}
							else
							{
							   return d+f+g;
							}
						    
							       
							       
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
		});
		
		
		function loadLeave(tit,url,opt){
			
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:500px;height:480px;padding:5px 5px" closed="true">');
			
			var options = {
	                title: tit,
					modal: true,
					shadow: false,
					closed: false,
					href:url,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy')
					}
	         }
			if(opt=='edit' || opt=='add')
			{
				settings = {
				    buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveLeave('buse/saveLeave.action?opt='+opt);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg').dialog('close');
							}
						}]
				}
			    $.extend(options,settings); 
			}
			
			$div.dialog(options);
           
		}
		
		function saveLeave(url){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the Leave data
						
					} else {
						tAlert('信息','保存失败')
					}
				}
			});
		}
		
	    function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
		
		function getLeaveById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改用户':'查看用户';
		         loadLeave(strinfo,'buse/loadLeaveById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function subInput(leaveId)
		{
		    $('<div id="dlg2" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px" closed="true">').dialog({
	                title: "选择步骤提交",
					modal: true,
					shadow: false,
					closed: false,
					href:'buse/submitInput.action?type=submit&leaveId='+leaveId,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg2').dialog('destroy')
					},
					buttons:[{
							text:'提交',
							iconCls:'icon-ok',
							handler:function(){
								save('buse/submit.action',leaveId);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg2').dialog('close');
							}
						}]
	         }
		   
		   );
		}
		
		function save(url,id)
		{
		
		  // var input = $("input:radio:checked");
		 
		   var rad = $("input[name='transitionName']:checked").val();
		   
		   $.post(url,{transistionName:rad,leaveId:id},function(result){
							if (result.success){
							    tAlert('信息','操作成功');
							    $('#dlg2').dialog('close');
								$('#tt').datagrid('reload');	// reload the Leave data
							} else {
								tAlert('信息','删除失败');
							}
			},'json');
		}
		
		function getLeaveById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改请假申请':'查看请假申请'
	         loadLeave(strinfo,'buse/loadLeaveById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteLeave(id){
		
		    $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('buse/deleteLeave.action',{idstr:id},function(result){
							if (result.success){
							    tAlert('信息','操作成功');
								$('#tt').datagrid('reload');	// reload the Leave data
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
			});
		}
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		
		    var query={title:$('#titleid').val()}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
	
		
	</script>
</head>
<body>


		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			标题: <input type="text" name="title" id="titleid">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadLeave('请假申请','buse/addLeave.action','add')">请假申请</a>
			<!--  
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getLeaveById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getLeaveById('view')">查看</a>
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteLeave()">删除</a>
			-->
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>