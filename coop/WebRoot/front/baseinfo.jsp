<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" href="front/css/framework-min2.css" />
<script type="text/javascript" src="front/plugins/cityselect/js/jquery.cityselect.js"></script>
<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
<script>
		
		function  saveform()
		{
		   $('#saveid').form('submit',{
				url: 'updateMember.action',
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
					    alert('修改成功');
					
					}else
					{
					    alert('修改失败');
					}
				}
			});
		}
		
		
		 function checkform()
	    {
	       var realName = $('#realName');
	       var cooptype = $('#cooptype');
	       var address = $('#address');
	       var companyname = $('#companyname');
	       var sex = $('#sex');
	       var prov = $('#prov');
	       
	       if(realName.val()=='')
	       {
	          alert('姓名不能为空');
	          realName.focus();
	          return false;
	       }
	       if(sex.val()=='')
	       {
	          alert('请选择性别');
	          return false;
	       }
	       if(cooptype.val()=='')
	       {
	          alert('请选择合作类型');
	          return false;
	       }
	       if(companyname.val()=='')
	       {
	          alert('公司名称不能为空');
	          companyname.focus();
	          return false;
	       }
	       if($('#prov').val()=='')
	       {
	          alert('请选择地区');
	          return false;
	       }
	       if($('#address').val()=='')
	       {
	          alert('邮寄地址不能为空');
	          address.focus();
	          return false;
	       }
	       return true;
	    }
			
</script>
<h4 class="widget-title2">${title}</h4>
<hr />
<form id="saveid" action="updateMember.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="member.id" value="<s:property value="member.id"/>">
<table>
<tr>
<td style="vertical-align: middle;text-align: right;" width="20%">400电话:</td><td style="height:40px;vertical-align: middle;"><s:property value="member.fphone"/>
<font color="red">(渡之珍分配)</font>
</td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;" width="20%">用户名:</td>
<td style="height:40px;vertical-align: middle;">
<input type="hidden" name="member.userName" id="userName" value="<s:property value="member.userName"/>">
<s:property value="member.userName"/>
</td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">姓名<font color="red">*</font>:</td><td><input type="text" name="member.realName" id="realName" value="<s:property value="member.realName"/>"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">性别<font color="red">*</font>:</td>
<td>
<s:select list="listDictBuss" headerKey="" headerValue="请选择" listKey="dictId" listValue="dictName" name="member.sex" id="sex"></s:select>
</td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">合作者类型<font color="red">*</font>:</td>
<td><s:select list="listDictBusstype" headerKey="" headerValue="请选择" listKey="dictId" listValue="dictName" name="member.cooptype" id="cooptype"></s:select></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">公司名称<font color="red">*</font>:</td><td><input type="text" name="member.companyname" id="companyname" value="<s:property value="member.companyname"/>"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">公司LOGO<font color="red">*</font>:</td>
<td>
<input type="file" name="logo" id="logo">
<input type="hidden" name="member.logo" value="<s:property value="member.logo"/>">
<s:if test="member.logo!=null">
<span id="img"><img src='attach/productpic/<s:property value="member.logo"/>'></span>
</s:if>
</td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">地区<font color="red">*</font>:</td><td>
<div id="city1">
 	<select class="prov" id="prov"></select> 
   	<select class="city" id="city" disabled="disabled"></select>
    <select class="dist" id="dist" disabled="disabled"></select>
   </div>
   <input type="hidden" name="member.area" id="area" value="<s:property value="member.area"/>">
<script>
    var val = $('#area').val();
    var arr = val.split(" ");
    //alert(arr[0] + arr[0] + arr[2]);
	$("#city1").citySelect({
		nodata:"none",
		prov:arr[0], 
    	city:arr[1],
		dist:arr[2],
		required:false
	});

</script>
</td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">邮寄地址<font color="red">*</font>:</td><td><input type="text" name="member.address" id="address" value="<s:property value="member.address"/>"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">备用手机:</td><td><input type="text" name="member.mphone" id="mphone" value="<s:property value="member.mphone"/>"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">电子邮箱:</td><td><input type="text" name="member.email" id="email" value="<s:property value="member.email"/>"></td>
</tr>
<tr>
<td style="vertical-align: middle;text-align: right;">备注:</td><td><input type="text" name="member.remark" id="remark" value="<s:property value="member.remark"/>"></td>
</tr>
<tr >
<td style="vertical-align: middle;text-align: center;" colspan="2">
<a class="smk_button" href="javascript:void(0)" id="reg-btn" onclick="saveform();">保存</a>
</td></td>
</tr>
</table>
	
</form>


