<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>


<table width="100%" id="mytab" border="1" class="t1">
                  <tr>
						<td>
						   审批人
						</td>
						<td>
						   审批时间
						</td>
						<td>
						   审批结果
						</td>
						<td>
						   审批意见
						</td>
					</tr>
			  <s:iterator value="#request.historys" var="x">
	               <tr>
						<td>
							<s:property value="#x.approver.realname"/>
						</td>
						<td>
						    <s:date name="#x.approveTime"/>
						</td>
						<td>
						    <s:property value="#x.aggType"/>
						</td>
						<td>
						    <s:property value="#x.mess"/>
						</td>
					</tr>
               </s:iterator>
               
</table>
