<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="100%" id="mytab11" border="1" class="t1">
<tr>
			<td  width="50">
				<a style="text-align: left">附件信息</a>
			</td>
</tr>
       <s:iterator value="#request.resutl" var="x">
		
       <tr>
			<td>
			    <s:if test="#request.coop == null">
			       <a href='../upload/downLoadAtta.action?atta=<s:property value="#x.newname" escape="false"/>'><s:property value="#x.attaname" escape="false"/></a>
			    </s:if>
			    <s:else>
			        <a href='downLoadAtta.action?atta=<s:property value="#x.newname" escape="false"/>'><s:property value="#x.attaname" escape="false"/></a>
			    </s:else>
			</td>
       </tr>
	</s:iterator>
		
</table>