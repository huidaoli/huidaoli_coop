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
			<input type="hidden" name="leaveinfo.leaveType" value="10000" />
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
				    <td nowrap="nowrap">
						异常打卡时间:
					</td>
					<td>
					    
					    <div>
					        上午<input class="easyui-datetimebox" name="leaveinfo.startTime" style="width:150px" value="<s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.startTime"/>">
					    </div>
					    <div style="padding-top:5px;">
					        下午<input class="easyui-datetimebox" name="leaveinfo.endTime" style="width:150px" value="<s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.endTime"/>">
					    </div>
					    
					</td>
				</tr>
				
								
				<tr>
				    <td nowrap="nowrap">
						异常打卡原因:
					</td>
					<td>
						<textarea name="leaveinfo.description" style="width:300px;height:70px;"><s:property value="leaveinfo.description"/></textarea>
					</td>
				</tr>
			</table>
			
	
</form> 
	
