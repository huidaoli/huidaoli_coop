
/* This file is minimized */
/* Hide Show config panel (frontend) */
jQuery(".color_whell").toggle(function () {
	jQuery("#style-switcher").animate({left:"0px"}, {duration:300});
}, function () {
	jQuery("#style-switcher").animate({left:"-358px"}, {duration:300});
});
jQuery(document).ready(function () {
	$("#contactform").submit(function () {
		var action = $(this).attr("action");
		$("#submit").attr("disabled", "disabled").after("<img src=\"images/icons/ajax-loader.gif\" class=\"loader\" />");
		$("#message").slideUp(750, function () {
			$("#message").hide();
			$.post(action, {name:$("#name").val(), email:$("#email").val(), subject:$("#subject").val(), comments:$("#comments").val(), verify:$("#verify").val()}, function (data) {
				document.getElementById("message").innerHTML = data;
				$("#message").slideDown("slow");
				$("#contactform img.loader").fadeOut("fast", function () {
					$(this).remove();
				});
				$("#submit").removeAttr("disabled");
				if (data.match("success") != null) {
					$("#contactform").slideUp("slow");
				}
			});
		});
		return false;
	});
});
$(window).load(function () {
	$("div[id^=portfolioSlider]").flexslider();
});
$("#mainSlider").flexslider();
$("div[id^=blogSlider]").flexslider();
$(document).ready(function () {
	$("#iview").iView({
	 fx:"random", 
	 pauseTime:7000,
	 controlNav: true,
	 controlNavNextPrev: false,
	 controlNavTooltip: false,
	 pauseOnHover:true,
	 directionNavHoverOpacity:0, 
	 timer:"Bar", 
	 timerDiameter:"50%", 
	 timerPadding:0, 
	 timerStroke:7, 
	 timerBarStroke:0, 
	 timerColor:"#FFF", 
	 timerPosition:"bottom-right"
	 }
 );
});
$(document).ready(function () {
	$("#onebyone_slider").oneByOne({className:"oneByOne1", easeType:"random", slideShow:true, delay:200, slideShowDelay:4000});
});
$(".container_video").fitVids();
$(function () {
	var $container = $("#portfolio_masonry");
	$container.imagesLoaded(function () {
		$container.masonry({itemSelector:".portf_item"});
	});
});
$(function () {
	var $container = $("#blog_masonry");
	$container.imagesLoaded(function () {
		$container.masonry({itemSelector:".blog_article"});
	});
});
$(function () {
	var $container = $("#testimonials_section");
	$container.imagesLoaded(function () {
		$container.masonry({itemSelector:".testimonial"});
	});
});
$(function () {
	$(".home_clients .hp_item_grid_client").hover(function () {
		$("img", this).animate({"opacity":"0.75"}, {queue:true, duration:300});
	}, function () {
		$("img", this).animate({"opacity":"1"}, {queue:true, duration:300});
	});
});
$(function () {
	var $IsoContainer = $("#portfolio");
	$IsoContainer.imagesLoaded(function () {
		$IsoContainer.isotope({itemSelector:".portf_item"});
	});
	$("#portfolio_menu a").click(function () {
		//var selector = $(this).attr("data-filter");
		//$IsoContainer.isotope({filter:selector});
		//$('#product').html("<div style='text-align:center;'><img src='front/images/loaders/8.gif'></div>");
		var val = $(this).text();
		$('#s').val(val);
		$('#product').load("toProduct.html?sear="+val);
		$("#portfolio_menu a").removeClass("active_cat");
		$(this).addClass("active_cat");
		return false;
	});
});
$(document).ready(function () {
	$("#faq_questions ul li a").click(function () {
		var el = $(this).attr("href");
		var elWrapped = $(el);
		scrollToDiv(elWrapped, 40);
		return false;
	});
	function scrollToDiv(element, navheight) {
		var offset = element.offset();
		var offsetTop = offset.top;
		var totalScroll = offsetTop - navheight;
		$("body,html").animate({scrollTop:totalScroll}, 500);
	}
});
$(document).ready(function () {
	$("#voucher_counttime").countdown({date:"september 1, 2012", direction:"down", leadingZero:true});
});
$(document).ready(function () {
	$(".faq_question").live("click", function () {
		var $q = $(this).attr("id");
		var $q_id = $q.substr($q.indexOf("_") + 1);
		$.scrollTo("#answer_" + $q_id, {duration:500, onAfter:function () {
			$("#answer_" + $q_id + "_text").highlightFade({color:"rgb(206,255,205)", speed:500});
		}});
	});
	$(".go_to_top").click(function () {
		$.scrollTo("#smk_container_full", {duration:500});
	});
});

