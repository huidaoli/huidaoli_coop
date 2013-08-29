<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<form id="fm" method="post">
    <input type="hidden" name="org.id" value="<s:property value="org.id" default="0"/>"/>
    <input type="hidden" name="org.parent.id" id="parentid" value="<s:property value="org.parent.id"/>">
	<table width="100%" id="mytab" border="1" class="t1">
	   
		<tr class="a1">
			<td nowrap="nowrap" width="100">
				机构名称:
			</td>
			<td>
				<input name="org.name" class="easyui-validatebox" id="nameid" required="true"  value="<s:property value="org.name"/>">
			</td>
			
		</tr>
		<tr>
		<td nowrap="nowrap">
				机构备注:
			</td>
			<td>
				<textarea name="org.description" style="width:200px;height:70px;"><s:property value="org.description"/></textarea>
			</td>
		</tr>
	</table>
</form>

	