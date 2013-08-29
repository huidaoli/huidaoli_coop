<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="javascript">
    var opt = '${opt}';
    var arrIds = ${arrIds};
    var orgid = '<s:property value="user.orga.id"/>';
    /**
    $(function(){
       $('#cc').tree({
				url:'contents/getOrgTreeData.action',
				
				onLoadSuccess:function()
				{
				  if(opt=='edit')
				  {
				     $('.tree-title').each(
					        function(){
							   if($(this).html()=='34')
							   {
							       $('#cc').tree('select',$(this).parent());
							   }
							}
					
					 )
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
		
	
    });
    **/
</script>
<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				用户名:
			</td>
			<td>
				<s:property value="user.username"/>
			</td>
			
		</tr>
		
		<tr>
			<td nowrap="nowrap" width="100">
				机构:
			</td>
			
			<td>
			   <s:property value="#request.orginfo.name"/>
			</td>
			
		</tr>
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				角色:
			</td>
			
			<td>
			   	<s:iterator value="#request.roles" var="x">
			   	    <s:property value="#x.name"/><br>
			   	</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				姓名:
			</td>
			<td>
				<s:property value="user.realname"/>
			</td>
			
		</tr>
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				性别:
			</td>
			<td>
			    <s:iterator value="listDictBuss" var="x">
					<s:if test="#x.dictId == user.sex">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				手机:
			</td>
			<td>
				<s:property value="user.phone"/>
			</td>
			
		</tr>
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				办公电话:
			</td>
			<td>
			<s:property value="user.officePhone"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				邮件:
			</td>
			<td>
				<s:property value="user.mail"/>
			</td>
			
		</tr>
		<tr  class="a1">
		<td nowrap="nowrap">
				用户描述:
			</td>
			<td>
				<s:property value="user.description"/>
			</td>
		</tr>
	</table>
</form>


	