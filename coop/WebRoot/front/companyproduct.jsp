<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="#request.listnews" var="x" status="y">
	<div class="blog_item">
		<div class="date_comments">
			<span>[
					<s:iterator value="listDictBuss1" var="y">
						<s:if test="#y.dictId == #x.type">
							<s:property value="#y.dictName" />
						</s:if>
					</s:iterator>
					]</span>
			<span style="padding-left: 20px;">
			<a href="queryInfoById.action?id=<s:property value="#x.id"/>&amp;type=1&amp;flag=company&amp;ajax=true" rel="newsinfo[ajax]">
			<s:property value="#x.name" escape="false" />
			</a>
			</span>
			<span class="date"><s:date name="#x.createDate" format="yyyy-MM-dd" /></span>
		</div>
	</div>
</s:iterator>

<div class="pagination">
	${pageHtml}
</div>
<script>
$(function(){
     $("a[rel^='newsinfo']").prettyPhoto({
                 default_width:700,
		         default_height:500,
                 animation_speed:'fast',
                 slideshow:10000, 
                 theme : "pp_default",
                 hideflash: true
                 });
})
 
</script>
