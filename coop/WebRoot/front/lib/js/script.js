/**
 * jQuery.ScrollTo - Easy element scrolling using jQuery.
 * Copyright (c) 2007-2009 Ariel Flesler - aflesler(at)gmail(dot)com | http://flesler.blogspot.com
 * Dual licensed under MIT and GPL.
 * Date: 5/25/2009
 * @author Ariel Flesler
 * @version 1.4.2
 *
 */
;(function(d){var k=d.scrollTo=function(a,i,e){d(window).scrollTo(a,i,e)};k.defaults={axis:'xy',duration:parseFloat(d.fn.jquery)>=1.3?0:1};k.window=function(a){return d(window)._scrollable()};d.fn._scrollable=function(){return this.map(function(){var a=this,i=!a.nodeName||d.inArray(a.nodeName.toLowerCase(),['iframe','#document','html','body'])!=-1;if(!i)return a;var e=(a.contentWindow||a).document||a.ownerDocument||a;return d.browser.safari||e.compatMode=='BackCompat'?e.body:e.documentElement})};d.fn.scrollTo=function(n,j,b){if(typeof j=='object'){b=j;j=0}if(typeof b=='function')b={onAfter:b};if(n=='max')n=9e9;b=d.extend({},k.defaults,b);j=j||b.speed||b.duration;b.queue=b.queue&&b.axis.length>1;if(b.queue)j/=2;b.offset=p(b.offset);b.over=p(b.over);return this._scrollable().each(function(){var q=this,r=d(q),f=n,s,g={},u=r.is('html,body');switch(typeof f){case'number':case'string':if(/^([+-]=)?\d+(\.\d+)?(px|%)?$/.test(f)){f=p(f);break}f=d(f,this);case'object':if(f.is||f.style)s=(f=d(f)).offset()}d.each(b.axis.split(''),function(a,i){var e=i=='x'?'Left':'Top',h=e.toLowerCase(),c='scroll'+e,l=q[c],m=k.max(q,i);if(s){g[c]=s[h]+(u?0:l-r.offset()[h]);if(b.margin){g[c]-=parseInt(f.css('margin'+e))||0;g[c]-=parseInt(f.css('border'+e+'Width'))||0}g[c]+=b.offset[h]||0;if(b.over[h])g[c]+=f[i=='x'?'width':'height']()*b.over[h]}else{var o=f[h];g[c]=o.slice&&o.slice(-1)=='%'?parseFloat(o)/100*m:o}if(/^\d+$/.test(g[c]))g[c]=g[c]<=0?0:Math.min(g[c],m);if(!a&&b.queue){if(l!=g[c])t(b.onAfterFirst);delete g[c]}});t(b.onAfter);function t(a){r.animate(g,j,b.easing,a&&function(){a.call(this,n,b)})}}).end()};k.max=function(a,i){var e=i=='x'?'Width':'Height',h='scroll'+e;if(!d(a).is('html,body'))return a[h]-d(a)[e.toLowerCase()]();var c='client'+e,l=a.ownerDocument.documentElement,m=a.ownerDocument.body;return Math.max(l[h],m[h])-Math.min(l[c],m[c])};function p(a){return typeof a=='object'?a:{top:a,left:a}}})(jQuery);


