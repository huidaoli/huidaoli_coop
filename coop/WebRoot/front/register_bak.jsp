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
		<title>用户注册</title>
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
		<script type="text/javascript" src="front/js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="front/js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript" src="front/js/jquery.plugins-min.js"></script>
		<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
		<!--General scripts header-->

		<!--[if IE]>
	<script type="text/javascript" src="front/js/html5.js"></script>
	<style type="text/css">.testimonial_arrow{display: none!important;}</style>
	<![endif]-->


		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script>
		
		
		  jQuery(document).ready(function(){

	        if(document.addEventListener){
	            document.addEventListener("keypress",fireFoxHandler, true);   
	        }
	        jQuery("#pp-form").validationEngine({
	            scroll: false,
	            focusFirstField:true,
	            ajaxFormValidation: true,
	            onAjaxFormComplete: ajaxValidationCallback,
	            onBeforeAjaxFormValidation: beforeCall
	        });
	        jQuery("#reg-btn").click(function(){
	            checks();
						
	        });  
					
	        $("body").bind('keydown',function(e) {
	            if(e.which==13)
	            {
	                checks();
	            }
	        });
					 
	    });
	    var sb=true;
	    var i=0;
	    function beforeCall(form, options){
	        if (window.console) 
	            console.log("Right before the AJAX form validation call");
	        return true;
	    }
	            
	    function errcss(whick, word){
	        var prompts = $("#"+whick+"show"); //修改
	        prompts.html(word);
	        prompts.addClass("reg-red");
	        prompts.removeClass("reg-green");
	    }
	    function ajaxValidationCallback(status, form, json, options)
	    {
	        jQuery("#reg-btn").bind("click",handle);
	                 
	        if (status === true) {
	          
	        }
	    }
           
	     function fireFoxHandler(evt)
	     { 
	        if(evt.keyCode==13){  
	            checks(); 
	        }  
	    }
	    function checks()
	    {

		        var username = $("#username").val();
		        var realname = $("#realname").val();
		        var regpw = $("#regpw").val();
		        var conpw = $("#con-pw").val();
		        var cooptype = $("#cooptype").val();
		        var sex = $("#sex").val();
		        var chck = $("#agrees").attr("checked");
		        i=0;
		        if(username=="") {
		            errcss('username','不能为空!');
		            i=1;
		        }
		        if(realname=="") {
		            errcss('realname','不能为空!');
		            i=2;
		        }
		        if(regpw=="") {
		            errcss('regpw','不能为空!');
		            i=3;
		        }
		        if(conpw=="") {
		            errcss('con-pw','不能为空!');
		            i=4;
		        }
		        if(cooptype=="") {
		            errcss('cooptype','选择合作类型!');
		            i=5;
				}
				if(chck!="checked") {
		            errcss('agrees','选择同意协议!');
		            i=6;
				}
				if(sex=="") {
		            errcss('sex','选择性别!');
		            i=7;
				}
				
					
		        if(i!=0)
		        {  
		            i=0;
		            return false;
		        }
		        if(sb==true) {
			            sb=false;
			            //var token = document.getElementsByName("struts.token")[0].value;
			            //var tokenname = document.getElementsByName("struts.token.name")[0].value;
			            $('#pp-form').form('submit',{
							url: 'saveMember.action',
							
							success: function(result){
								var result = eval('('+result+')');
								if (result.result){
								
								    window.location.href="step.html?title=注册成功";
								
								}else
								{
								    alert('修改失败');
								}
							}
						});
						/**
			            jQuery.ajax(
			            {
			                url: "saveMember.action",
			                type:'POST',
			                dataType: 'json',
			                data:{
			                    'member.userName': username,
			                    'member.realName': realname,
			                    'member.cooptype' :cooptype,
			                    'member.password' :regpw
			                },
			                success: function(json){
			                    if(json['result']=='error') {
			                        //errcss(json['whereerror'],json['word']);
			                        sb=true;
			                    } else {
			                        sb=false;
			                        window.location.href="step.html?title=注册成功";
			                    }
			                }
			        });  **/  
		        }
				        
		  }
		  
		  
		function servies()
		{
		   var html = $($('#content').html());
		   $.lightbox(html, {
			    width   : 740,
			    height  : 660
		   });
			  
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
						用户注册
					</h1>
				</div>
				
			</div>
		</div>
		<div class="container_12">

			<div class="grid_12">
				<div class="info_box_head ib_green">
					<font style="color: white;">用户注册</font>
				</div>
				<div class="info_box ib_green">

					<div id="main">
						<div id="content-area">
							<form method="post" id="pp-form" action="saveMember.action" class="pp-form">
								<div>
									<label for="reg-un">
										手机号
									</label>
									<span class="required">*</span> 
									<input name="member.userName" id="username"
										class="validate[required,custom[phone],minSize[11],maxSize[11],ajax[ajaxUserCall]]"  maxlength="11">
									<span id="usernameshow">&nbsp;</span>
								</div>
								<span class="form-tip">请熟入11位的手机号码。</span>
								<div>
									<label for="reg-un">
										姓名
									</label>
									<span class="required">*</span>
									<input name="member.realName" class="validate[required,minSize[6]]" id="realname">
									<span id="realnameshow">&nbsp;</span>
								</div>
								<span class="form-tip">请填写的真实的姓名。</span>
								
								<div>
									<label for="member.sex">
										性别
									</label>
									<span class="required">*</span> 
									<s:select list="listDictBuss" cssClass="validate[required]" headerKey="" headerValue="请选择" listKey="dictId" listValue="dictName" name="member.sex" id="sex"></s:select>
									<span id="sexshow">&nbsp;</span>
								</div>
								<span class="form-tip">请选择性别。</span>
								
								<div>
									<label for="reg-email">
										合作者类型
									</label>
									<span class="required">*</span>
									<s:select list="listDictBusstype" cssClass="validate[required]" headerKey="" headerValue="请选择" listKey="dictId" listValue="dictName" name="member.cooptype" id="cooptype"></s:select>
									<span id="cooptypeshow">&nbsp;</span>
								</div>
								<span class="form-tip">选择合作者类型。</span>
								
								<div>
									<label for="reg-pw">
										密码
									</label>
									<span class="required">*</span>
									<input id="regpw" name="member.password" type="password" 
										class="validate[required,minSize[4]]">
									<span id="regpwshow">&nbsp;</span>
								</div>
								<span class="form-tip">请输入4位以上字符，不允许空格。</span>
								<div>
									<label for="reg-pw">
										确认密码
									</label>
									<span class="required">*</span>
									<input id="con-pw" name="con-pw" type="password"
										class="validate[required,equals[regpw]]">
									<span id="con-pwshow">&nbsp;</span>
								</div>
								<span class="form-tip">请重复输入以上密码。</span>
								
								
							

								<div>
									<input name="agrees" type="checkbox"
										class="validate[required] checkbox" id="agrees"
										checked="checked">
									<span class="notice" style="height: 30px; line-height: 30px;"><strong>我已经阅读并同意<a
											href="javascript:(0)" onclick="servies();"
											class="blue bold">《本草品味用户协议和服务条款》</a>
									</strong> </span>
									<span id="agreesshow">&nbsp;</span>
								</div>
								<div style="padding-left: 150px; padding-top: 20px;">
										<a class="smk_button" href="javascript:void(0)" id="reg-btn">立即注册</a>
								</div>
							</form>
						</div>
					</div>
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
	    <%@include file="bottom.jsp"%>
		
		
		<div id="content" style="display:none">
		<p align="center"><strong><font  color="#000000" size="+2">用户协议</font></strong></p>
    	    <p><strong> 一、总则</strong><br>
    	      <strong>·</strong> 1．1　用户应当同意本协议的条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意"按钮即表示用户与南京凯之渡信息技术有限公司（以下简称凯之渡）达成协议，完全接受本协议项下的全部条款。<br>
    	      
    	      ·                     1．2　用户注册成功后，凯之渡将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。<br>
    	      
    	      ·                     1．3　用户可以使用凯之渡各个频道单项服务，当用户使用凯之渡各单项服务时，用户的使用行为视为其对该单项服务的服务条款以及凯之渡在该单项服务中发出的各类公告的同意。<br>
    	      
    	      ·                     1．4　凯之渡会员服务协议以及各个频道单项服务条款和公告可由凯之渡公司随时更新，且无需另行通知。您在使用相关服务时,应关注并遵守其所适用的相关条款。
    	      
    	      您在使用凯之渡提供的各项服务之前，应仔细阅读本服务协议。如您不同意本服务协议及/或随时对其的修改，您可以主动取消凯之渡提供的服务；您一旦使用凯之渡服务，即视为您已了解并完全同意本服务协议各项内容，包括凯之渡对服务协议随时所做的任何修改，并成为凯之渡用户。<br>
    	      
    	      <strong>二、注册信息和隐私保护</strong><br>
    	      ·                     2．1　凯之渡帐号（即凯之渡用户ID）的所有权归凯之渡，用户完成注册申请手续后，获得凯之渡帐号的使用权。用户应提供及时、详尽及准确的个人资料，并不断更新注册资料，符合及时、详尽准确的要求。所有原始键入的资料将引用为注册资料。如果因注册信息不真实而引起的问题，并对问题发生所带来的后果，凯之渡不负任何责任。
    	      <br>      
    	      ·                     2．2　用户不应将其帐号、密码转让或出借予他人使用。如用户发现其帐号遭他人非法使用，应立即通知凯之渡。因黑客行为或用户的保管疏忽导致帐号、密码遭他人非法使用，凯之渡不承担任何责任。<br>
        ·                     2．3　凯之渡不对外公开或向第三方提供单个用户的注册资料，除非：</p>
    	    <p> ·                     （1）事先获得用户的明确授权；        </p>
    	    <p>·                     （2）只有透露你的个人资料，才能提供你所要求的产品和服务；</p>
    	    <p> ·                     （3）根据有关的法律法规要求；</p>
    	    <p> ·                     （4）按照相关政府主管部门的要求；</p>
    	    <p> ·                     （5）为维护凯之渡的合法权益。</p>
    	    <p> ·                     2．4　在你注册凯之渡帐户，使用其他凯之渡产品或服务，访问凯之渡网页, 或参加促销和有奖游戏时，凯之渡会收集你的个人身份识别资料，并会将这些资料用于：改进为你提供的服务及网页内容。</p>
    	    <p><strong> 三、使用规则</strong></p>
    	    <p> ·                     3．1　用户在使用凯之渡服务时，必须遵守中华人民共和国相关法律法规的规定，用户应同意将不会利用本服务进行任何违法或不正当的活动，包括但不限于下列行为∶</p>
    	    <p> ·                     （1）上载、展示、张贴、传播或以其它方式传送含有下列内容之一的信息：        </p>
    	    <p>·                     1） 反对宪法所确定的基本原则的；</p>
    	    <p> ·                     2） 危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；</p>
    	    <p> ·                     3） 损害国家荣誉和利益的；</p>
    	    <p> ·                     4） 煽动民族仇恨、民族歧视、破坏民族团结的；</p>
    	    <p> ·                     5） 破坏国家宗教政策，宣扬邪教和封建迷信的；        </p>
    	    <p>·                     6） 散布谣言，扰乱社会秩序，破坏社会稳定的；</p>
    	    <p> ·                     7） 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；        </p>
    	    <p>·                     8） 侮辱或者诽谤他人，侵害他人合法权利的；</p>
    	    <p> ·                     9） 含有虚假、有害、胁迫、侵害他人隐私、骚扰、侵害、中伤、粗俗、猥亵、或其它道德上令人反感的内容；        </p>
    	    <p>·                     10） 含有中国法律、法规、规章、条例以及任何具有法律效力之规范所限制或禁止的其它内容的；        </p>
    	    <p>·                     （2）不得为任何非法目的而使用网络服务系统；        </p>
    	    <p>·                     （3）不利用百度服务从事以下活动：        </p>
    	    <p>·                     1）未经允许，进入计算机信息网络或者使用计算机信息网络资源的；        </p>
    	    <p>·                     2） 未经允许，对计算机信息网络功能进行删除、修改或者增加的；        </p>
    	    <p>·                     3） 未经允许，对进入计算机信息网络中存储、处理或者传输的数据和应用程序进行删除、修改或者增加的；</p>
    	    <p> ·                     4） 故意制作、传播计算机病毒等破坏性程序的；        </p>
    	    <p>·                     5） 其他危害计算机信息网络安全的行为。</p>
    	    <p> ·                     3．2　用户违反本协议或相关的服务条款的规定，导致或产生的任何第三方主张的任何索赔、要求或损失，包括合理的律师费，您同意赔偿凯之渡与合作公司、关联公司，并使之免受损害。对此，凯之渡有权视用户的行为性质，采取包括但不限于删除用户发布信息内容、暂停使用许可、终止服务、限制使用、回收凯之渡帐号、追究法律责任等措施。对恶意注册凯之渡帐号或利用凯之渡帐号进行违法活动、捣乱、骚扰、欺骗、其他用户以及其他违反本协议的行为，凯之渡有权回收其帐号。同时，凯之渡公司会视司法部门的要求，协助调查。</p>
    	    <p> ·                     3．3　用户不得对本服务任何部分或本服务之使用或获得，进行复制、拷贝、出售、转售或用于任何其它商业目的。        </p>
    	    <p>·                     3．4　用户须对自己在使用凯之渡服务过程中的行为承担法律责任。用户承担法律责任的形式包括但不限于：对受到侵害者进行赔偿，以及在凯之渡公司首先承担了因用户行为导致的行政处罚或侵权损害赔偿责任后，用户应给予凯之渡公司等额的赔偿。        </p>
    	    <p><strong>四、服务内容</strong></p>
    	    <p> ·                     4．1　凯之渡网络服务的具体内容由凯之渡根据实际情况提供。</p>
    	    <p> ·                     4．2　除非本服务协议另有其它明示规定，凯之渡所推出的新产品、新功能、新服务，均受到本服务协议之规范。        </p>
    	    <p>·                     4．3　为使用本服务，您必须能够自行经有法律资格对您提供互联网接入服务的第三方，进入国际互联网，并应自行支付相关服务费用。此外，您必须自行配备及负责与国际联网连线所需之一切必要装备，包括计算机、数据机或其它存取装置。        </p>
    	    <p>·                     4．4　鉴于网络服务的特殊性，用户同意凯之渡有权不经事先通知，随时变更、中断或终止部分或全部的网络服务（包括收费网络服务）。凯之渡不担保网络服务不会中断，对网络服务的及时性、安全性、准确性也都不作担保。        </p>
    	    <p>·                     4．5　凯之渡需要定期或不定期地对提供网络服务的平台或相关的设备进行检修或者维护，如因此类情况而造成网络服务（包括收费网络服务）在合理时间内的中断，凯之渡无需为此承担任何责任。凯之渡保留不经事先通知为维修保养、升级或其它目的暂停本服务任何部分的权利。        </p>
    	    <p>·                     4．6 本服务或第三人可提供与其它国际互联网上之网站或资源之链接。由于凯之渡无法控制这些网站及资源，您了解并同意，此类网站或资源是否可供利用，凯之渡不予负责，存在或源于此类网站或资源之任何内容、广告、产品或其它资料，凯之渡亦不予保证或负责。因使用或依赖任何此类网站或资源发布的或经由此类网站或资源获得的任何内容、商品或服务所产生的任何损害或损失，凯之渡不承担任何责任。
    	      
        ·                     4．7 用户明确同意其使用凯之渡网络服务所存在的风险将完全由其自己承担。用户理解并接受下载或通过凯之渡服务取得的任何信息资料取决于用户自己，并由其承担系统受损、资料丢失以及其它任何风险。凯之渡对在服务网上得到的任何商品购物服务、交易进程、招聘信息，都不作担保。</p>
    	    <p> ·                     4．8 用户须知：凯之渡提供的各种挖掘推送服务中（包括凯之渡新首页的导航网址推送），推送给用户曾经访问过的网站或资源之链接是基于机器算法自动推出，凯之渡不对其内容的有效性、安全性、合法性等做任何担保。</p>
    	    <p> ·                     4．9　6个月未登陆的帐号，凯之渡保留关闭的权利。</p>
    	    <p> ·                     4．10　凯之渡有权于任何时间暂时或永久修改或终止本服务（或其任何部分），而无论其通知与否，凯之渡对用户和任何第三人均无需承担任何责任。        </p>
    	    <p>·                     4．11　终止服务
    	      
        ·                     您同意凯之渡得基于其自行之考虑，因任何理由，包含但不限于长时间未使用，或凯之渡认为您已经违反本服务协议的文字及精神，终止您的密码、帐号或本服务之使用（或服务之任何部分），并将您在本服务内任何内容加以移除并删除。您同意依本服务协议任何规定提供之本服务，无需进行事先通知即可中断或终止，您承认并同意，凯之渡可立即关闭或删除您的帐号及您帐号中所有相关信息及文件，及/或禁止继续使用前述文件或本服务。此外，您同意若本服务之使用被中断或终止或您的帐号及相关信息和文件被关闭或删除，凯之渡对您或任何第三人均不承担任何责任。</p>
    	    <p><strong> 五、知识产权和其他合法权益（包括但不限于名誉权、商誉权）</strong></p>
    	    <p>·                     5．1　用户专属权利
    	      
    	      ·                     凯之渡尊重他人知识产权和合法权益，呼吁用户也要同样尊重知识产权和他人合法权益。若您认为您的知识产权或其他合法权益被侵犯，请按照以下说明向凯之渡提供资料∶
    	      
    	      ·                     请注意：如果权利通知的陈述失实，权利通知提交者将承担对由此造成的全部法律责任（包括但不限于赔偿各种费用及律师费）。如果上述个人或单位不确定网络上可获取的资料是否侵犯了其知识产权和其他合法权益，凯之渡建议该个人或单位首先咨询专业人士。为了凯之渡有效处理上述个人或单位的权利通知，请使用以下格式（包括各条款的序号）：
    	      
    	      ·                     1. 权利人对涉嫌侵权内容拥有知识产权或其他合法权益和/或依法可以行使知识产权或其他合法权益的权属证明；</p>
    	    <p> ·                     2. 请充分、明确地描述被侵犯了知识产权或其他合法权益的情况并请提供涉嫌侵权的第三方网址（如果有）。   	      </p>
    	    <p>·                     3. 请指明涉嫌侵权网页的哪些内容侵犯了第2项中列明的权利。</p>
    	    <p> ·                     4. 请提供权利人具体的联络信息，包括姓名、身份证或护照复印件（对自然人）、单位登记证明复印件（对单位）、通信地址、电话号码、传真和电子邮件。</p>
    	    <p> ·                     5. 请提供涉嫌侵权内容在信息网络上的位置（如指明您举报的含有侵权内容的出处，即：指网页地址或网页内的位置）以便我们与您举报的含有侵权内容的网页的所有权人/管理人联系。   	      </p>
    	    <p>·                     6. 请在权利通知中加入如下关于通知内容真实性的声明： “我保证，本通知中所述信息是充分、真实、准确的，如果本权利通知内容不完全属实，本人将承担由此产生的一切法律责任。”</p>
    	    <p> ·                     7. 请您签署该文件，如果您是依法成立的机构或组织，请您加盖公章。
    	      
   	      ·                     请您把以上资料和联络方式扫描发往以下Email地址：office@can2do.com　　</p>
    	    <p> ·                     5．2　对于用户通过凯之渡服务（包括但不限于论坛等）上传到凯之渡网站上可公开获取区域的任何内容，用户同意凯之渡在全世界范围内具有免费的、永久性的、不可撤销的、非独家的和完全再许可的权利和许可，以使用、复制、修改、改编、出版、翻译、据以创作衍生作品、传播、表演和展示此等内容（整体或部分），和/或将此等内容编入当前已知的或以后开发的其他任何形式的作品、媒体或技术中。
    	      
   	      ·                     5．3　凯之渡拥有本网站内所有资料的版权。任何被授权的浏览、复制、打印和传播属于本网站内的资料必须符合以下条件：</p>
    	    <p> ·                     （1） 所有的资料和图象均以获得信息为目的；</p>
   	      <p> ·                     （2） 所有的资料和图象均不得用于商业目的；   	      </p>
    	    <p>·                     （3） 所有的资料、图象及其任何部分都必须包括此版权声明；   	      </p>
    	    <p>·                     （4） 本网站（www.can2do.com）所有的产品、技术与所有程序均属于凯之渡知识产权，在此并未授权。   	      </p>
    	    <p>·                     （5） “凯之渡”, “can2do”及相关图形等为凯之渡的商标。   	      </p>
    	    <p>·                     （6） 未经凯之渡许可，任何人不得擅自（包括但不限于：以非法的方式复制、传播、展示、镜像、上载、下载）使用。否则，凯之渡将依法追究法律责任。
    	      
    	      六、青少年用户特别提示
    	      ·                     青少年用户必须遵守全国青少年网络文明公约：</p>
    	    <p> ·要善于网上学习，不浏览不良信息；</p>
    	    <p>要诚实友好交流，不侮辱欺诈他人；</p>
    	    <p>要增强自护意识，不随意约会网友；</p>
    	    <p>要维护网络安全，不破坏网络秩序；</p>
    	    <p>要有益身心健康，不沉溺虚拟时空。 </p>
    	    <p><strong>七、其他   	      </strong></p>
    	    <p>·                     7．1　本协议的订立、执行和解释及争议的解决均应适用中华人民共和国法律。</p>
    	    <p> ·                     7．2　如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协商不成时，任何一方均可向凯之渡所在地的人民法院提起诉讼。</p>
    	    <p> ·                     7．3　凯之渡未行使或执行本服务协议任何权利或规定，不构成对前述权利或权利之放弃。</p>
    	    <p> ·                     7．4　如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，本协议的其余条款仍应有效并且有约束力。
    	      
    	      ·                     请您在发现任何违反本服务协议以及其他任何单项服务的服务条款、凯之渡各类公告之情形时，通知凯之渡。您可以通过如下联络方式同凯之渡联系∶
    	      
    	      <strong>·                     Email:office@can2do.com
    	      </p>
              </strong></p>
           </div>   
              
	</body>
</html>