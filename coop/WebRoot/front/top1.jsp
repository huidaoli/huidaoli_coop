<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#request.value==1">
	<div id="onebyone_slider">
		<s:iterator value="#request.list1" var="x">
			<div class="oneByOne_item">
				<span class="ob1_title"><s:property value="#x.name"
						escape="false" />
				</span>
				<span class="ob1_description"> <s:property value="#x.descri"
						escape="false" /> </span>
				<img
					src="attach/file/<s:property value="#x.newname" escape="false"/>"
					class="ob1_img_device1"
					alt="<s:property value="#x.name" escape="false"/>" />
			</div>
		</s:iterator>
	</div>
	<div class="clear"></div>
</s:if>