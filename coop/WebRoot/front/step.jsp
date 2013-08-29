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
		<script type="text/javascript" src="front/plugins/cityselect/js/jquery.cityselect.js"></script>
		<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
		
		<!--General scripts header-->

		<!--[if IE]>
	<script type="text/javascript" src="front/js/html5.js"></script>
	<style type="text/css">.testimonial_arrow{display: none!important;}</style>
	<![endif]-->


		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<script>
		
		function  saveform()
		{
		   $('#pp-form').form('submit',{
				url: 'savestep.action',
				onSubmit: function(){  
				    var city = $('#city').val();
				    var dist = $('#dist').val();
				    var val = $('#prov').val()+(city==null?'':' '+city)+(dist==null?'':' '+dist);
				    $("#area").val(val);
					return checkform();
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
					    $('#img').html("<img src='attach/productpic/"+result.mess+"'>")
					    alert('操作成功');
					    window.location.href="index.html";
					
					}else
					{
					    alert('操作失败');
					}
				}
			});
		}
		
		
		 function checkform()
	    {
	       var companyname = $('#companyname');
	       var dlogo = $('#dlogo');
	       var sex = $('#sex');
	       var prov = $('#prov');
	       
	       var address = $('#address');
	       if(companyname.val()=='')
	       {
	          alert('公司名称不能为空');
	          companyname.focus();
	          return false;
	       }
	       if(dlogo.val()=='')
	       {
	          alert('品牌LOGO不能为空');
	          dlogo.focus();
	          return false;
	       }
	       if($('#prov').val()=='')
	       {
	          alert('请选择地区');
	          return false;
	       }
	       if($('#address').val()=='')
	       {
	          //$('#mid').html('验证码不能为空');
	          alert('邮寄地址不能为空');
	          address.focus();
	          return false;
	       }
	       return true;
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
                        <div style="text-align: center;"> 注册成功！开通空间必须完善其他信息 <a href="index.html" style="color:red">去首页</a></div>
						<div id="main">
						<div id="content-area">
							<form method="post" id="pp-form"  class="pp-form" enctype="multipart/form-data">
							    <input type="hidden" name="member.id" value="${session.member.id}">
							   
							    <div>
									<label for="member.mphone">
										公司名称
									</label>
									<span class="required">*</span> 
									<input type="text" name="member.companyname" id="companyname">
								</div>
								<span class="form-tip">请输入公司或单位名称。</span>
								
								<div>
									<label for="member.logo">
										品牌LOGO
									</label>
									<span class="required">*</span> 
									<input type="file" name="dlogo" id="dlogo">
									
								</div>
								<span id="img" class="form-tip"></span>
								<span class="form-tip">请上传品牌LOGO。</span>
								
								<div>
									<label for="member.address">
										地区
									</label>
									<span class="required">*</span> 
									 <div id="city1">
								  		<select class="prov" id="prov"></select> 
								    	<select class="city" id="city" disabled="disabled"></select>
								        <select class="dist" id="dist" disabled="disabled"></select>
								    </div>
								    <input type="hidden" name="member.area" id="area">
									<script>
										$("#city1").citySelect({
											nodata:"none",
											required:false
										});
	
									</script>
								</div>
								<span class="form-tip">请选择地区。</span>
								
								<div>
									<label for="member.address">
										邮寄地址
									</label>
									<span class="required">*</span> 
									<input type="text" name="member.address" id="address">
								</div>
								<span class="form-tip">请输入邮寄地址。</span>
								
								<div>
									<label for="member.mphone">
										备用手机号
									</label>
									<span class="required"></span> 
									<input type="text" name="member.mphone" id="mphone">
								</div>
								<span class="form-tip">请输入备用手机号。</span>
								
								<div>
									<label for="member.email">
										电子邮箱
									</label>
									<span class="required"></span> 
									<input id="regpw" name="member.email" type="text">
								</div>
								<span class="form-tip">请输入邮寄地址。</span>
								<div>
									<label for="member.remark">
										备注
									</label>
									<span class="required"></span> 
									<input id="remark" name="member.remark" type="text">
								</div>
								<span class="form-tip">其他说明。</span>
								
								<div style="padding-left: 150px; padding-top: 20px;">
										<a class="smk_button" href="javascript:void(0)" onclick="saveform();" id="reg-btn">保存</a>
								</div>
								<s:token></s:token>
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
	</body>
</html>