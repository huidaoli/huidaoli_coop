<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	
    <link rel="icon" type="image/png" href="front/favicon.ico" />
    <link rel="apple-touch-icon" href="front/favicon.ico" />
    <title>${member.companyname}</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1">
    
    <!-- CSS concatenated and minified via ant build script-->
    <link rel="stylesheet" href="front/lib/css/style.css">
    <link rel="stylesheet" href="front/lib/css/elastic-slider.css">
    <link rel="stylesheet" href="front/lib/css/nivo-slider.css">
    <link rel="stylesheet" href="front/lib/css/coin-slider.css">
    <link rel="stylesheet" href="front/lib/js/prettyPhoto/css/prettyPhoto.css">
    <!-- end CSS-->
      
    <!-- scripts concatenated and minified via ant build script-->
    <script src="front/lib/js/jquery-1.6.1.min.js"></script>
    <script src="front/lib/js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
    <script src="front/lib/js/jquery.slideshow.js"></script>
    <script src="front/lib/js/jquery.filterable.js"></script>
    <script src="front/lib/js/autoZoomLoadImage.js"></script>
    
    <script type="text/javascript" src="front/lib/js/script.js"></script>
    
    <!--begin menu script -->
    <script type="text/javascript">
        $(document).ready(function () {	
            $('#nav li').hover(
                function () {
                    //show its submenu
                    $('ul', this).stop(true, true).slideDown(300);
                }, 
                function () {
                    //hide its submenu
                    $('ul', this).stop(true, true).slideUp(300);			
                }
            );
            
            $(".gallery: a[rel^='prettyPhoto']").prettyPhoto({
                 default_width:700,
		         default_height:500,
                 animation_speed:'fast',
                 slideshow:10000, 
                 theme : "pp_default",
                 hideflash: true
                 });
            if ( $.browser.msie ){
		          if($.browser.version=='8.0' || $.browser.version=='7.0' || $.browser.version=='6.0')
		          {
		             alert('使用IE8.0以上版本,效果更佳!其他集成厂商浏览器请不要选择兼容模式');
		          }
		     }
        });
    </script>
    <!--end menu script -->
	
    <!-- begin ScrollToTop script-->
    <script type="text/javascript">
    $(document).ready(function(){
	
		// hide #back-top first
		$("#back-top").hide();
		
		// fade in #back-top
		$(function () {
			$(window).scroll(function () {
				if ($(this).scrollTop() > 100) {
					$('#back-top').fadeIn();
				} else {
					$('#back-top').fadeOut();
				}
			});
	
			// scroll body to 0px on click
			$('#back-top a').click(function () {
				$('body,html').animate({
					scrollTop: 0
				}, 800);
				return false;
			});
		});
		
		$(".ThumbnailPic210_140").autoZoomLoadImage(true, 210, 140);
	
	});
	</script>
	<!-- end ScrollToTop script-->
	
    <!-- begin jcarousel script-->
    <script src="front/lib/js/jquery.jcarousel.min.js"></script>
    <script type="text/javascript"> 
		jQuery(document).ready(function() {
			// Initialise the first and second carousel by class selector.
			// Note that they use both the same configuration options (none in this case).
			jQuery('.first-and-second-carousel').jcarousel();
		});
	</script>
    <!-- end jcarousel script-->
    
   
    
    <!-- begin nivo slider script-->
    <script type="text/javascript" src="front/lib/js/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
	</script>
    <!-- end nivo slider script-->
    
    <!-- begin coinslider script-->
    <script src="front/lib/js/coin-slider.min.js"></script>
    <script>$(document).ready(function() {
		$('#portfolio_slider').coinslider({ hoverPause: false });
	});
	
	$(function(){
      $('#newmess').load("tocompanyproduct.html?memid=${memid}");
    })
    function goPage(pages)
	{
	  $('#newmess').load("tocompanyproduct.html?memid=${memid}&page="+pages);
	}
	</script>
    <!-- begin coinslider script-->
    
   
</head>
<body>
<div id="dotted_bg"></div>
	
    
    <!--begin container -->
