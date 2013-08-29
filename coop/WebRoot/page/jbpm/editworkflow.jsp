<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
 $(function(){
    $("tr:odd").addClass("a1");
 })
</script>
<form id="fm" method="post" enctype="multipart/form-data">
   <input type="hidden" name="workflow.id" value="<s:property value="workflow.id" default="0"/>"/>
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="100">
				流程名称:
			</td>
			<td>
				<input type="text" name="workflow.name" value="<s:property value="workflow.name"/>" class="easyui-validatebox" required="true" >
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				流程定义文件:
			</td>
			<td>
				<input type="file" name="processDefPath" class="easyui-validatebox" required="true">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				流程定义图片:
			</td>
			<td>
				<input type="file" name="processImagePath" class="easyui-validatebox" required="true">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				流程坐标文件:
			</td>
			<td>
				<input type="file" name="processDefCord" class="easyui-validatebox" required="true">
			</td>
			
		</tr>
	</table>
</form>

	