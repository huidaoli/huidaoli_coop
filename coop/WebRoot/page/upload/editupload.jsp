<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="100%" id="mytab11" border="1" class="t1">
<tr>
			<td  width="150">
				<a style="text-align: left">附件信息</a>
			</td>
			<td  width="50">
				删除
			</td>
</tr>
       <s:iterator value="#request.resutl" var="x">
		
       <tr>
			<td>
				<a href='../upload/downLoadAtta.action?atta=<s:property value="#x.newname" escape="false"/>'><s:property value="#x.attaname" escape="false"/></a>
			</td>
			
			<td>
				<img src='../themes/icons/action_delete.png' title='删除' style='cursor:pointer' onclick="deleAtta('<s:property value="#x.attaid"/>')" />
			</td>
       </tr>
	</s:iterator>
		
</table>