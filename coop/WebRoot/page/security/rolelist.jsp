<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>角色</title>
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
				title:'角色',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'contents/getRoleAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'角色名称',field:'name',width:100},
					{title:'角色描述',field:'description',width:380},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return ""
							<c:if test="${sys:hasPermission(355,sessionScope.aclMap)}">
							   +"<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getRoleInfoById2(\"edit\","+rec.id+")'></span>"
							</c:if>
							<c:if test="${sys:hasPermission(356,sessionScope.aclMap)}">
							   +"<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getRoleInfoById2(\"view\","+rec.id+")' ></span>"
							</c:if>
							<c:if test="${sys:hasPermission(675,sessionScope.aclMap)}">
							    +"<span><img src='../themes/icons/user_info.gif'\ title='菜单授权' style='cursor:pointer'onclick='getModuleInfo("+rec.id+")' ></span>";
							</c:if>
							
							
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
		});
		
		
	    function getChecked(arrParids){
			var nodes = $('#tt2').tree('getChecked');
			
			if(nodes.length==0)
			{
			    return 0;
			}
			var ids = '';
			for(var i=0; i<nodes.length; i++)
			{
			
			    if(nodes[i].id==1)
			    {
			       continue;
			    }
				if (ids != '') 
				{
				    ids += ',';
				}
				
				getParentValue(nodes[i],arrParids);
				
				ids += nodes[i].id;
			}
			return ids;
		}
		
		
		/**
		 * 数组是否包含某个值
		 **/
		function containVal(arr,val)
		{
		     for(var i=0;i<arr.length;i++)
		     {
		          if(arr[i]==val)
		          {
		             return true;
		          }
		     }
		     return false;
		}
		
		/**
		 * 递归 取得partent的id值
		 **/
		function getParentValue(node,arrParids)
		{
		    var parent = $('#tt2').tree('getParent', node.target);
		  
		    if(parent!=null)
		    {
		         if(!containVal(arrParids,parent.id) && parent.id!=1)
		         {
		              arrParids.push(parent.id);
		         }
		         getParentValue(parent,arrParids);
		    }
		
		}
		
		/**
		 * 合并2个数组并去除重复值
		 **/
	   function mergeArray(arr,arr2)
	   {
	
		   for(var i=0;i<arr.length;i++)
		   {
				 for(var j=0;j<arr2.length;j++)
				 {
					if(arr[i] ==arr2[j])
					{
						 arr2.splice(j,1); 
					}
					
				 }
		   }
		   return arr.concat(arr2);
	   }
		
		
		function saveACL(id){
		   
		    var arrParids = [];
		
		    var r = getChecked(arrParids);
		    
		    if(r==0)
		    {
		         tAlert('信息','请选择');
		         return;
		    }
		    
	        var res = mergeArray(arrParids,eval('['+r+']'));
	        
	        res = '['+res+']'
	        
	        //alert(res);
	       
	           $.post('contents/saveACL.action',{ids:res,type:'Role',roleId:id},function(result){
						if (result.success){
							tAlert('信息','保存成功');
						} else {
							tAlert('信息','保存失败');
						}
		        },'json');
		        
		}
		
		function getModuleInfo(id)
		{
		    clearSelections();
		    var $div = $('<div id="dlg" class="easyui-dialog" style="width:500px;height:600px;padding:10px 20px" closed="true">');
			
			var options = {
	                title: '菜单授权',
					modal: true,
					shadow: false,
					href:'contents/getModuleInfoList.action?opt=selectModule&roleId='+id,
					closed: false,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy')
					},
					 buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveACL(id);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg').dialog('close');
							}
					}]
	         }
	         $div.dialog(options);
	         //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
	         //'contents/getModuleInfoList.action?opt=selectModule&roleId='+id,
	         //$div.dialog('refresh','contents/getModuleInfoList.action?opt=selectModule&roleId='+id);
		}
		
		
		function loadRoleInfo(tit,url,opt){
			
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true">');
			
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
								saveRole('contents/saveRole.action?opt='+opt);
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
		
		function saveRole(url){
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
						tAlert('信息','保存失败')
					}
				}
			});
		}
		
	    function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
		
		function getRoleInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改角色':'查看角色';
		         loadRoleInfo(strinfo,'contents/loadRoleInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getRoleInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改角色':'查看角色'
	         loadRoleInfo(strinfo,'contents/loadRoleInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteRole(){
		
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
						$.post('contents/deleteRoles.action',{ids:res},function(result){
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


		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<c:if test="${sys:hasPermission(358,sessionScope.aclMap)}">
			    角色名称: <input name="role.name" id="nameid">
			    <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			</c:if>
			<c:if test="${sys:hasPermission(354,sessionScope.aclMap)}">
			    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadRoleInfo('新增角色','contents/loadRole.action','add')">新增</a>
			</c:if>
			<c:if test="${sys:hasPermission(355,sessionScope.aclMap)}">
			    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getRoleInfoById('edit')">修改</a>
			</c:if>
			<c:if test="${sys:hasPermission(356,sessionScope.aclMap)}">
			    <a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getRoleInfoById('view')">查看</a>
			</c:if>
			<c:if test="${sys:hasPermission(357,sessionScope.aclMap)}">
			    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRole()">删除</a>
			</c:if>
			
			
			
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>