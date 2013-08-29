<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
	<script type="text/javascript">
	
	   function selectRow(id,val)
		{
		   $('#coopid').val(id);
		   $('#yifang').val(val);
		   $('#dlghzf').dialog('close');
		}
		
	   
		$(function(){
			$('#selett').datagrid({
				title:'合作伙伴信息',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'../member/getAjaxData.action?state=1',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',formatter:function(value,rec){
				             return "<input type='radio' name='ccc' onclick=\"selectRow('"+rec.id+"','"+rec.companyname+"')\">";
						}
					}
	                
	                
				]],
							
				columns:[[
				    {title:'注册手机',field:'userName',width:100},
				    {title:'姓名',field:'realName',width:100},
				    {title:'公司',field:'companyname',width:100},
				    {title:'创建日期',field:'createDate',width:100}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb223"
			});
			
			
		});
		
		
		function queryinfo2()
		{
		    var username = $('#userNameid').val();
		    var companyname = $('#companynameid').val();
		    var realname = $('#realNameid').val();
		    var state = '1';
		    var query={username:username,companyname:companyname,realname:realname,state:state}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#selett").datagrid('options').queryParams=query;
			
			//重新加载
			$("#selett").datagrid('load');
		}
		
		
	</script>
		<table id="selett"></table>
	<div id="tb223" style="padding:5px;height:auto"> 
		<div style="margin-bottom:5px">
			
			注册手机: <input name="member.userName" id="userNameid">   
			姓名: <input name="member.realName" id="realNameid">
			公司名称: <input name="member.companyname" id="companynameid">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo2()">查询</a>
			<br><br>
		</div>
	</div>
