<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>更新</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="../page/upload/gener.js"></script>
		<script src="../js/jquery.Jcrop.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../themes/jquery.Jcrop.css" type="text/css" />
	<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
	<script type="text/javascript">
	   function saveOrUpdate(){
			$('#fm').form('submit',{
				url: 'manacont/save.action',
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the resource data
						
					} else {
						tAlert('信息','保存失败')
					}
				}
			});
		}
		function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
	</script>

<body>
<form id="fm" method="post">
    <input type="hidden" name="content.id" value="<s:property value="content.id" default="0"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		
		<tr>
			<td>
				日期:
			</td>
			<td>
				<input name="content.createdate" type="text" class="easyui-datebox" required="required" value="<s:date name="content.createdate" format="yyyy-MM-dd" />">
			</td>
			
		</tr>
		
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
					<a href="#" class="easyui-linkbutton" onclick="saveOrUpdate()">保存</a>
			</td>
			
		</tr>
	</table>
</form>
</body>
</html>

