<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script type="text/javascript" src="front/js/jquery.jui.form.js"></script>
<script type="text/javascript">
	   function saveOrUpdate(){
			$('#fm').form('submit',{
				url: 'updateContent.action',
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
					
						alert('保存成功');
						
					} else {
						alert('保存失败');
					}
				}
			});
		}
		function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
		$(function(){
		    $(".easyui-linkbutton").linkbutton({  
			     iconCls: "icon-save",
			     plain:true 
			  }); 
		
		});
		  
	</script>
<h4 class="widget-title2">${title}</h4>
<hr />
<form id="fm" method="post">
    <input type="hidden" name="content.id" value="<s:property value="content.id" default="0"/>" />
    <input type="hidden" name="content.typeid" value="<s:property value="content.typeid"/>" />
    <input type="hidden" name="content.coopid" value="<s:property value="content.coopid"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		
		<tr>
			<td style="height:500px;">
				内容:
			</td>
			<td style="vertical-align: top;">
			<FCK:editor instanceName="content.content" height="450">
				<jsp:attribute name="value">
				<s:property value="content.content" escape="false"/>
				</jsp:attribute>
			</FCK:editor>
			
			</td>
			
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="saveOrUpdate()">保存</a>
			</td>
			
		</tr>
	</table>
</form>
	