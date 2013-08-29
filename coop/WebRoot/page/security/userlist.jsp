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
		
	<script>
		$(function(){
			$('#tt').datagrid({
				title:'用户',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'contents/getUserAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'用户名',field:'username',width:100},
				    {title:'姓名',field:'realname',width:100},
				    {title:'性别',field:'sex',width:100},
				    {title:'手机',field:'phone',width:100},
				    {title:'办公电话',field:'officePhone',width:100},
					{title:'邮件',field:'mail',width:100},
					{title:'创建时间',field:'createDate',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getUserInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getUserInfoById2(\"view\","+rec.id+")' ></span>"+
							       "<span><img src='../themes/icons/contact_blue_edit.png'\ title='密码重置' style='cursor:pointer'onclick='passDia("+rec.id+")' ></span>";
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			var options = {
	                title: '重置密码',
					modal: true,
					shadow: false,
					closed: true,
					maximizable:true,
					onClose:function(){
					     $('#respass').val('');
					     $('#mem_id').val('');
					    
					},
					  buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								savepass('contents/resetUserPass.action');
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#ttt').dialog('close');
							}
						}]
	         }
	         $('#ttt').dialog(options);
			
		});
		
	         
	    function passDia(id){
			clearSelections();
			$('#mem_id').val(id);
			$('#ttt').dialog('open');
		}
		
		function savepass(url,id){
		    //$('#mem_id').val(id);
			$('#fmpass').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
					    $('#ttt').dialog('close');
						tAlert('信息','保存成功');
					} else {
						tAlert('信息','保存失败')
					}
				}
			});
		}
		
		
		function loadUserInfo(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:500px;height:480px;padding:10px 20px" closed="true">');
			var options = {
	                title: tit,
					modal: true,
					shadow: false,
					href:url,
					closed: false,
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
								saveUser('contents/saveUser.action?opt='+opt);
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
			
			$div.dialog(options)
            //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
            //$div.dialog('refresh',url);
		}
		
		function saveUser(url){
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
						$('#tt').datagrid('reload');	// reload the user data
						
					} else {
					    if(result.mess==2)
					    {
					       tAlert('信息','用户名重复')
					    }
					    else
					    {
					       tAlert('信息','保存失败')
					     }
						
					}
				}
			});
		}
		
	    function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
		
		function getUserInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改用户':'查看用户';
		         loadUserInfo(strinfo,'contents/loadUserInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		function getUserInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改用户':'查看用户'
	         loadUserInfo(strinfo,'contents/loadUserInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteUser(){
		
		    var rows = $('#tt').datagrid('getSelections');
		     if(rows.length==0){
		          tAlert('信息','请选择数据');
		     }else{
		        
		        var idarr = [];
		        for(var i=0;i<rows.length;i++)
		        {
		             idarr.push(rows[i].id);
		        }
		        var res = '['+idarr.join(",")+']';
		        $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('contents/deleteUsers.action',{ids:res},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the user data
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
				});
		        
		     }
		}
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		
		    var query={name:$('#nameid').val()}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
	
		
	</script>
</head>
<body>
    <div id="ttt" data-options="iconCls:'icon-save'" style="padding:5px;width:400px;height:150px;margin-left:50px;">
		<form id="fmpass">
		新密码：<input type="text" id="respass" name="respass" class="easyui-validatebox" required="required"><br><br>
		<input type="hidden" name="id" id="mem_id"/>
	    </form>
	</div>

		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			用户名称: <input name="role.name" id="nameid">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadUserInfo('新增用户','contents/loadUser.action','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getUserInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getUserInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>