<div id="container">
    	
        <!--begin header -->
        <div id="header">
            
        
                
            <div id="header_bottom">
            <!--begin header_bottom -->
                  
                <!--begin logo -->            
                <div id="logo" >
                    <img src="attach/productpic/${member.logo}"  alt="${member.companyname}" onerror="javascript:this.src='front/images/default.png'">
                    <font style="font-size:50px;">
                     ${member.companyname}
                    </font>
                    
                </div>
              
                
                
            </div>
            <!--end header_bottom -->
            
        </div>
        <!--end header -->
        
        <div class="clearfix"></div>
            
            <div id="homepage_slider_wrapper">
                    
                <!--begin nivo-slider -->
                <div id="slider_wrapper">
                    
                    <div id="slider" class="nivoSlider">
                         <s:iterator value="#request.listAds" var="x" status="y">
                            <a href="<s:property value="#x.url"/>">
                            <img width="960" height="420" src="attach/file/<s:property value="#x.newname"/>" 
                               alt="" title="#htmlcaption<s:property value="#y.index"/>" />
                            </a>
                         </s:iterator>
                    </div>
                     <s:iterator value="#request.listAds" var="x" status="y">
                       <div id="htmlcaption<s:property value="#y.index"/>" class="nivo-html-caption">
                         <span><span class="orange"><s:property value="#x.name" escape="false"/></span></span>
                         <div style="width:400px;"> 
                         <s:property value="#x.descri"  escape="false"/>
                         </div>
                       </div>
                     </s:iterator>
                </div>
                <!--end nivo-slider -->
            
                    
            </div>
            
        <!--begin main -->
        <div id="main" role="main">
        	<div class="carousel-second clearfix">
                <h2><span>关于我们</span></h2>
                 ${aboutus}
            </div>
            <div class="carousel-second clearfix">
                <h2><span>最新资讯</span></h2>
                <div id="newmess" style="margin-left:10px;"></div>
            </div>
            <div class="carousel-second clearfix">
                <h2><span>最新产品</span></h2>
                <ul class="gallery first-and-second-carousel jcarousel-skin-ie7">
                   <s:iterator value="#request.hotlist" var="x" status="y">
                    <li>
                        <div class="portfolio_item_4columns homepage_portfolio">
                            <a href="#inline_<s:property value="#x.id"/><s:property value="#y.index"/>" rel="prettyPhoto[inlinenew<s:property value="#y.index"/>]">
                                <span class="overlay_gallery4columns"></span>
                                <img src="attach/productpic/<s:property value="#x.typeimg"/>" class="ThumbnailPic210_140" alt="" title=""  onerror="javascript:this.src='attach/productpic/prdefault.jpg'"/>
                            </a>
                            <div style="position:absolute;left;0;bottom:0;">
                              <h3 class="portfolio_item_title"><s:property value="#x.name" escape="false"/></h3>
                    		  <p class="item_description"><s:property value="#x.proarea" escape="false"/></p>
                            </div>
                          
                    		<s:iterator value="#x.imglist" var="a" status="b">
                    		    <s:if test="#b.index!=0">
                    		      <a href="#inline_<s:property value="#x.id"/><s:property value="#y.index+#b.index"/>" rel="prettyPhoto[inlinenew<s:property value="#y.index"/>]"></a>
                    		    </s:if>
	                            <div id="inline_<s:property value="#x.id"/><s:property value="#y.index+#b.index"/>" style="display:none;">
									<div style="width:710px;overflow:auto;"><img src="attach/productpic/<s:property value="#a.path"/>" onerror="javascript:this.src='attach/productpic/prdefault.jpg'"/></div>
									<p>名称:<s:property value="#x.name" escape="false"/></p>
									<p>产地:<s:property value="#x.proarea" escape="false"/></p>
									<p>规格信息:<s:property value="#x.specinfo" escape="false"/></p>
									<p>功效信息:<s:property value="#x.efficacyinfo" escape="false"/></p>
									<p>描述:<s:property value="#x.remark" escape="false"/></p>
								</div>
	                         </s:iterator>
                        </div>
                    </li>
                    </s:iterator>
                </ul>
            </div>
			
            <div class="carousel-second clearfix">
                <h2><span>所有产品</span></h2>
                <ul class="gallery first-and-second-carousel jcarousel-skin-ie7">
                    <s:iterator value="#request.list" var="x" status="y">
                     <li>
                        <div class="portfolio_item_4columns homepage_portfolio">
                            <a href="#inline_<s:property value="#x.id"/><s:property value="#y.index"/>" rel="prettyPhoto[inlineall<s:property value="#y.index"/>]">
                                <span class="overlay_gallery4columns"></span>
                                <img src="attach/productpic/<s:property value="#x.typeimg"/>"  class="ThumbnailPic210_140" alt="" title="" onerror="javascript:this.src='attach/productpic/prdefault.jpg'"/>
                            </a>
                            <div style="position:absolute;left;0;bottom:0;">
                              <h3 class="portfolio_item_title"><s:property value="#x.name" escape="false"/></h3>
                    		  <p class="item_description"><s:property value="#x.proarea" escape="false"/></p>
                            </div>
                    		<s:iterator value="#x.imglist" var="a" status="b">
                    		    <s:if test="#b.index!=0">
                    		      <a href="#inline_<s:property value="#x.id"/><s:property value="#y.index+#b.index"/>" rel="prettyPhoto[inlineall<s:property value="#y.index"/>]"></a>
                    		    </s:if>
	                            <div id="inline_<s:property value="#x.id"/><s:property value="#y.index+#b.index"/>" style="display:none;">
									<div style="width:710px;overflow:auto;"><img src="attach/productpic/<s:property value="#a.path"/>" onerror="javascript:this.src='attach/productpic/prdefault.jpg'"/></div>
									<p><s:property value="#x.name" escape="false"/></p>
									<p><s:property value="#x.proarea" escape="false"/></p>
									<p><s:property value="#x.specinfo" escape="false"/></p>
									<p><s:property value="#x.efficacyinfo" escape="false"/></p>
									<p><s:property value="#x.remark" escape="false"/></p>
								</div>
	                         </s:iterator>
                        </div>
                    </li>
                   </s:iterator>
                </ul>
            </div>
            
            <div class="carousel-second clearfix">
                <h2><span>联系我们</span></h2>
                ${conus}
            </div>
                        
        </div>
    <!--end main -->
            
    <!--begin footer -->
    <div id="footer_wrapper">
          <!--begin footer_top -->
          <div id="footer_top" style="text-align:center;">
             <p>凯之渡大学生创新创业示范项目</p>
             <p>渡之珍国际生态产品有限公司版权所有</p>
             <p>DOT International Materia Medica Product Ltd. Copyright</p>

          </div>
         
        </div>
    <!--end footer -->
    </div>
    <!--! end of #container -->

    <!--begin ScrollToTop -->
    <p id="back-top"><a href="#top"><span></span></a></p>
    <!--end ScrollToTop -->
    
</body>
</html>
