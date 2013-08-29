<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				机构名称:
			</td>
			<td>
				<s:property value="role.name"/>
			</td>
			
		</tr>
		<tr>
		<td nowrap="nowrap">
				机构备注:
			</td>
			<td>
				<s:property value="role.description"/>
			</td>
		</tr>
	</table>
</form>

	