<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>设备台账</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/demo.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
	<link rel="stylesheet" type="text/css" href="../themes/file.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		
	<script type="text/javascript">
		$(function(){
		    //var temp = 0;
		    //$('#loading').html("<img src='../themes/icons/loading.gif'/>loading...");
			$('#tt2').tree({
				url: 'buse/getEquipmentTreeData.action',
				onClick:function(node){
					//$(this).tree('toggle', node.target);
					open(node.id);
				},
				onLoadSuccess:function()
				{
				   //if((temp++)==1){
				     //$('#loading').remove();
				   //}
				}
			});
		});
		function open(id)
		{
		   //div
		   //$('#equmentdetail_id').html("<img src='../themes/icons/loading.gif'/>loading...");
		   $('#equmentdetail_id').load("buse/getEqumentDetailInfo.action?id="+id);
		   
		   //iframe
		   //$('#cc').attr('src',"buse/getEqumentDetail.action?id="+id);
		   
		}
	</script>
	
	<style type="text/css">
	  .equmentinfo{
			width:250px;
			height:680px;
			float:left;
			background:#fff;
			border:1px solid #ccc;
			border-radius:5px;
			-moz-border-radius:5px;
			-webkit-border-radius: 5px;
			overflow: scroll;
		}
	   
		.equmentdetail{
			width:690px;
			height:680px;
			margin-left:10px;
			float:left;
			background:#fff;
			border:1px solid #ccc;
			border-radius:5px;
			-moz-border-radius:5px;
			-webkit-border-radius: 5px;
			overflow-y: scroll;
			
		}
		body{
		   overflow: hidden;
		}
	</style>
</head>
<body>
   
<div  class="equmentinfo" style="">
   
          <div id="loading"></div>
          
          <ul id="tt2"></ul>
   
</div>

<div class="equmentdetail" id="equmentdetail_id" style="padding-top:5px;padding-left:5px;">
   <!--
   <iframe id="cc" frameborder="0" style="width:100%;height:100%" scrolling="auto"></iframe>
   -->
   
</div>
	
	
</body>
</html>