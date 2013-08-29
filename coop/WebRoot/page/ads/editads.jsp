<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
     var opt = '${opt}';
    if(opt=='add')
    {
      $('#sequ').val('');
    }
     
</script>
<form id="fm" method="post"  enctype="multipart/form-data">
    <input type="hidden" name="ads.id" value="<s:property value="ads.id" default="0"/>" />
    <input type="hidden" name="ads.type" value="<s:property value="ads.type"/>" />
    <input type="hidden" name="ads.newname" value="<s:property value="ads.newname"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="50">
				图片名称:
			</td>
			<td>
			   <input name="ads.name" style="width:220px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="ads.name"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="50">
				展示号:
			</td>
			<td>
			   <input id="sequ" name="ads.sequ" style="width:220px;" type="text" class="easyui-numberbox" maxlength="3" required="true" value="<s:property value="ads.sequ"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<input name="ads.createDate" type="text" class="easyui-datebox" required="required" value="<s:date name="ads.createDate" format="yyyy-MM-dd" />">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				上传图片:
			</td>
			<td>
			<s:if test="#request.opt=='add'">
			   <input type="file" name="img"  class="easyui-validatebox" required="required" >
			</s:if>
			<s:else>
			  <input type="file" name="img">
			</s:else>
				
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				链接地址:
			</td>
			<td>
				<input type="text" name="ads.url"  class="easyui-validatebox" required="required" value="<s:property value="ads.url"/>">
				<font color="red">暂无地址请用#</font>
			</td>
			
		</tr>
		<s:if test="ads.newname !=null">
		<tr>
			<td nowrap="nowrap">
				图片:
			</td>
			<td>
			<div style="width:600px; overflow: auto;">
				<img src="../attach/file/<s:property value="ads.newname"/>?timer=<%=new java.util.Date().getTime()%>">
		    </div>
			</td>
			
		</tr>
		</s:if>
	   <tr>
	         <td nowrap="nowrap" width="50">
				备注:
			</td>
			<td>
			   <textarea style="width:250px;height:100px;" name="ads.descri"><s:property value="ads.descri"/></textarea>
			</td>
	   </tr>
		
	</table>
</form>

