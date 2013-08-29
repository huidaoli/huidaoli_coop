<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<style>
.newTit {font:26px '微软雅黑';padding-bottom:10px;color:#000;text-align:center;}
.newSub {color:#aaa;font-size:13px;text-align:center;border-bottom:1px dashed #ccc;padding:10px;}
.newMain p {text-indent:2em;font-size:12px;padding-bottom:10px;}
</style>
<div>
	<div class="newTit">
		${resMap.name}
	</div>
	<div class="newSub">
		<s:date name="#request.resMap.createDate" format="yyyy-MM-dd" />
	</div>
	<div class="newMain">
		<s:if test="#request.resMap.attalist.size()!=0">
         附件下载<br>
			<s:iterator value="#request.resMap.attalist" var="x">
				<a
					href="<%=path%>/downAtta.action?atta=<s:property value="#x.newname"/>"><s:property
						value="#x.attaname" />
				</a>
				<br>
			</s:iterator>
		</s:if>
		<br>
		<br>
		${divs}
		<br>
		<br>

		${resMap.content}
	</div>
</div>


</div>