<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
function save400Number()
{
   var o = $('#fphone');
   if(o.val()=='')
   {
      alert('400电话不能为空');
      o.focus();
      return;
   }
   var id = '<s:property value="member.id"/>';
   var fphone = o.val();
   
   $.post('member/saveFphone.action',{id:id,fphone:fphone},function(result){
		if (result.success){
			tAlert('信息','保存成功');
		} else {
			tAlert('信息','操作失败');
		}
	},'json');

}
</script>
<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap">
				400电话:
			</td>
			<td>
			   <input type="text" name="member.fphone" value="<s:property value="member.fphone"/>" id="fphone">
			   <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save400Number()">保存</a>
			</td>
		</tr>
		<tr>
			<td nowrap="nowrap" width="50">
				用户名:
			</td>
			<td>
			   <s:property value="member.userName"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				姓名:
			</td>
			<td>
				<s:property value="member.realName"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				性别:
			</td>
			<td>
				<s:iterator value="listDictBuss" var="x">
					<s:if test="#x.dictId == member.sex">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				合作者类型
			</td>
			<td>
				<s:iterator value="listDictBusstype" var="x">
					<s:if test="#x.dictId == member.cooptype">
					  <s:property value="#x.dictName"/> 
					</s:if>
				</s:iterator>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				公司名称:
			</td>
			<td>
				<s:property value="member.companyname"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				公司LOGO:
			</td>
			<td>
				<img src='attach/productpic/<s:property value="member.logo"/>'>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				地区:
			</td>
			<td>
				<s:property value="member.area"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				邮寄地址:
			</td>
			<td>
				<s:property value="member.address"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				备用手机:
			</td>
			<td>
			 <s:property value="member.mphone"/>
			</td>
			
		</tr>
		
		<tr>
			<td nowrap="nowrap">
				电子邮箱:
			</td>
			<td>
				 <s:property value="member.email"/>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap">
				备注:
			</td>
			<td>
			   <div style="height:100px;">
			       <s:property value="member.remark"/>
			   </div>
			
			</td>
		</tr>
		
	</table>
</form>
