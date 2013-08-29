<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="description" content="本草品味国际合作商务平台" />
		<meta name="keywords" content="绿色食品,食品,药材,养生" />
		<link rel="icon" type="image/png" href="front/favicon.ico" />
		<link rel="apple-touch-icon" href="front/favicon.ico" />
		<title>${title}</title>
		<!--============================================= BEGIN STYLES ==-->
		<link rel="stylesheet" href="front/css/config.css" />
		<link rel="stylesheet" href="front/css/themes/46.css" />
		<link rel="stylesheet" href="front/css/style.css" />
		<link rel="stylesheet" href="front/css/validationEngine.jquery.css" />
		<!--[if IE 7]> <link rel="stylesheet" href="front/css/ie7.css" /> <![endif]-->
		<!--[if IE 8]> <link rel="stylesheet" href="front/css/ie8.css" /> <![endif]-->

		<!--============================================= BEGIN SCRIPTS ==-->
		<script type="text/javascript" src="front/js/jquery.js"></script>
		<!--JQuery Library-->
		<script type="text/javascript" src="front/js/jquery.preloadify.js"></script>
		<!--Preloadify-->
		<script type="text/javascript" src="front/js/scripts-top.js"></script>
		<script type="text/javascript" src="front/js/jquery.plugins-min.js"></script>

		<!--[if IE]>
	<script type="text/javascript" src="front/js/html5.js"></script>
	<style type="text/css">.testimonial_arrow{display: none!important;}</style>
	<![endif]-->


		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script>
		    function showMessage(id,type)
			{
				
			   $.lightbox($("<div/>").load("queryInfoById.action?id="+id+"&type="+type), {
				    width   : 640,
				    height  : 360
			   });
				  
			}
			function goPage(pages)
			{
			    window.location='queryMoreInfoByType.html?type=${type}&pages='+pages;
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
						${title}
					</h1>
				</div>
				
			</div>
		</div>
		<div class="container_12">

			<div class="grid_12">
				<div class="info_box_head ib_green">
					<font style="color: white;">${title}</font>
				</div>
				<div class="info_box ib_green">

					<s:if test="#request.list1 !=null">
						<aside class="widget">
									<div class="recent_comments">
									    <s:iterator value="#request.list1" var="x" >
										<div class="post_comm">
											[<s:iterator value="listDictBuss" var="y">
													<s:if test="#y.dictId == #x.type">
													  <s:property value="#y.dictName"/> 
													</s:if>
										 </s:iterator>]
										 <span style="padding-left:20px;" />
										 <a href="javascript:void('0');" onclick="showMessage('<s:property value="#x.id" escape="false"/>','1');">
										 <s:property value="#x.name" escape="false"/>
										 </a>
											<div style="float:right"><s:date name="#x.createDate" format="yyyy-MM-dd" /></div>
										</div>
										<div class="clear"></div>
										</s:iterator>
									</div>
									<div class="clear"></div>
						</aside>

					</s:if>


					<s:if test="#request.list2 !=null">
						<aside class="widget">
									<div class="recent_comments">
									    <s:iterator value="#request.list2" var="x" >
										<div class="post_comm">
											[<s:iterator value="listDictBuss" var="y">
													<s:if test="#y.dictId == #x.type">
													  <s:property value="#y.dictName"/> 
													</s:if>
										 </s:iterator>]
										 <span style="padding-left:20px;" />
										 <a href="javascript:void('0');" onclick="showMessage('<s:property value="#x.id" escape="false"/>','2');">
										 <s:property value="#x.name" escape="false"/>
										 </a>
											<div style="float:right"><s:date name="#x.createDate" format="yyyy-MM-dd" /></div>
										</div>
										<div class="clear"></div>
										</s:iterator>
									</div>
									<div class="clear"></div>
						</aside>

					</s:if>
					
					<!-- ==== Pagination [begin] ==== -->
					<div id="smk_pagination" class="all_transition_05">
						${pageHtml}
					</div>
					<div class="clear"></div>
				  <!-- ==== Pagination [end] ==== -->
                   
					
				</div>
				<div class="clear"></div>



			</div>
		</div>

 


		<div class="clear"></div>
		<!--/============================================================= END content [ .smk_content ] -->

		<!-- END .container_12 -->
		<div class="clear"></div>
		</section>
		<!-- END of .smk_content -->
		<div class="clear"></div>

		<!-- =============== FOOTER [begin] ================ -->
		</section>
	    <section id="site_footer_second">
		<div style="text-align:center;padding-bottom: 2px;">
					<p></p>
					<p>凯之渡大学生创新创业示范项目</p>
					<p>渡之珍国际生态产品有限公司版权所有</p>
					<p>DOT International Materia Medica Product Ltd. Copyright</p>
					<p>苏ICP备:45454512</p>
		</div>
		</section>
	</body>
</html>