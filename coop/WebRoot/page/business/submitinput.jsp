<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<table width="100%" id="mytab" border="1" class="t1">
			  <s:iterator value="#request.lists" var="x">

               <tr>
					<td nowrap="nowrap" width="100">
						<s:property value="#x"/>
					</td>
					<td>
					    <input type="radio" name="transitionName" value="<s:property value="#x"/>" style="border:none">
					</td>
					
				</tr>
		
</s:iterator>
</table>