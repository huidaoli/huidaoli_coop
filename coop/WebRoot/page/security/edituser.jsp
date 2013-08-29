<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="javascript">
    var opt = '${opt}';
    var arrIds = ${arrIds};
    var orgid = '<s:property value="user.orga.id"/>';
   
    $(function(){
       $('#cc').combotree({
				url:'contents/getOrgTreeData.action',
				required:true,
				width:200,
				onLoadSuccess:function()
				{
				  if(opt=='edit')
				  {
				     $('#cc').combotree('setValue', orgid);
				  }
				}
				
	   });
	   
	   $('#uu').combobox({
				url:'contents/getAllRole.action',
				valueField:'id',
				textField:'name',
				required:true,
				panelHeight:'auto',
				width:200,
				multiple:true,
				onLoadSuccess:function()
				{
				  if(opt=='edit')
				  {
				     $('#uu').combobox('setValues', arrIds);
				  }
				}
		});
		
		
		$("tr:odd").addClass("a1");
		
		
	
    });
</script>
<form id="fm" method="post">
    <input type="hidden" name="user.id" value="<s:property value="user.id" default="0"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="100">
				用户名:
			</td>
			<td>
			   <s:if test="#request.opt == 'add'">
			      <input name="user.username" type="text" class="easyui-validatebox" required="true" value="<s:property value="user.username"/>">
			   </s:if>
			   <s:if test="#request.opt == 'edit'">
			      <s:property value="user.username"/>
			      <input name="user.username" type="hidden" value="<s:property value="user.username"/>">
			   </s:if>
				
			</td>
			
		</tr>
		<s:if test="#request.opt == 'add'">
			<tr>
				<td nowrap="nowrap" width="100">
					密码:
				</td>
				<td>
					<input name="user.password" type="password" class="easyui-validatebox" required="true" value="<s:property value="user.password"/>">
				</td>
				
			</tr>
		</s:if>
		<tr>
			<td nowrap="nowrap" width="100">
				机构:
			</td>
			
			<td>
			    <select id="cc" name="user.orga.id"></select>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				角色:
			</td>
			
			<td>
			   	<input id="uu" name="role"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				姓名:
			</td>
			<td>
				<input name="user.realname" type="text" class="easyui-validatebox" required="true" value="<s:property value="user.realname"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				性别:
			</td>
			<td>
			    <s:select list="listDictBuss" headerKey="-1" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="user.sex"></s:select>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				手机:
			</td>
			<td>
				<input name="user.phone" type="text" class="easyui-numberbox" maxlength="11" required="true" value="<s:property value="user.phone"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				办公电话:
			</td>
			<td>
				<input name="user.officePhone" type="text" class="easyui-validatebox" required="true" value="<s:property value="user.officePhone"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				邮件:
			</td>
			<td>
				<input name="user.mail" type="text" class="easyui-validatebox" required="true" validType="email" value="<s:property value="user.mail"/>">
			</td>
			
		</tr>
		<tr>
		<td nowrap="nowrap">
				用户描述:
			</td>
			<td>
				<textarea name="user.description" style="width:200px;height:70px;"><s:property value="user.description"/></textarea>
			</td>
		</tr>
	</table>
</form>


	