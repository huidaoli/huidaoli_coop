<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="home_notice">
	<div class="scrollDiv" id="s1">
		<ul>
		    <s:iterator value="#request.guandList" var="x">
			<li>
				<a href="javascript:void('0');" onclick="showMessage('<s:property value="#x.id" escape="false"/>','2');">
				<s:property value="#x.name" escape="false" />
				</a>
			</li>
			</s:iterator>
		</ul>
	</div>
	<!--scrollDiv end-->
	<script type="text/javascript">
		function AutoScroll(obj){
			$(obj).find("ul:first").animate({
				marginTop:"-25px"
			},500,function(){
				$(this).css({marginTop:"0px"}).find("li:first").appendTo(this);
			});
		}
		$(document).ready(function(){
			setInterval('AutoScroll("#s1")',3000);
		});
	</script>

</div>
