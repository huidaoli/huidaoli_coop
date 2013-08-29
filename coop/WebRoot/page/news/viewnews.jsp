<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
			<tr>
			<td nowrap="nowrap" width="50">
				标题:
			</td>
			<td>
			   <s:property value="news.name"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				分类:
			</td>
			<td>
			 <s:iterator value="listDictBuss" var="x">
					<s:if test="#x.dictId == news.type">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				创建日期:
			</td>
			<td>
				<s:date name="news.createDate" format="yyyy-MM-dd" />
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				附件:
			</td>
			<td>
   <img src='../themes/icons/view.gif' title='附件' style='cursor:pointer'onclick="getUploadView('<s:property value="news.contcode"/>','view')" />
			</td>
			
		</tr>
		
		
		<tr>
			<td>
				内容:
			</td>
			<td>
			   <div style="height:400px;">
			       <s:property value="news.content" escape="false"/>
			   </div>
			
			</td>
			
		</tr>
	</table>
</form>
