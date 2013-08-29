<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td width="80">
				开班名称:
			</td>
			<td>
			<s:property value="openClass.name"/>			
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				方向:
			</td>
			<td>
			
			      <s:iterator value="listDictBuss" var="x">
					<s:if test="#x.dictId == openClass.classType">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				班级人数:
			</td>
			<td>
			<s:property value="openClass.sumnum"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				附件:
			</td>
			<td>
			     
			    <img src='../themes/icons/view.gif' title='附件' style='cursor:pointer' onclick="getUploadView('<s:property value="openClass.contcode"/>','view')" />
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				开班日期:
			</td>
			<td>
				<s:date name="openClass.createDate" format="yyyy-MM-dd" />
			</td>
			
		</tr>
		
		<tr>
			<td>
				内容:
			</td>
			<td>
			   <div style="height:400px;">
			       <s:property value="openClass.content" escape="false"/>
			   </div>
			
			</td>
			
		</tr>
	</table>
</form>
