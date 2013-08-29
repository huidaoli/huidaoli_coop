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
    <input type="hidden" name="bgImg.id" value="<s:property value="bgImg.id" default="0"/>" />
    <input type="hidden" name="bgImg.type" value="<s:property value="bgImg.type"/>" />
    <input type="hidden" name="bgImg.newname" value="<s:property value="bgImg.newname"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="50">
				图片名称:
			</td>
			<td>
			   <input name="bgImg.name" style="width:220px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="bgImg.name"/>">
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<input name="bgImg.createDate" type="text" class="easyui-datebox" required="required" value="<s:date name="bgImg.createDate" format="yyyy-MM-dd" />">
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
		<s:if test="bgImg.newname !=null">
		<tr>
			<td nowrap="nowrap">
				图片:
			</td>
			<td>
			<div style="width:600px; overflow: auto;">
				<img src="../attach/file/<s:property value="bgImg.newname"/>?timer=<%=new java.util.Date().getTime()%>">
		    </div>
			</td>
			
		</tr>
		</s:if>
	   <tr>
	         <td nowrap="nowrap" width="50">
				备注:
			</td>
			<td>
			   <textarea style="width:250px;height:100px;" name="bgImg.descri"><s:property value="bgImg.descri"/></textarea>
			</td>
	   </tr>
		
	</table>
</form>

