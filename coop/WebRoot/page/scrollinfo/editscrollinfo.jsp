<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
    var opt = '${opt}';
</script>
<form id="fm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="scrollinfo.id" value="<s:property value="scrollinfo.id" default="0"/>" />
    <input type="hidden" name="scrollinfo.ctype" value="<s:property value="scrollinfo.ctype"/>" />
    <input type="hidden" id="contcodeid" name="scrollinfo.contcode" value="<s:property value="scrollinfo.contcode"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="50">
				图片名称:
			</td>
			<td>
			   <input name="scrollinfo.name" style="width:220px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="scrollinfo.name"/>">
			</td>
			
		</tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<input name="scrollinfo.createDate" type="text" class="easyui-datebox" required="required" value="<s:date name="scrollinfo.createDate" format="yyyy-MM-dd" />">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				图片:
			</td>
			<td>
				<input type="file" name="attafile" class="easyui-validatebox" required="true">
			</td>
			
		</tr>
		
	</table>
</form>
