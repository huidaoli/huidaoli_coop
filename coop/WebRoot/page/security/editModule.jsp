<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
 $(function(){
    $("tr:odd").addClass("a1");
 })
</script>
<form id="fm" method="post">
    <input type="hidden" name="module.id" value="<s:property value="module.id" default="0"/>"/>
    <input type="hidden" name="module.parent.id" id="parentid" value="<s:property value="module.parent.id"/>">
    <input type="hidden" name="module.orderNo"  value="<s:property value="module.orderNo"  default="1"/>"/>
	<table width="100%" id="mytab" border="1" class="t1">
	   
		<tr>
			<td nowrap="nowrap" width="100">
				模块名称:
			</td>
			<td>
				<input name="module.name" id="nameid" class="easyui-validatebox" required="true"  value="<s:property value="module.name"/>" />
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				类型:
			</td>
			<td>
				<s:if test="#request.opt == 'add'">
				    <s:radio list="listDictBuss" listKey="dictId" listValue="dictName" value="0" name="module.moduleType"></s:radio>
				</s:if>
				<s:else>
				    <s:radio list="listDictBuss" listKey="dictId" listValue="dictName"  name="module.moduleType"></s:radio>
				</s:else>
			  
			</td>
			
		</tr>
		<tr>
		<td nowrap="nowrap">
				模块代码:
			</td>
			<td>
				<input name="module.sn"  class="easyui-validatebox"  value="<s:property value="module.sn"/>"/>
			</td>
		</tr>
		<tr>
		<td nowrap="nowrap">
				模块URL:
			</td>
			<td>
				<input name="module.url"  class="easyui-validatebox"  value="<s:property value="module.url"/>" style="width:200px"/>
			</td>
		</tr>
	</table>
</form>

	