<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>

	<script type="text/javascript">
		
	 $(function(){
	    $("tr:odd").addClass("a1");
	 })
	 
	</script>


			<table width="100%" id="mytab" border="1" class="t1">
			   <tr>
					<td nowrap="nowrap" width="100">
						标题:
					</td>
					<td>
					   <s:property value="leaveinfo.title"/>
					</td>
					
				</tr>
				<tr>
					<td nowrap="nowrap" width="100">
						请假类别:
					</td>
					<td>
					
					     <s:iterator value="listDictBuss" var="x">
								<s:if test="#x.dictId == leaveinfo.leaveType">
								  <s:property value="#x.dictName"/> 
								</s:if>
						 </s:iterator>
						 <s:if test="leaveinfo.leaveType==10000">
								异常打卡
						</s:if>
					</td>
					
				</tr>
				
				<tr>
				    <td nowrap="nowrap">
						请假时间:
					</td>
					<td>
					    <s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.startTime"/>
					     至<s:date format="yyyy-MM-dd HH:mm:ss" name="leaveinfo.endTime"/>
					</td>
				</tr>
				
				<tr>
				    <td nowrap="nowrap">
						请假事由:
					</td>
					<td>
					    <s:property value="leaveinfo.description"/>
					</td>
				</tr>
			</table>

