<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="本草品味国际商务合作平台" />
<meta name="keywords" content="绿色食品,食品,药材,养生" />
<title>本草品味国际商务合作平台</title>
<link rel="icon" type="image/png" href="front/favicon.ico" />
<link rel="apple-touch-icon" href="front/favicon.ico" />

<!--============================================= BEGIN STYLES ==-->
<link rel="stylesheet" href="front/css/config.css" />
<link rel="stylesheet" href="front/css/themes/46.css" />
<!--[if IE 7]> <link rel="stylesheet" href="front/css/ie7.css" /> <![endif]-->
<!--[if IE 8]> <link rel="stylesheet" href="front/css/ie8.css" /> <![endif]-->

<!--============================================= BEGIN SCRIPTS ==-->
<script type="text/javascript" src="front/js/jquery.js"></script>
<!--JQuery Library-->
<script type="text/javascript" src="front/js/jquery.preloadify.js"></script>
<!--Preloadify-->
<script type="text/javascript" src="front/js/scripts-top.js"></script>
<!--General scripts header-->
<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
<!--[if IE]>
<script type="text/javascript" src="front/js/html5.js"></script>
<style type="text/css">.testimonial_arrow{display: none!important;}</style>
<![endif]-->

<style type="text/css">
ul,li {
	list-style-type: none;
}
/* scrollDiv */
.scrollDiv {
	height: 35px; /* 必要元素 */
	line-height: 35px;
	border: #ccc 1px solid;
	overflow: hidden; /* 必要元素 */
}

.scrollDiv li {
	height: 25px;
	padding-left: 10px;
}

#s2,#s3 {
	height: 100px;
}
</style>
<script type="text/javascript">
$(function(){
     $('#product').load("toProduct.html?sear=&page=1");
     if ( $.browser.msie ){
          if($.browser.version=='8.0' || $.browser.version=='7.0' || $.browser.version=='6.0')
          {
             alert('使用IE8.0以上版本,效果更佳!其他集成厂商浏览器请不要选择兼容模式');
          }
     }
})

function searchkey()
{
   var sear = $.trim($('#s').val());
   $("#portfolio_menu a").removeClass("active_cat");
   $('#product').load("toProduct.html?sear="+sear+"&page=1");
}

function internation()
{

}

function tologin()
{
    $.lightbox($("<div id='tologin'/>").load("toLogin.html"), {
	    width   : 400,
	    height  : 260
   });
}

function showMessage(id,type)
{
	
   $.lightbox($("<div/>").load("queryInfoById.action?id="+id+"&type="+type), {
	    width   : 640,
	    height  : 360
   });
	  
}

function logout() {
	$.post('logout.action', function(data) {
				//var result = eval('(' + data + ')');
				if(data.success){
				   //alert('');
				   $('#horizontal').load("refreshLoginInfo.action");
				}
			},'json');

}

</script>
</head>
<body>



	<div id="smk_container_full">
		<div class="smk_container">
			<div class="wrap">
				<div class="top_head_separator">
					<!--============================================================= BEGIN top blocks -->
					<div class="container_12">
						<div class="grid_4 logo">
							<a href="index.html"><img src="front/images/logo.png"
								alt="Logo" />
							</a>
						</div>
						<div class="grid_8 top_mod_right">

							<!--================== BEGIN main menu -->
							<nav id="horizontal" style="z-index:99999">
								<%@include file="loginhtml.jsp"%>
							</nav>
							<!-- End of menu nav#horizontal -->
							<div class="clear"></div>
							<!--/================= END main menu -->
						</div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- End of .top_head_separator -->
				<div class="clear"></div>
				<!--/============================================================= END top blocks -->
				<!-- =============== HEADER [end] ================ -->

				<!--============================================================== BEGIN content [ .smk_content ] -->
				<div class="clear"></div>
				<div class="header">
				
                    <%@include file="top1.jsp"%>
                    <%@include file="top2.jsp"%>

				</div>
				<div class="clear"></div>

				<div id="smk_content" class="smk_content">
					<div class="container_12">


						<%@include file="notice.jsp"%>

						<%@include file="news.jsp"%>
						
						
						
						<div class="page_top_details">


							<div style="text-align:center;vertical-align:middle">
								<input type="text" class="field" name="s" id="s" style="width:250px;" />
								<a class="smk_button" href="javascript:void(0)" onclick="searchkey();">搜索</a>
							</div>

						</div>
						
						
						<div id="smk_content" class="smk_content">
							<div class="container_12 clearfix">

								<ul id="portfolio_menu" class="filter">
									<span class="portfolio_menu_title">产品热词:</span>
									<s:iterator value="hotword" var="x">
										<li><a href="#" data-filter="*"><s:property value="#x.dictName" escape="false" /></a>
										</li>
			                        </s:iterator>
									
								</ul>
								<div class="clear"></div>
								
                                <div id="product"></div>

							</div>
							<div class="clear"></div>
						</div>

						<div class="clear"></div>

						<hr />
						<ul class="tabs">
						  <s:iterator value="#request.listDictCoop" var="x">
							<li><a href="showtabs.html?type=<s:property value="#x.dictId"/>"><s:property value="#x.dictName"/></a></li>
						  </s:iterator>
							
						</ul>
						<div class="tab_container">
							<div id="tab1" class="tab_content">
								
							</div>
						</div>
						<div class="clear"></div>
						<%@include file="link1.jsp"%>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			<%@include file="bottom.jsp"%>
			<div class="clear"></div>
		</div>
	</div>
	<script type="text/javascript" src="front/js/iview.js"></script>
	<script type="text/javascript" src="front/js/raphael-min.js"></script>
	<script type="text/javascript" src="front/js/jquery.plugins-min.js"></script>
	<script type="text/javascript" src="front/js/smk-framework-min.js"></script>
	<script type="text/javascript" src="front/js/scripts-bottom-min.js"></script>
</body>
</html>