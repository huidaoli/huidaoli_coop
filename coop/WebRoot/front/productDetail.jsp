<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!--============================================= BEGIN STYLES ==-->
<link rel="stylesheet" href="front/css/framework-min.css" />
<link rel="stylesheet" href="front/css/themes/skin.css" />
<!--[if IE 7]> <link rel="stylesheet" href="front/css/ie7.css" /> <![endif]-->
<!--[if IE 8]> <link rel="stylesheet" href="front/css/ie8.css" /> <![endif]-->

<!--============================================= BEGIN SCRIPTS ==-->
<script type="text/javascript" src="front/js/jquery.js"></script>
<!--JQuery Library-->
<script type="text/javascript" src="front/js/jquery.preloadify.js"></script>
<!--Preloadify-->
<script type="text/javascript" src="front/js/scripts-top.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function (){
	
	//点击小图切换大图
	$("#thumbnail li a").click(function(){
		$(".zoompic img").attr({ "src": $(this).attr("href"), "title": $("> img", this).attr("title") });
		$("#thumbnail li.current").removeClass("current");
		$(this).parents("li").addClass("current");
		return false;
	});
	$(".zoompic>img").load(function(){
		$(".zoompic>img:hidden").show();
	});
	
	//小图片左右滚动
	var $slider = $('.slider ul');
	var $slider_child_l = $('.slider ul li').length;
	var $slider_width = $('.slider ul li').width();
	$slider.width($slider_child_l * $slider_width);
	
	var slider_count = 0;
	
	if ($slider_child_l < 5) {
		$('#btn-right').css({cursor: 'auto'});
		$('#btn-right').removeClass("dasabled");
	}
	
	$('#btn-right').click(function() {
		if ($slider_child_l < 5 || slider_count >= $slider_child_l - 5) {
			return false;
		}
		
		slider_count++;
		$slider.animate({left: '-=' + $slider_width + 'px'}, 'fast');
		slider_pic();
	});
	
	$('#btn-left').click(function() {
		if (slider_count <= 0) {
			return false;
		}
		slider_count--;
		$slider.animate({left: '+=' + $slider_width + 'px'}, 'fast');
		slider_pic();
	});
	
	function slider_pic() {
		if (slider_count >= $slider_child_l - 5) {
			$('#btn-right').css({cursor: 'auto'});
			$('#btn-right').addClass("dasabled");
		}
		else if (slider_count > 0 && slider_count <= $slider_child_l - 5) {
			$('#btn-left').css({cursor: 'pointer'});
			$('#btn-left').removeClass("dasabled");
			$('#btn-right').css({cursor: 'pointer'});
			$('#btn-right').removeClass("dasabled");
		}
		else if (slider_count <= 0) {
			$('#btn-left').css({cursor: 'auto'});
			$('#btn-left').addClass("dasabled");
		}
	}
	
});
/**
$(document).ready(function() {
		$(".tab_content").hide();
		$("ul.tabs li:first").addClass("active").show();
		$(".tab_content:first").show();
		$("ul.tabs li").click(function() {
					$("ul.tabs li").removeClass("active");
					$(this).addClass("active");
					$(".tab_content").hide();
					var activeTab = $(this).find("a").attr("href");
					$(activeTab).fadeIn();
					return false
				})
});**/
$(document).ready(function () {
    //$(".accordion_container").get(0).show();
	$(".accordion_button").click(function () {
		$(".accordion_button").removeClass("acdn_on");
		$(".accordion_container").slideUp("fast");
		if ($(this).next().is(":hidden") == true) {
			$(this).addClass("acdn_on");
			$(this).next().slideDown("fast");
			$(".accordion_button span").addClass("minus");
		}
	});
	$(".accordion_button").mouseover(function () {
		$(this).addClass("acdn_over");
	}).mouseout(function () {
		$(this).removeClass("acdn_over");
	});
	$(".accordion_container").hide();
});


</script>

<style type="text/css">
ul,ol {
	margin: 0 0 0 0;
	padding-left: 0;
}