/* jQuery Easing */
jQuery.easing.jswing=jQuery.easing.swing;
jQuery.extend(jQuery.easing,{def:"easeOutQuad",swing:function(e,a,c,b,d){return jQuery.easing[jQuery.easing.def](e,a,c,b,d)},easeInQuad:function(e,a,c,b,d){return b*(a/=d)*a+c},easeOutQuad:function(e,a,c,b,d){return-b*(a/=d)*(a-2)+c},easeInOutQuad:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a+c;return-b/2*(--a*(a-2)-1)+c},easeInCubic:function(e,a,c,b,d){return b*(a/=d)*a*a+c},easeOutCubic:function(e,a,c,b,d){return b*((a=a/d-1)*a*a+1)+c},easeInOutCubic:function(e,a,c,b,d){if((a/=d/2)<1)return b/
2*a*a*a+c;return b/2*((a-=2)*a*a+2)+c},easeInQuart:function(e,a,c,b,d){return b*(a/=d)*a*a*a+c},easeOutQuart:function(e,a,c,b,d){return-b*((a=a/d-1)*a*a*a-1)+c},easeInOutQuart:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a*a*a+c;return-b/2*((a-=2)*a*a*a-2)+c},easeInQuint:function(e,a,c,b,d){return b*(a/=d)*a*a*a*a+c},easeOutQuint:function(e,a,c,b,d){return b*((a=a/d-1)*a*a*a*a+1)+c},easeInOutQuint:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a*a*a*a+c;return b/2*((a-=2)*a*a*a*a+2)+c},easeInSine:function(e,
a,c,b,d){return-b*Math.cos(a/d*(Math.PI/2))+b+c},easeOutSine:function(e,a,c,b,d){return b*Math.sin(a/d*(Math.PI/2))+c},easeInOutSine:function(e,a,c,b,d){return-b/2*(Math.cos(Math.PI*a/d)-1)+c},easeInExpo:function(e,a,c,b,d){return a==0?c:b*Math.pow(2,10*(a/d-1))+c},easeOutExpo:function(e,a,c,b,d){return a==d?c+b:b*(-Math.pow(2,-10*a/d)+1)+c},easeInOutExpo:function(e,a,c,b,d){if(a==0)return c;if(a==d)return c+b;if((a/=d/2)<1)return b/2*Math.pow(2,10*(a-1))+c;return b/2*(-Math.pow(2,-10*--a)+2)+c},
easeInCirc:function(e,a,c,b,d){return-b*(Math.sqrt(1-(a/=d)*a)-1)+c},easeOutCirc:function(e,a,c,b,d){return b*Math.sqrt(1-(a=a/d-1)*a)+c},easeInOutCirc:function(e,a,c,b,d){if((a/=d/2)<1)return-b/2*(Math.sqrt(1-a*a)-1)+c;return b/2*(Math.sqrt(1-(a-=2)*a)+1)+c},easeInElastic:function(e,a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d)==1)return c+b;f||(f=d*0.3);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);return-(g*Math.pow(2,10*(a-=1))*Math.sin((a*d-e)*2*Math.PI/f))+c},easeOutElastic:function(e,
a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d)==1)return c+b;f||(f=d*0.3);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);return g*Math.pow(2,-10*a)*Math.sin((a*d-e)*2*Math.PI/f)+b+c},easeInOutElastic:function(e,a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d/2)==2)return c+b;f||(f=d*0.3*1.5);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);if(a<1)return-0.5*g*Math.pow(2,10*(a-=1))*Math.sin((a*d-e)*2*Math.PI/f)+c;return g*Math.pow(2,-10*(a-=1))*Math.sin((a*
d-e)*2*Math.PI/f)*0.5+b+c},easeInBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;return b*(a/=d)*a*((f+1)*a-f)+c},easeOutBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;return b*((a=a/d-1)*a*((f+1)*a+f)+1)+c},easeInOutBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;if((a/=d/2)<1)return b/2*a*a*(((f*=1.525)+1)*a-f)+c;return b/2*((a-=2)*a*(((f*=1.525)+1)*a+f)+2)+c},easeInBounce:function(e,a,c,b,d){return b-jQuery.easing.easeOutBounce(e,d-a,0,b,d)+c},easeOutBounce:function(e,a,c,b,d){return(a/=
d)<1/2.75?b*7.5625*a*a+c:a<2/2.75?b*(7.5625*(a-=1.5/2.75)*a+0.75)+c:a<2.5/2.75?b*(7.5625*(a-=2.25/2.75)*a+0.9375)+c:b*(7.5625*(a-=2.625/2.75)*a+0.984375)+c},easeInOutBounce:function(e,a,c,b,d){if(a<d/2)return jQuery.easing.easeInBounce(e,a*2,0,b,d)*0.5+c;return jQuery.easing.easeOutBounce(e,a*2-d,0,b,d)*0.5+b*0.5+c}});

/*
 * jQuery Color Animations
 * Copyright 2007 John Resig
 * Released under the MIT and GPL licenses.
 */
