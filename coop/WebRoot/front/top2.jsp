<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#request.value==2">
	<div id="iview">
		<s:iterator value="#request.list2" var="x" status="y">
			<div
				data-iview:image="attach/file/<s:property value="#x.newname" escape="false"/>">
				<s:if test="#y.index==0">
					<s:set var="p1" value="20" />
					<s:set var="p2" value="200" />
					<s:set var="p3" value="80" />
					<s:set var="p4" value="250" />
				</s:if>
				<s:if test="#y.index==1">
					<s:set var="p1" value="60" />
					<s:set var="p2" value="200" />
					<s:set var="p3" value="140" />
					<s:set var="p4" value="250" />
				</s:if>
				<s:if test="#y.index==2">
					<s:set var="p1" value="50" />
					<s:set var="p2" value="30" />
					<s:set var="p3" value="100" />
					<s:set var="p4" value="80" />
				</s:if>
				<s:if test="#y.index==3">
					<s:set var="p1" value="80" />
					<s:set var="p2" value="200" />
					<s:set var="p3" value="80" />
					<s:set var="p4" value="250" />
				</s:if>
				<div class="iview-caption caption-default"
					data-x="<s:property value="#p1"/>"
					data-y="<s:property value="#p2"/>" data-transition="expandDown">
					<s:property value="#x.name" escape="false" />
				</div>
				<div class="iview-caption caption-cyan"
					data-x="<s:property value="#p3"/>"
					data-y="<s:property value="#p4"/>" data-transition="expandUp">
					<s:property value="#x.descri" escape="false" />
				</div>
			</div>
		</s:iterator>
	</div>
	<div class="clear"></div>
</s:if>