<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
    var opt = '${opt}';
</script>
<form id="fm" method="post">
    <input type="hidden" name="openClass.id" value="<s:property value="openClass.id" default="0"/>" />
    <input type="hidden" id="contcodeid" name="openClass.contcode" value="<s:property value="openClass.contcode"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="50">
				开班名称:
			</td>
			<td>
			   <input name="openClass.name" type="text" class="easyui-validatebox" required="true" value="<s:property value="openClass.name"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				方向:
			</td>
			<td>
			    <s:select list="listDictBuss" headerKey="" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="openClass.classType" id="typeid"></s:select>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				开班日期:
			</td>
			<td>
				<input name="openClass.createDate" type="text" class="easyui-datebox" required="required" value="<s:date name="openClass.createDate" format="yyyy-MM-dd" />">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				班级人数:
			</td>
			<td>
				<input name="openClass.sumnum" type="text" class="easyui-numberbox" maxlength="3" required="true" value="<s:property value="openClass.sumnum"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				附件:
			</td>
			<td>
				<img src='../themes/icons/view.gif' title='附件' style='cursor:pointer'onclick="getUpload()" />
			</td>
			
		</tr>
		
		<tr>
			<td nowrap="nowrap" style="height:400px;">
				内容:
			</td>
			<td>
			<FCK:editor instanceName="openClass.content" height="400">
				<jsp:attribute name="value">
				<s:property value="openClass.content" escape="false"/>
				</jsp:attribute>
			</FCK:editor>
			
			</td>
			
		</tr>
	</table>
</form>
<script language="javascript">
    $('#typeid').validatebox({
        required: true
    });
</script>


	