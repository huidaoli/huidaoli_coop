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
<div style="height:500px;width:700px;overflow:auto;">
	<div class="newTit">
		${resMap.name}
	</div>
	<div class="newSub">
		<s:date name="#request.resMap.createDate" format="yyyy-MM-dd" />
	</div>
	<div class="newMain">
		<br>
		${divs}
		<br>
		${resMap.content}
	</div>
</div>
