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
               <tr>
						<td nowrap="nowrap" width="100">
							退回修改
						</td>
						<td>
						    <input type="radio" name="transitionName" value="true" style="border:none" >
						</td>
			   </tr>
			    <tr>
						<td nowrap="nowrap" width="100">
							审核意见
						</td>
						<td>
						    <textarea  style="width:250px;height:40px;" id="comment_id" name="comment"></textarea>
						</td>
			   </tr>
</table>