(function(jQuery){
    jQuery.each(['backgroundColor', 'borderBottomColor', 'borderLeftColor', 'borderRightColor', 'borderTopColor', 'color', 'outlineColor'], function(i,attr){
        jQuery.fx.step[attr] = function(fx){
            if ( !fx.colorInit ) {
                fx.start = getColor( fx.elem, attr );
                fx.end = getRGB( fx.end );
                fx.colorInit = true;
            }

            fx.elem.style[attr] = "rgba(" + [
                Math.max(Math.min( parseInt((fx.pos * (fx.end[0] - fx.start[0])) + fx.start[0]), 255), 0),
                Math.max(Math.min( parseInt((fx.pos * (fx.end[1] - fx.start[1])) + fx.start[1]), 255), 0),
                Math.max(Math.min( parseInt((fx.pos * (fx.end[2] - fx.start[2])) + fx.start[2]), 255), 0),
                Math.max(Math.min( parseFloat((fx.pos * (fx.end[3] - fx.start[3])) + fx.start[3]), 1), 0)
            ].join(",") + ")";
        }
    });

    function getRGB(color) {
        var result;

        if ( color && color.constructor == Array && color.length == 3 )
            return color;
        if (result = /rgba\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([-+]?[0-9]*\.?[0-9]+)\s*\)/.exec(color))
            return [parseInt(result[1]), parseInt(result[2]), parseInt(result[3]), parseFloat(result[4])];
        if (result = /rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(color))
            return [parseInt(result[1]), parseInt(result[2]), parseInt(result[3]), 1];
        if (result = /rgb\(\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*\)/.exec(color))
            return [parseFloat(result[1])*2.55, parseFloat(result[2])*2.55, parseFloat(result[3])*2.55, 1];
        if (result = /#([a-fA-F0-9]{2})([a-fA-F0-9]{2})([a-fA-F0-9]{2})/.exec(color))
            return [parseInt(result[1],16), parseInt(result[2],16), parseInt(result[3],16), 1];
        if (result = /#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])/.exec(color))
            return [parseInt(result[1]+result[1],16), parseInt(result[2]+result[2],16), parseInt(result[3]+result[3],16), 1];
        if (result = /rgba\(0, 0, 0, 0\)/.exec(color))
            return colors['transparent'];
        return colors[jQuery.trim(color).toLowerCase()];
    }
    function getColor(elem, attr) {
        var color;
        do {
            color = jQuery.curCSS(elem, attr);
            if ( color != '' && color != 'transparent' || jQuery.nodeName(elem, "body") )
                break;
            attr = "backgroundColor";
        } while ( elem = elem.parentNode );

        return getRGB(color);
    };

    
})(jQuery);

$(document).ready(function(){
	
	$('.button').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(0, 0, 0, 0.8)"},{queue:false, duration:1000, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:600, easing: 'swing'} );}
	);
	
	$('ul.social_icons li a').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:1000, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(16, 16, 16, 0.9)"},{queue:false, duration:600, easing: 'swing'} );}
	); 
	
	$('.btn-slide').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:1000, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(16, 16, 16, 0.9)"},{queue:false, duration:600, easing: 'swing'} );}
	); 
	
	$('#search-submit').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(221, 221, 221, 0.1)"},{queue:false, duration:1000, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(255, 255, 255, 0.9)"},{queue:false, duration:600, easing: 'swing'} );}
	); 
	
	$('ul.photostream li a').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:700, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(255, 255, 255, 0))"},{queue:false, duration:700, easing: 'swing'} );}
	); 
	
	$('.footer_news_box a img').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:700, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(255, 255, 255, 0))"},{queue:false, duration:700, easing: 'swing'} );}
	); 
	
	$('.sidebar_recent_posts a img').hover(
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(253, 101, 16, 0.9)"},{queue:false, duration:700, easing: 'swing'} );},
	function () {$(this).stop(true, true).animate({backgroundColor: "rgba(255, 255, 255, 0))"},{queue:false, duration:700, easing: 'swing'} );}
	); 
	
});

/* jQuery Tabs 1 */
$(function () {
	var tabContainers = $('div.tabs > div');
	tabContainers.hide().filter(':first').show();
	
	$('div.tabs ul.tabNavigation a').click(function () {
		tabContainers.hide();
		tabContainers.filter(this.hash).show();
		$('div.tabs ul.tabNavigation a').removeClass('selected');
		$(this).addClass('selected');
		return false;
	}).filter(':first').click();
});

/* jQuery Tabs 2 */
$(function () {
	var tabContainers = $('div.tabs2 > div');
	tabContainers.hide().filter(':first').show();
	
	$('ul.tabNavigation2 a').click(function () {
		tabContainers.hide();
		tabContainers.filter(this.hash).show();
		$('ul.tabNavigation2 a').removeClass('selected');
		$(this).addClass('selected');
		return false;
	}).filter(':first').click();
});

