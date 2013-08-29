<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
</script>
<form id="fm" method="post">
    <input type="hidden" name="role.id" value="<s:property value="role.id" default="0"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				角色名称:
			</td>
			<td>
				<input name="role.name" class="easyui-validatebox" required="true" value="<s:property value="role.name"/>">
			</td>
			
		</tr>
		<tr>
		<td nowrap="nowrap">
				角色描述:
			</td>
			<td>
				<textarea name="role.description" style="width:200px;height:70px;"><s:property value="role.description"/></textarea>
			</td>
		</tr>
	</table>
</form>

	