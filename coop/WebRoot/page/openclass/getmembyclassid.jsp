<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr style="background-color: rgb(224,236,255)">
		    <td>
				序号
			</td>
			<td>
				用户名
			</td>
			<td>
				姓名	
			</td>
			<td>
				电话	
			</td>
			<td>
				手机	
			</td>
			<td>
				院校
			</td>
			<td>
				专业	
			</td>
			<td>
				学历	
			</td>
			<td>
				状态
			</td>
			<td>
				操作
			</td>
			
		</tr>
		  <s:iterator value="#request.list" var="x" status="xx">
		  <tr>
		    <td>
				<s:property value="#xx.index+1"/> 
			</td>
             <td>
				<s:property value="#x.userName" escape="false"/> 
			</td>
			<td>
			    <s:property value="#x.realName" escape="false"/> 
			</td>
			<td>
			    <s:property value="#x.phone" escape="false"/> 
			</td>
			<td>
			    <s:property value="#x.mphone" escape="false"/> 
			</td>
			<td>
				<s:property value="#x.xuyu" escape="false"/> 
			</td>
			<td>
				<s:property value="#x.zy" escape="false"/> 
			</td>
			<td>
				 <s:iterator value="listDictBussxu" var="y">
					<s:if test="#y.dictId == #x.xuel">
					  <s:property value="#y.dictName"/> 
					</s:if>
		           </s:iterator>
			</td>
			<td>
				 <s:if test="#x.state==0">审核中</s:if>
		         <s:if test="#x.state==1"><font style="font-weight: bold;color: green;">通过</font></s:if>
		         <s:if test="#x.state==2"><font style="font-weight: bold;color: red">不通过</font></s:if>
			</td>
			<td>
			<c:if test="${sys:hasPermission(703,sessionScope.aclMap)}">
				 <span style="padding-right:10px;cursor:pointer;"><img src='../themes/icons/action_check.png' title="审核通过" onclick="openUmheckDio('ok','<s:property value="#x.id" escape="false"/>','${classid}')"/></span>
			</c:if>
			<c:if test="${sys:hasPermission(704,sessionScope.aclMap)}">
				 <span style="padding-right:10px;cursor:pointer;"><img src='../themes/icons/action_delete.png' title="审核不通过" onclick="openUmheckDio('no','<s:property value="#x.id" escape="false"/>','${classid}')"/></span>
			</c:if>
			</td>
			
			</tr>
	            </s:iterator>     
	</table>
</form>