/* Jquery Toggle */
$(document).ready(function () {
	
	$(".toggle .description").hide();

	$(".toggle .item_wrapper").click(function(){
		$(this).next(".description").slideToggle("fast")
		.siblings(".description:visible").slideUp("fast");
		$(this).toggleClass("active");
		$(this).siblings(".item_wrapper").removeClass("active");
	});
	
	$('#toggle-view li').click(function () {
		var text = $(this).children('p');
		if (text.is(':hidden')) {
			text.slideDown('200');
			$(this).children('span').html('-');		
		} else {
			text.slideUp('200');
			$(this).children('span').html('+');		
		}
	});

});

/* Jquery Overlay Gallery */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_gallery5columns").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_gallery5columns").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .7
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Portofolio2Columns */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_portfolio2columns").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_portfolio2columns").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Portofolio3Columns */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_gallery3columns").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_gallery3columns").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Portofolio4Columns */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_gallery4columns").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_gallery4columns").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Photostream */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_photostream").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_photostream").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Blog */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_blog").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_blog").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery Overlay Blog Homepage */
$(function() {
	// OPACITY OF BUTTON SET TO 0%
	$(".overlay_blog_homepage").css("opacity","0");
	 
	// ON MOUSE OVER
	$(".overlay_blog_homepage").hover(function () {
	 
	// SET OPACITY TO 70%
	$(this).stop().animate({
	opacity: .5
	}, "slow");
	},
	 
	// ON MOUSE OUT
	function () {
	 
	// SET OPACITY BACK TO 50%
	$(this).stop().animate({
	opacity: 0
	}, "slow");
	});
});

/* Jquery DropDown Panel */
$(document).ready(function(){
	$(".btn-slide").click(function(){
		$("#panel").slideToggle("slow");
		$(this).toggleClass("active"); return false;
	});
});

/* Search Form */
$(document).ready(function(){ 
	// Add the value of "Search..." to the input field
	$("#search").val("Search...");
	// When you click on #search
	$("#search").focus(function(){
		// If the value is equal to "Search..."
		if($(this).val() == "Search...") {
			// remove all the text
			$(this).val("");	
		}
	});
	// When the focus on #search is lost
	$("#search").blur(function(){
		// If the input field is empty
		if($(this).val() == "") {
			// Add the text "Search..."
			$(this).val("Search...");	
		}
	});
	$("#search-submit").hover(function(){
		$(this).addClass("hover");
	});
});

/* Contact Form */
$(document).ready(function(){
 	$('#submit-form').click(function(){
 		
 	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
 	 var names 				 = $('#contact-form [name="contact-names"]').val();	 
   var email_address = $('#contact-form [name="contact-email"]').val();
   var comment			 = $.trim($('#contact-form .contact-commnent').val());
   var data_html ='' ;
   
   
 				if(names == ""){
 					 $('.name-required').html('Your name is required.');
 				}else{
 					 $('.name-required').html('');
 				}
 				if(email_address == ""){
 					 $('.email-required').html('Your email is required.');
 				}else if(reg.test(email_address) == false){
 					 $('.email-required').html('Invalid Email Address.');
 				}else{
 					 $('.email-required').html('');
 				}
 				
 				if(comment == ""){
 					 $('.comment-required').html('Comment is required.');
 				}else{
 					 $('.comment-required').html('');
 				}
 				
 		if(comment != "" && names != "" && reg.test(email_address) != false){
 		
 			data_html = "names="+ names + "&comment=" + comment + "&email_address="+ email_address;
 			
 			//alert(data_html);
 			
 		  $.ajax({
				  type: 'post',
				  url: 'contact-send.php',
				  data: data_html,
				  success: function(msg){
				  	if (msg == 'sent'){
				 			$('#success').html('Message sent!') 	;
				 			$('#contact-form [name="contact-names"]').val('');	 
						  $('#contact-form [name="contact-email"]').val('');
    					$('#contact-form .contact-commnent').val('');
				 			
				 		}else{
				 			$('#success').html('Mail Error. Please Try Again.!') 	;	
				 		}
				  }
			});
 		
 	  }
 	  		
	 	return false;
 	})
})