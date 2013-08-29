<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="本草品味国际商务合作平台" />
<meta name="keywords" content="绿色食品,食品,药材,养生" />
<link rel="icon" type="image/png" href="front/favicon.ico" />
<link rel="apple-touch-icon" href="front/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--============================================= BEGIN STYLES ==-->
		<link rel="stylesheet" href="front/css/config2.css" />
		<link rel="stylesheet" href="front/css/themes/46.css" />
		<!--[if IE 7]> <link rel="stylesheet" href="front/css/ie7.css" /> <![endif]-->
		<!--[if IE 8]> <link rel="stylesheet" href="front/css/ie8.css" /> <![endif]-->

		<!--============================================= BEGIN SCRIPTS ==-->
		<link rel="stylesheet" type="text/css" href="themes/icon.css">
		<link rel="stylesheet" type="text/css" href="themes/metro/easyui.css">
		<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript" src="jquery-migrate.js"></script>
		<script type="text/javascript" src="jquery.easyui.min.js"></script>
		<script type="text/javascript" src="locale/easyui-lang-zh_CN.js"></script>
		<!--JQuery Library-->
		<script type="text/javascript" src="front/js/jquery.preloadify.js"></script>
		<!--Preloadify-->
		<script type="text/javascript" src="front/js/scripts-top.js"></script>
		<script type="text/javascript" src="page/upload/gener.js"></script>
		
		<!--General scripts header-->

		<!--[if IE]>
	<script type="text/javascript" src="front/js/html5.js"></script>
	<style type="text/css">.testimonial_arrow{display: none!important;}</style>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="themes/content.css">
<title>本草品味国际商务合作平台</title>
		
		<script>
			$(function () {
				$("#portfolio_menu2 li").click(function () {
					$("#portfolio_menu2 li").removeClass("current-menu-item");
					$(this).addClass("current-menu-item");
					loadHTML($(this).text(),$(this).attr("id"),$(this));
					return false;
				});
				$("#portfolio_menu2 li").each(function (i) {
				    if($(this).find("a").text()=='${title}')
				    {
				        $(this).addClass("current-menu-item");
				    }
			    });
			    //loadHTML('${title}','${id}');
			});
			
			function winopen()
			{
			   window.open(${memberid}, "_blank", '');
			   //var $tempForm = $('<form method="post" target="_blank" action="${memberid}"></form>');
			   //$("body").append($tempForm);
			   //$tempForm.submit();
			}
			
			function loadHTML(title,id,obj)
			{
			    //$('#partmessage').html("<div style='text-align:center;height:800px;'><img src='front/images/loaders/8.gif'></div>");
			    //var html = $("<iframe  scrolling='auto' name='productdetail' id='productdetail' frameborder='0' src='myspacemenu.html?title="+title+"&id="+id+"&time="+(new Date().getTime())+"' width='100%' height='100%'></iframe>");
                if(id=='9')
                {
                    // async: false 改成同步，解决chrome拦截窗口
                    $.ajax({
					   type: "POST",
					   url: "checkIsFinish.action",
					   data: "memberid=${memberid}",
					   async: false,
					   success: function(data){
					    if(data==0)
					    {
					       $.messager.confirm('信息','请完成基本信息才能访问空间，现在完成?',function(r){
								if (r){	
								   var action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid=3";
                                   var h=700;
                                   $('#partmenu').height(h).load(action);
								}
							});
					    }
					    else
					    {
					       
					       //a.click();
					       //document.getElementById("tmpid").click();
					       //alert(obj.find("a").attr("href",'${memberid}'));
					       winopen();
					    }
					   }
					});
                   
                }
                else
                {
                    var action ='';
                    var h = 500;
                    $('#partmenu').html("<img src='front/images/loaders/6.gif'/>");
                    if(id=='1'){ 
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                    }
                    if(id=='2'){ 
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                    }
                    if(id=='3'){ 
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                        h=700;
                    }
                    if(id=='4'){ 
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                    }
                    if(id=='5'){ 
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                    }
                    if(id=='6'){
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                    }
                    if(id=='7' || id=='8'){
                        action="myspacemenu.html?title="+encodeURI(title)+"&id=${memberid}&typeid="+id;
                        h=600;
                    }
                    $('#partmenu').height(h).load(action);
                    
                }
               
			}
	  </script>
	</head>
	<body>

		<section id="smk_container_full">
		<section class="smk_container">
		<section class="wrap">
		<section class="top_head_separator2">
		<!--============================================================= BEGIN top blocks -->
		<section class="container_12">
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
						<span id="tit1">${session.member.companyname}</span>后台管理系统
					</h1>
				</div>
				
			</div>
		</div>
		<section id="smk_content" class="smk_content">
		<div class="container_13">

			<!-- === Sidebar[begin] === -->
			<div class="sidebar grid_4">

				<!-- ==== WIDGET [begin] ==== -->
				<aside class="widget widget_categories">
				<font style="font-size: 25px;">
					<a href="index.html">返回</a>
				</font>
				<ul id="portfolio_menu2">
				    <li id="1">
						<a href="javascript:void(0);">行业资讯</a>
					</li>
				    <li id="2">
						<a href="javascript:void(0);">顶部广告</a>
					</li>
					<li id="3">
						<a href="javascript:void(0);">基本信息</a>
					</li>
					<li id="4">
						<a href="javascript:void(0);">密码管理</a>
					</li>
					<li id="5">
						<a href="javascript:void(0);">产品管理</a>
					</li>
					<li id="6">
						<a href="javascript:void(0);">合约管理</a>
					</li>
					<li id="7">
						<a href="javascript:void(0);">关于我们</a>
					</li>
					<li id="8">
						<a href="javascript:void(0);">联系我们</a>
					</li>
					<li id="9">
						<a href="javascript:void(0);">商家主页</a>
					</li>
				</ul>
				</aside>

				<div class="clear"></div>
				<!-- ==== WIDGET [end] ==== -->


			</div>
			<!-- === Sidebar[end] === -->

			<div class="grid_8">
	             <div id="partmenu">
	                <font style="font-size: 25px;">欢迎使用${session.member.companyname}后台管理系统</font>
	             </div>
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