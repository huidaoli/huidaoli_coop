<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#request.value==3">
  <div class="block_home_slider">
	<div id="home_slider" class="flexslider">
		<ul class="slides">
			<s:iterator value="#request.list2" var="x" status="y">
				<li>
					<div class="slide">
						<img
							src="attach/file/<s:property value="#x.newname" escape="false"/>"
							alt="" />
						<div class="caption">
							<p class="title">
								<s:property value="#x.name" escape="false" />
							</p>
							<p>
								<s:property value="#x.descri" escape="false" />
							</p>
						</div>
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
</div>
<div class="clear"></div>
<script type="text/javascript">
	$(function () {
		$('#home_slider').flexslider({
			animation : 'slide',
			controlNav : true,
			directionNav : true,
			animationLoop : true,
			slideshow : true,
			slideshowSpeed:3000,
			useCSS : false
		});
		
 	});
 </script>
</s:if>