<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
			<tr>
			<td nowrap="nowrap" width="50">
				图片名称:
			</td>
			<td>
			   <s:property value="bgImg.name"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
			 <s:date name="bgImg.createDate" format="yyyy-MM-dd" />
			</td>
			
		</tr>
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
		
		<tr>
			<td>
				备注:
			</td>
			<td>
			   <s:property value="bgImg.descri"/>
			
			</td>
			
		</tr>
	</table>
</form>
