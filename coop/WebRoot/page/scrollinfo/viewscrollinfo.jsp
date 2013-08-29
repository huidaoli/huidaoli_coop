<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
			<tr>
			<td nowrap="nowrap" width="50">
				资源名称:
			</td>
			<td>
			   <s:property value="scrollinfo.name"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<s:date name="scrollinfo.createDate" format="yyyy-MM-dd" />
			</td>
			
		</tr>
		
		<tr>
			<td nowrap="nowrap">
				图片:
			</td>
			<td>
			 <img src="../attach/file/<s:property value="scrollinfo.imgid"/>">
			</td>
			
		</tr>
		 
		
	</table>
</form>
