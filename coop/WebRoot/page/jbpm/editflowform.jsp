<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

	<script>
		$(function(){
			$('#tt2').datagrid({
				title:'表单定义',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'jbpm/getFlowformAjaxData.action?id=${id}', 
				fitColumns:true,
				singleSelect:true,
				columns:[[
				    {title:'标签',field:'fieldLabel',width:40},
				    {title:'名称',field:'fieldName',width:40},
				    {title:'类型',field:'fieldType',width:40},
				    {title:'输入形式',field:'fieldInput',width:40,
				        formatter:function(value,rec){
						    //alert(rec.id);
							return "<a href='javascript:createTable("+rec.id+")'>"+value+"</a>";
						}
				    },
					{field:'opt',title:'删除',width:30,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/edit_remove.png'\ title='删除' style='cursor:pointer;' onclick='remove("+rec.id+")'></span>";
						}
						
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb1"
			});
			
		});
		
		
		function add()
		{
		
		   $('<div id="dlg2" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px" closed="true">').dialog({
	                title: "输入表单域",
					modal: true,
					shadow: false,
					closed: false,
					href:'jbpm/formFieldInput.action?formId=<s:property value="flowForm.id"/>',
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg2').dialog('destroy')
					},
					buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								save('jbpm/addFormField.action');
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
		
		
		function save(url){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg2').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg2').dialog('close');
						$('#tt2').datagrid('reload');	
						
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
		
		
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		function remove(id){
		
		   $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('jbpm/deleteFlowform.action',{did:id},function(result){
							if (result.success){
								$('#tt2').datagrid('reload');	
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
		   });
		}


function createTable(id)
 {
       alert(id);
       $('<div id="dlg21" class="easyui-dialog" style="width:400px;height:400px;padding:10px 10px" closed="true">').dialog({
	                title: "键值",
					modal: true,
					shadow: false,
					closed: false,
					href:'jbpm/keyValue.action?formId=${formId}',
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg21').dialog('destroy')
					},
					buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveKv('jbpm/savaKeyValue.action');
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg21').dialog('close');
							}
						}]
	         }
		   
		   );
 }
		
	</script>


		<table id="tt2"></table>
	
<div id="tb1" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			表单模板: <input name="flowForm.template" id="workflowid" value="<s:property value="flowForm.template"/>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
		</div>
</div>


	