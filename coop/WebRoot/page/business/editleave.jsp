<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>

	<script type="text/javascript">
		
	 $(function(){
	    $("tr:odd").addClass("a1");
	 })
	 
	</script>

<form id="fm" method="post">
		    <input type="hidden" name="workflowId" id="workflowId" value="${workflowId}">
			<input type="hidden" name="leaveinfo.id" value="<s:property value="leaveinfo.id" default="0"/>" />
			<table width="100%" id="mytab" border="1" class="t1">
			   <tr>
					<td nowrap="nowrap" width="100">
						标题:
					</td>
					<td>
					    <input type="text" name="leaveinfo.title" value="<s:property value="leaveinfo.title"/>"  class="easyui-validatebox" required="true" >
					</td>
					
				</tr>
				<tr>
					<td nowrap="nowrap" width="100">
						请假类别:
					</td>
					<td>
					    <s:select list="listDictBuss" headerKey="-1" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="leaveinfo.leaveType"></s:select>
					</td>
					
				</tr>
				
				<tr>
				    <td nowrap="nowrap">
						请假时间:
					</td>
					<td>
					    <input class="easyui-datetimebox" name="leaveinfo.startTime" required="true" style="width:150px" value="<s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.startTime"/>">
					     至<input class="easyui-datetimebox" name="leaveinfo.endTime" required="true" style="width:150px" value="<s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.endTime"/>">
					</td>
				</tr>
				
				<tr>
				    <td nowrap="nowrap">
						请假天数:
					</td>
					<td>
					    <input class="easyui-validatebox" name="leaveinfo.days" required="true" style="width:150px" value="<s:property value="leaveinfo.days"/>">
					</td>
				</tr>
				
				<tr>
				    <td nowrap="nowrap">
						请假事由:
					</td>
					<td>
						<textarea name="leaveinfo.description" style="width:300px;height:70px;"><s:property value="leaveinfo.description"/></textarea>
					</td>
				</tr>
			</table>
			
	
</form> 
	
