<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
    var opt = '${opt}';
</script>
<form id="fm" method="post">
    <input type="hidden" name="information.id" value="<s:property value="information.id" default="0"/>" />
    <input type="hidden" name="information.ctype" value="<s:property value="information.ctype"/>" />
    <input type="hidden" id="contcodeid" name="information.contcode" value="<s:property value="information.contcode"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="50">
				资讯:
			</td>
			<td>
			   <input name="information.name" style="width:220px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="information.name"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				分类:
			</td>
			<td>
			    <s:select list="listDictBuss" headerKey="" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="information.type" id="typeid"></s:select>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<input name="information.createDate" type="text" class="easyui-datebox" required="required" value="<s:date name="information.createDate" format="yyyy-MM-dd" />">
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
			<FCK:editor instanceName="information.content" height="400">
				<jsp:attribute name="value">
				<s:property value="information.content" escape="false"/>
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
