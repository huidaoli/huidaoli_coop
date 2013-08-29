<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
	<title>模块管理</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/demo.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
	//contents/getOrgTreeData.action ../tree_data.json
		$(function(){
		    //var temp = 0;
		    $('#loading').html("<img src='../themes/icons/loading.gif'/>loading...");
			$('#tt2').tree({
				url: 'contents/getModuleTreeData.action',
				onClick:function(node){
					$(this).tree('toggle', node.target);
					//alert('you dbclick '+node.text);
				},
				onContextMenu: function(e, node){
					e.preventDefault();
					$('#tt2').tree('select', node.target);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				},
				onLoadSuccess:function()
				{
				   //if((temp++)==1){
				   $('#loading').remove();
				   //}
				}
			});
		});
		function reload(){
			var node = $('#tt2').tree('getSelected');
			if (node){
				$('#tt2').tree('reload', node.target);
			} else {
				$('#tt2').tree('reload');
			}
		}
		function getChildren(){
			var node = $('#tt2').tree('getSelected');
			if (node){
				var children = $('#tt2').tree('getChildren', node.target);
			} else {
				var children = $('#tt2').tree('getChildren');
			}
			var s = '';
			for(var i=0; i<children.length; i++){
				s += children[i].text + ',';
			}
			alert(s);
		}
		function getChecked(){
			var nodes = $('#tt2').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
			alert(s);
		}
		function getSelected(){
			var node = $('#tt2').tree('getSelected');
			alert(node.text);
		}
		function collapse(){
			var node = $('#tt2').tree('getSelected');
			$('#tt2').tree('collapse',node.target);
		}
		function expand(){
			var node = $('#tt2').tree('getSelected');
			$('#tt2').tree('expand',node.target);
		}
		function collapseAll(){
			var node = $('#tt2').tree('getSelected');
			if (node){
				$('#tt2').tree('collapseAll', node.target);
			} else {
				$('#tt2').tree('collapseAll');
			}
		}
		function expandAll(){
			var node = $('#tt2').tree('getSelected');
			if (node){
				$('#tt2').tree('expandAll', node.target);
			} else {
				$('#tt2').tree('expandAll');
			}
		}
		function editModuleInfo(url,opt){
			var node = $('#tt2').tree('getSelected');
			//alert(node.id);
			
			if(opt=='mod')
			{
			   url = url+"?id="+node.id;
			}
			
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:500px;height:280px;padding:10px 20px" closed="true">');
            $div.dialog({
            
                title: '新增模块',
				modal: true,
				shadow: false,
				closed: false,
				href:url,
				onClose:function(){
				    //close方法触发的onClose事件,去调用destory方法
				    $('#dlg').dialog('destroy')
				},
				onLoad:function(){
				    if(opt=='add'){
				      $('#parentid').val(node.id);
				    }
				  
				},
				
				buttons:[{
					text:'保存',
					iconCls:'icon-ok',
					handler:function(){
					    var name = $('#nameid').val();
						saveModule('contents/saveModule.action?opt='+opt,opt,name,node);
					}
				},{
					text:'关闭',
					handler:function(){
					    //调用dialog的close方法
					    $('#dlg').dialog('close');
					}
				}]
				
            
            });
		}
		
		
		function saveModule(url,opt,text,node){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.id){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						//$('#tt2').tree('reload');	// reload the user data
						if(opt=='add')
						{
						    
						    $('#tt2').tree('append', {
								parent: (node?node.target:null),
								data: [{
								    id:result.id,
									text: text
								}]
							});
							//$('#tree').tree('reload');
							
						}
						if(opt=='mod')
						{
						   //update(text);
						   node.text = text;
				           $('#tt2').tree('update', node);
						}
						
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
		
		function remove(){
			var node = $('#tt2').tree('getSelected');
			
			if(!isLeaf()){
			    tAlert('信息','含有子节点不能删除')
			}
			else
			{
			    $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('contents/deleModule.action',{id:node.id},function(result){
							if (result.success){
								//$('#tt2').tree('reload');// reload the user data
								$('#tt2').tree('remove', node.target);
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
				});
			}
		   
			
		}
		function update(){
			var node = $('#tt2').tree('getSelected');
			if (node){
				node.text = '<span style="font-weight:bold">new text</span>';
				node.iconCls = 'icon-save';
				$('#tt2').tree('update', node);
			}
		}
		
		function isLeaf(){
			var node = $('#tt2').tree('getSelected');
			var b = $('#tt2').tree('isLeaf', node.target);
			return b;
		}
		
		
	</script>
</head>
<body>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="editModuleInfo('contents/addModule.action','add')" iconCls="icon-add">新增</div>
		<div onclick="editModuleInfo('contents/modModule.action','mod')" iconCls="icon-edit">修改</div>
		<div onclick="remove()" iconCls="icon-remove">删除</div>
		<div class="menu-sep"></div>
		<div onclick="expandAll()">全部展开</div>
		<div onclick="collapseAll()">全部关闭</div>
	</div>
<fieldset style="">
				<legend>
					<s:text name="cms.module.info.me"/>
					
				</legend>
          <div id="loading"></div>
          
          <ul id="tt2"></ul>
     
	
</fieldset>
</body>
</html>