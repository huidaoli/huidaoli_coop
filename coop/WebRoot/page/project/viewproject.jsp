<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td  width="100">
				项目编号:
			</td>
			<td>
			   <s:property value="project.no"/>
			</td>
			<td >
				项目名称:
			</td>
			<td>
			   <s:property value="project.name"/>
			</td>
			
		</tr>
		<tr>
			<td >
				项目类别:
			</td>
			<td>
			   <s:iterator value="listDictBusstype" var="x">
					<s:if test="#x.dictId == project.type">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			<td >
				技术方向:
			</td>
			<td>
			    <s:iterator value="listDictBussitfx" var="x">
					<s:if test="#x.dictId == project.itfx">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td >
				应用行业:
			</td>
			<td>
			     <s:iterator value="listDictBussyyfx" var="x">
					<s:if test="#x.dictId == project.yyfx">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			<td >
				项目工期:
			</td>
			<td>
			  <s:property value="project.longday"/>
			</td>
			
		</tr>
		<tr>
		     <td >
				开始时间:
			</td>
			<td>
			    <s:date name="project.startTime" format="yyyy-MM-dd" />
			</td>
			 <td >
				结束时间:
			</td>
			<td>
			   <s:date name="project.endTime" format="yyyy-MM-dd" />
			</td>
		</tr>
		<tr>
			<td >
				团队人数:
			</td>
			<td>
			    <s:property value="project.groupper"/>
			</td>
			<td >
				项目规模:
			</td>
			<td>
			   <s:property value="project.ry"/>
			</td>
			
		</tr>
		<tr>
			<td >
				投资规模:
			</td>
			<td>
                  <s:property value="project.touzif"/>			
            </td>
			<td >
				发包方:
			</td>
			<td>
				<s:property value="project.fbf"/>
			</td>
			
		</tr>
		<tr>
			<td >
				承包方:
			</td>
			<td>
			   	<s:property value="project.cbf"/>
			</td>
			<td >
				项目经理:
			</td>
			<td>
				<s:property value="project.pm"/>
			</td>
			
		</tr>
		<tr>
			<td >
				附件:
			</td>
			<td colspan="3">
				  <img src='../themes/icons/view.gif' title='附件' style='cursor:pointer' onclick="getUploadView('<s:property value="project.contcode"/>','view')" />
			</td>
			
		</tr>
		
		<tr >
			<td>
				项目简介:
			</td>
			<td colspan="3">
			 
			  <div style="height:400px;">
			      <s:property value="project.desctio" escape="false"/>
			   </div>
			 </td>
			
		</tr>
	</table>
</form>
