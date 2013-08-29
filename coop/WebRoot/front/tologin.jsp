<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<style>
.pp-form {
	margin: 40px 60px 0 60px;
	padding-bottom:40px;
}

.pp-form div {
	height: 30px;
	line-height: 30px;
	padding-top: 5px;
}

.pp-form label {
	display: block;
	width: 62px;
	height: 30px;
	line-height: 30px;
	text-align: right;
	color: #666;
	font-size: 12px;
	float: left;
	padding-right: 5px;
	vertical-align: middle;
}

.pp-form input {
	width: 160px;
	line-height: 20px;
	border: #b6cddd 1px solid;
	padding: 4px;
	float: left;
}
#content-area{
 margin-top:10px;
  border:#999 1px solid;
}
</style>
<script>
    function checkform()
    {
       var user = $('#username');
       var pass = $('#password');
       var code = $('#code');
       if(user.val()=='')
       {
          //$('#mid').html('邮箱不能为空');
          //window.setInterval("clear()",2000);
          alert('手机不能为空');
          user.focus();
          return false;
       }
       if($('#password').val()=='')
       {
          //$('#mid').html('密码不能为空');
          alert('密码不能为空');
          pass.focus();
          return false;
       }
       if($('#code').val()=='')
       {
          //$('#mid').html('验证码不能为空');
          alert('验证码不能为空');
          code.focus();
          return false;
       }
       return true;
    }
    
    function sub()
    {
       
       
       $('#pp-form').form('submit',{
				url: 'memLogin.action',
				onSubmit: function(){
					return checkform();
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.res=="0"){
					
					    $('#horizontal').load("refreshLoginInfo.action");
			            $.lightbox().close();
			
					
					}
					if (result.res=="1"){
					
					   alert('验证码错误');
					   $("#verify_img").click();
					
					}
					if (result.res=="2"){
					
					   alert('用户密码错误');
					   $("#verify_img").click();
					
					}
					if (result.res=="3"){
					
					   alert('账号被冻结，请联系管理员');
					   $("#verify_img").click();
					
					}
				}
			});
			
    }
     
    
   function toRegist()
   {
      $.lightbox().close();
      window.open('register.html', "_blank", '');
      //window.location.target.href="";
   }
   
   
   function refresh(obj)
   {
       $(obj).attr("src", "servlet/CheckCode?n=4&w=60&h=30&rd=" + Math.random());
   }
    
</script>
<div id="content-area">
	<form method="post" id="pp-form" action="" class="pp-form">
		<div>
			<label for="reg-un">
				手机号
			</label>
			<input type="text" id="username" name="username" maxlength="11"/>
		</div>
		<div>
			<label for="reg-un">
				密&nbsp;&nbsp;&nbsp;&nbsp;码
			</label>
			<input type="password" id="password" name="password" />
		</div>
		<div>
			<label for="reg-un">
				验证码
			</label>
			<input style="width:135px;" type="text" id="code" name="code" />
			<img id="verify_img" src="servlet/CheckCode?n=4&w=60&h=30"
				style="width: 60px; height: 30px; vertical-align: middle; cursor: pointer"
				title="点击刷新" onclick="refresh(this);" />
		</div>
		<div style="padding-left: 100px;">
		<input type="submit" name="regsub" id="regsub" value="登录" onclick="sub();return false;" style="float:none; width:80px;height:30px;background:#A9DB80;color:#588134;font-weight: bold;cursor:pointer;">
	    <a href="javascript:void(0)" onclick="toRegist();">还没注册</a>
		</div>

	</form>
</div>



