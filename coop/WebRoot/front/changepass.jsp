<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" href="front/css/framework-min2.css" />
<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
<script>
		
		function  saveform()
		{
		   $('#saveid').form('submit',{
				url: 'savePass.action',
				onSubmit: function(){  
					return checkform();
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.res=="0"){
					   alert('修改成功')
					}
					if (result.res=="2"){
					   alert('原密码错误');
					}
				}
			});
		}
		
		
		function checkform()
	    {
	       var oldpass = $('#oldpass');
	       var newpass = $('#newpass');
	       var conpass = $('#conpass');
	       
	       if(oldpass.val()=='')
	       {
	          alert('原密码不能为空');
	          oldpass.focus();
	          return false;
	       }
	       if(newpass.val()=='')
	       {
	          alert('密码不能为空');
	          newpass.focus();
	          return false;
	       }
	       if(conpass.val()=='')
	       {
	          alert('确认密码不能为空');
	          conpass.focus();
	          return false;
	       }
	       return true;
	    }
			
</script>
<h4 class="widget-title2">${title}</h4>
<hr />
<form id="saveid" method="post">
<input type="hidden" name="id" value="${id}">
<input type="hidden" name="username" value="${username}">
<table>
<tr>
<td style="vertical-align: middle;text-align: right;" width="20%">原密码<font color="red">*</font>:</td><td><input type="password" name="oldpass" id="oldpass"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">新密码<font color="red">*</font>:</td><td><input type="password" name="newpass" id="newpass"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">确认密码<font color="red">*</font>:</td><td><input type="password" name="conpass" id="conpass"></td>
</tr>
<tr >
<td style="vertical-align: middle;text-align: center;" colspan="2">
<a class="smk_button" href="javascript:void(0)" id="reg-btn" onclick="saveform();">保存</a>
</td></td>
</tr>
</table>
</form>


