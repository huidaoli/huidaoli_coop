<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="portfolio">

	<s:iterator value="listProduct" var="x" >
	<!-- Portfolio item [begin] -->
	<div class="portf_item grid_3">
		<a href="javascript:void(0);" onclick="showProduct('<s:property value="#x.id"/>');"> 
		     <span class="image_wrap"> 
			     <span class="img_wrap_in"> 
			        <img src="attach/productpic/<s:property value="#x.typeimg" escape="false"/>" alt="" onerror="javascript:this.src='attach/productpic/prdefault.jpg'"/> 
			        <span class="img_caption_zoom"></span> 
			     </span> 
		     </span> 
		</a>
		<div class="clear"></div>
		<a onclick="showProduct(2);" style="cursor:pointer">
		   <div class="pf_item_description">
				<p><s:property value="#x.name" escape="false"/></p>
			<p><s:property value="#x.proarea" escape="false"/></p>
		   </div>
		</a>
	</div>
	<!-- Portfolio item [end] -->
	</s:iterator>

</div>
<!-- End of #portfolio -->
<div class="clear"></div>
<!-- ==== Pagination [begin] ==== -->
<div id="smk_pagination" class="all_transition_05">
	${pageHtml}
</div>
<div class="clear"></div>
<!-- ==== Pagination [end] ==== -->
<script>
$(function(){
	$("#portfolio").preloadify();
	$("a .image_wrap").hover(function () {
		$("img", this).animate({"opacity":"0.6"}, {queue:true, duration:500});
	}, function () {
		$("img", this).animate({"opacity":"1"}, {queue:true, duration:400});
	});
});

function showProduct(id)
{
   //var html = $("<div class='center'><h1>Wow! Amazing!</h1><p>Yes, now Lightbox Evolution supports DOM elements created on the fly.</p></div>");
  
   var html = $("<iframe  scrolling='auto' name='productdetail' id='productdetail' frameborder='0' src='toProductDetail.html?id="+id+"&time="+(new Date().getTime())+"' width='100%' height='100%'></iframe>");
   $.lightbox(html, {
	    width   : 710,
	    height  : 550
   });
	  
}
function goPage(pages)
{
   var sear = $.trim($('#s').val());
   $('#product').load("toProduct.html?sear="+sear+"&page="+pages);
}
</script>

