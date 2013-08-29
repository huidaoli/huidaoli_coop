<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="本草品味国际合作商务平台" />
<meta name="keywords" content="绿色食品,食品,药材,养生" />
<link rel="icon" type="image/png" href="front/favicon.ico" />
<link rel="apple-touch-icon" href="front/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

		<!--[if IE]>
	<script type="text/javascript" src="front/js/html5.js"></script>
	<style type="text/css">.testimonial_arrow{display: none!important;}</style>
	<![endif]-->
<title>本草品味国际商务合作平台</title>
		
		<script>
			$(function () {
				$("#portfolio_menu2 li").click(function () {
					$("#portfolio_menu2 li").removeClass("current-menu-item");
					$(this).addClass("current-menu-item");
					loadHTML($(this).text(),$(this).attr("id"));
					setText($(this).text())
					return false;
				});
				$("#portfolio_menu2 li").each(function (i) {
				    if($(this).find("a").text()=='${title}')
				    {
				        $(this).addClass("current-menu-item");
				    }
			    });
			    loadHTML('${title}','${id}');
			});
			
			function loadHTML(title,id)
			{
			    //$('#partmessage').html("<div style='text-align:center;height:800px;'><img src='front/images/loaders/8.gif'></div>");
                $('#partmessage').load("partmessage.html?title="+encodeURI(title)+"&id="+id);
			}
			function setText(title)
			{
			    $('#tit1').html(title);
                //$('#tit2').html(title);
			}
	  </script>
	</head>
	<body>



		<section id="smk_container_full">
		<section class="smk_container">
		<section class="wrap">
		<section class="top_head_separator">
		<!--============================================================= BEGIN top blocks -->
		<section class="container_12">
		<div class="grid_4 logo">
			<a href="index.html"><img src="front/images/logo.png"
					alt="Logo" />
			</a>
		</div>
		<div class="grid_8 top_mod_right">

			<!--================== BEGIN main menu -->
			<!-- End of menu nav#horizontal -->
			<!--/================= END main menu -->
		</div>
		</section>
		</section>
		<!-- End of .top_head_separator -->
		<div class="clear"></div>
		<!--/============================================================= END top blocks -->
		<!-- =============== HEADER [end] ================ -->

		<!--============================================================== BEGIN content [ .smk_content ] -->
		<div class="page_top_details clearfix">
			<div class="page_title container_12">
				<div class="grid_8">
					<h1>
						<span id="tit1">${title}</span>
					</h1>
				</div>
				
			</div>
		</div>
		<section id="smk_content" class="smk_content">
		<div class="container_12">

			<!-- === Sidebar[begin] === -->
			<div class="sidebar grid_4">

				<!-- ==== WIDGET [begin] ==== -->
				<aside class="widget widget_categories">
				<h1 class="widget-title2">
					了解本草品味
				</h1>
				<ul id="portfolio_menu2">
					<li id="1">
						<a href="#">本草品牌</a>
					</li>
					<li id="2">
						<a href="#">合作公告</a>
					</li>
					<li id="3">
						<a href="#">支付方式</a>
					</li>
					<li id="4">
						<a href="#">配送方式</a>
					</li>
					<li id="5">
						<a href="#">平台资质</a>
					</li>
					<li id="6">
						<a href="#">工具频道</a>
					</li>
					<li id="7">
						<a href="#">国际站点</a>
					</li>
					<li id="8">
						<a href="#">关于我们</a>
					</li>
				</ul>
				</aside>

				<div class="clear"></div>
				<!-- ==== WIDGET [end] ==== -->


			</div>
			<!-- === Sidebar[end] === -->

			<div class="grid_8">
             <div id="partmessage"></div>
			</div>
			<!-- End of .grid_8 -->
			<div class="clear"></div>
		</div>
		<!-- END .container_12 -->
		<div class="clear"></div>
		</section>
		<!-- END of .smk_content -->
		<div class="clear"></div>
		<!--/============================================================= END content [ .smk_content ] -->

		<!-- =============== FOOTER [begin] ================ -->
		</section>
	   <%@include file="bottom.jsp"%>
	</body>
</html>