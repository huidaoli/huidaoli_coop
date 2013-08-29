
/* This file is minimized */
$(document).ready(function () {
	var site = function () {
		this.navLi = $("#nav li").children("ul").hide().end();
		this.init();
	};
	site.prototype = {init:function () {
		this.setMenu();
	}, setMenu:function () {
		$.each(this.navLi, function () {
			if ($(this).children("li ul li ul")[0]) {
				$(this).append("<span />").children("span").addClass("menuChildren");
			}
		});
		this.navLi.hover(function () {
			$(this).find("> ul").stop(true, true).fadeIn({duration:500});
			$(this).children("a:first").addClass("hov");
		}, function () {
			$(this).find("> ul").stop(true, true).hide();
			$(this).children("a:first").removeClass("hov");
		});
		$(".add_divider_before").append("<span class=\"menu_divider\"></span>");
		$(".add_divider_after").append("<span class=\"menu_divider\"></span>");
	}};
	new site();
});
$(function () {
	$("#nav").tinyNav({active:"selected", header:true, });
});
$("<span class=\"alert_close\"></span>").prependTo(".alert");
$(".alert_close").click(function () {
	$(this).parent(".alert").slideUp(500);
});
$(document).ready(function () {
	//$('#tab1').html("<div style='text-align:center;'><img src='front/images/loaders/8.gif'></div>");
	$("ul.tabs li:first").addClass("active").show();
	$("#tab1").load("showtabs.html?id=1");
	$("ul.tabs li").click(function () {
	    //$('#tab1').html("<div style='text-align:center;height:400px;'><img src='front/images/loaders/8.gif'></div>");
		$("ul.tabs li").removeClass("active");
		$(this).addClass("active");
		//$(".tab_content").hide();
		var activeTab = $(this).find("a").attr("href");
		$("#tab1").load(activeTab);
		return false;
	});
});
$(document).ready(function () {
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
$(".box_toggle .block").show();
$(".closed .block").hide();
$(".tg_title").click(function () {
	$(this).toggleClass("tgg_isopen").next().slideToggle("fast");
});
jQuery(document).ready(function ($) {
	$(".lightbox").lightbox();
});