*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif,"宋体";}
/* zoombox */
.zoombox{width:686px;margin:20px auto 0 auto;}
.zoompic{border:solid 1px #dfdfdf;width:684px;height:394px;}
.sliderbox{height:76px;overflow:hidden;margin:6px 0 0 0;}
.sliderbox .arrow-btn{width:38px;height:76px;background:url(front/images/arrow-btn.png) no-repeat;cursor:pointer;}
.sliderbox #btn-left{float:left;background-position:0 0;}
.sliderbox #btn-left.dasabled{background-position:0 -76px;}
.sliderbox #btn-right{float:right;background-position:-38px 0;}
.sliderbox #btn-right.dasabled{background-position:-38px -76px;}
.sliderbox .slider{float:left;height:76px;width:605px;position:relative;overflow:hidden;margin:0 0 0 3px;display:inline;}
.sliderbox .slider ul{position:absolute;left:0;width:999em;}
.sliderbox .slider li{float:left;width:121px;height:76px;text-align:center;}
.sliderbox .slider li img{border:solid 1px #dfdfdf;}
.sliderbox .slider li.current img{border:solid 1px #F00;}
</style>
<body>

<div class="zoombox">

	<div class="zoompic"><img src="attach/productpic/${currproduct.path}" alt="${p.name}" onerror="javascript:this.src='attach/productpic/prdefault.jpg'"></div>
	
	<div class="sliderbox">
		<div id="btn-left" class="arrow-btn dasabled"></div>
		<div class="slider" id="thumbnail">
			<ul style="width: 847px; ">
			<s:iterator value="#request.list" var="x" status="y">
			   <s:if test="#y.index==0">
			       <li class="current">
				        <a href="attach/productpic/<s:property value="#x.path" escape="false"/>" target="_blank">
				        <img src="attach/productpic/<s:property value="#x.scaledpath" escape="false"/>" alt="${p.name}" onerror="javascript:this.src='attach/productpic/prdefault.jpg'">
				        </a>
			       </li>
			   </s:if>
			   <s:else>
			       <li>
				       <a href="attach/productpic/<s:property value="#x.path" escape="false"/>" target="_blank">
				       <img src="attach/productpic/<s:property value="#x.scaledpath" escape="false"/>" alt="${p.name}" onerror="javascript:this.src='attach/productpic/prdefault.jpg'">
				       </a>
			       </li>
			   </s:else>
			  
			</s:iterator>
			</ul>
		</div>
		<div id="btn-right" class="arrow-btn"></div>
	</div>
	
</div><!--slider end-->
<div class="zoombox">
    <!-- 
    <ul class="tabs">
			<li>
				<a href="#tab1">First tab</a>
			</li>
			<li>
				<a href="#tab2">Second tab</a>
			</li>
			<li>
				<a href="#tab3">Third tab</a>
			</li>
		</ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<p>
					11111
				</p>
			</div>
			<div id="tab2" class="tab_content">
				<p>
					222
				</p>
				<p>
					333
				</p>
			</div>
			<div id="tab3" class="tab_content">
				<p>
					444
				</p>
			</div>
		</div>
		<div class="clear"></div>
		 -->
<h1>产品参数</h1><hr />
	<div class="accordion_place">
		<div class="accordion_block">
			<div class="accordion_button">
				<div class="title">
					基本参数
				</div>
			</div>
			<div class="accordion_container">
				<div class="accordion_content">
					<p><strong>产品名:</strong>${p.name}</p>
					<p><strong>产地:</strong>${p.proarea}</p>
					<p><strong>重量:</strong>${p.weight}</p>
					<p><strong>市场价格:</strong>${p.markingprice}</p>
					<p><strong>平台价格:</strong>${p.ourprice}</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	
		<div class="accordion_block">
			<div class="accordion_button">
				<div class="title">
					规格信息
				</div>
			</div>
			<div class="accordion_container">
				<div class="accordion_content">
				  <strong>规格:</strong>${p.specinfo}
				</div>
			</div>
			<div class="clear"></div>
		</div>
	
		<div class="accordion_block">
			<div class="accordion_button">
				<div class="title">
					功效信息
				</div>
			</div>
			<div class="accordion_container">
				<div class="accordion_content">
					<strong>功效:</strong>${p.efficacyinfo}
				</div>
				
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="accordion_block">
			<div class="accordion_button">
				<div class="title">
					其他信息
				</div>
			</div>
			<div class="accordion_container">
				<div class="accordion_content">
					<strong>其他:</strong>${p.remark}
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<div style="text-align: center;">
<s:if test="#request.p.mallurl == null">
   <s:set var="url" value="'#'" />
   <s:set var="target" value="'_self'" />
</s:if>
<s:else>
   <s:set var="url" value="#request.p.mallurl" />
   <s:set var="target" value="'_blank'" />
</s:else>
<a class="smk_button" href="<s:property value="#request.url" />" target="<s:property value="#request.target" />">去商城购买</a>
</div>
</body>
</html>
