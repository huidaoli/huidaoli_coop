<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		
	<script type="text/javascript">
	    $(function(){
			$('#tt').propertygrid({
				width:800,
				height:400,
				url:'sys/getSysConfingData.action',
				columns : [[{
							field : "key",
							title : "配置项",
							width : 250,
							sortable : true
						}, {
							field : "value",
							title : "属性值",
							width : 530,
							resizable : false
						}]],
				showGroup:true,
				scrollbarSize:0
			
				
				
			});
		});
		function showGroup(){
			$('#tt').propertygrid({
				showGroup:true
			});
		}
		function hideGroup(){
			$('#tt').propertygrid({
				showGroup:false
			});
		}
		function hideHeader(){
			$('#tt').propertygrid({
				showHeader:false
			});
		}
		function saveProperty(){
			var s = '';
			var arr = [];
			var rows = $('#tt').propertygrid('getChanges');
			
			for(var i=0; i<rows.length; i++){
			   
			    s = "{"+"id:"+rows[i].id+",value:'"+rows[i].value+"'}";
			   
			    arr.push(s);
			}
			
			
			var str = "["+arr.join(",")+"]";
			
			
			$.post('sys/saveConfing.action',{jsonData:str},function(result){
				if (result.success){
					tAlert('信息','保持成功');
				} else {
					tAlert('信息','删除失败');
				}
			},'json');
			
			
			
		}
		
		 function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
	   
	</script>
</head>
<body>
	<div style="margin:10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="saveProperty()">保存</a>
		
	</div>
	<table id="tt"></table>
	
	
</body>
</html>