<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=com.base.frame.business.Init.getMap().get("title")%></title>
		<link rel="stylesheet" type="text/css"
			href="../themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../themes/icon.css">
		<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		<style type="text/css">
</style>
		<script type="text/javascript">
		var actions = {};
		<s:iterator value="#request.actions" var="x">
		   actions[<s:property value="#x.id"/>] = '<s:property value="#x.url"/>';
		</s:iterator>
		
		
			  function getUrl(node,treeId)
			  {
				var action = actions[node.id];
				if(!(action == undefined || action == "undefined" || action==''))
				{
				  openTabByName(action,node);
				}
				
			  }
			
			  function openTabByName(url,node){
			     
			    var tabname = node.text;
				if ($('#tt').tabs('exists',tabname)){
					$('#tt').tabs('select',tabname);
				} else {
				
				    var content = '<iframe scrolling="auto" id='+url+' frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>'; 
					
					$('#tt').tabs('add',{
						title:tabname,
						content:content,
						closable:true,
						plain:false,
						tools:[{
							iconCls:'icon-mini-refresh',
							handler:function(){
								var tab = $('#tt').tabs('getSelected'); // get selected panel
								$('#tt').tabs('update', {
								       tab: tab,
								       options: {
								       
									   }
								});
							}
						}]
						
					});
					
				}
				
			}
			
			
			function loginShow(){
				$.messager.show({
					title:'登陆信息',
					msg:'欢迎您：${sessionScope.user.realname}<br>本次登录IP：${loginIp}<br>本次登陆时间：${loginDate}<br>上次登录IP：${preLoginIp}<br>上次登陆时间：${preLoginDate}',
					timeout:5000,
					width:250,
					height:150,
					showType:'slide'
				});
		    }
			
			function logout(){
				
					$.messager.confirm('警告','确定退出吗?',function(r){
						if (r){
							$.post('loginOut.action',function(result){
								if (result.success){
									 window.location.replace("toLogin.action");
								} else {
									$.messager.show({	// show error message
										title: 'Error',
										msg: result.msg
									});
								}
							},'json');
						}
					});
			}
			
		  $(function(){
		     loginShow();
	         
		  });
		  
		  function about()
		  {
		     tAlert('关于','关于');
		  }
		  
		  function help()
		  {
		     tAlert('帮助','帮助');
		  }
		  
		  function tAlert(title,msg)
		 {
		     $.messager.alert(title,msg);
		 }
		  
		 
		window.onload = function() {
			$('#loading-mask').fadeOut("slow");
		};
		
		</script>
	</head>

	<body class="easyui-layout" style="text-align: left">
		<noscript>
			<div id="noscript">
				<img src="../themes/icons/1.gif"/>
			</div>
		</noscript>
		<!-- 页面加载 -->
		<div id="loading-mask">
			<div id="pageloading">
				<img src="../themes/icons/1.gif" align="absmiddle" />
				正在加载中,请稍候...
			</div>
		</div>

		<div region="north" border="false"
			style="text-align: center; height: 60px; background: #efefef; overflow: hidden;">
			<div id="logo"
				style="padding-top: 5px; padding-left: 5px; float: left">
				<img src="../images/new_logo.png">
			</div>
			<div style="margin: 30px 0; float: right; padding-right: 5px;">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-help'" onclick="help();">帮助</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-about'"
					onclick="about();">关于</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'"
					onclick="logout();">注销</a>

			</div>
		</div>

		<div region="west" split="true" title="菜单"
			style="width: 250px; padding1: 1px; overflow: hidden;">
			<div class="easyui-accordion" fit="true" border="false" id="aa">
				<s:iterator value="#request.menuLists" var="x" status="y">
					<div title="<s:property value="#x.name" escape="false"/>" style="overflow: auto;"  
					    <s:if test="#x.id==676">data-options="selected:true"</s:if> >
						<div id='loading<s:property value="#y.index+1"/>'></div>
						<ul id='tt<s:property value="#y.index+1"/>'></ul>
						<script type="text/javascript">
							$(function(){
							    $('#loading<s:property value="#y.index+1"/>').html("<img src='../themes/icons/loading.gif'/>loading...");
								$('#tt<s:property value="#y.index+1"/>').tree({
									url: 'getMenus.action?mid=<s:property value="#x.id"/>',
									onClick:function(node)
									{
									   getUrl(node,'#tt<s:property value="#y.index+1"/>');
									},
									onLoadSuccess:function()
									{
									   $('#loading<s:property value="#y.index+1"/>').remove();
									}
								});
							});
			             </script>
					</div>
				</s:iterator>
			</div>

		</div>
		<div region="center" border="false">
			<div id="tt" class="easyui-tabs" fit="true" border="true">
				<div title="欢迎" href="sysadmin/welcome.action" id="shxx">
				</div>
			</div>
		</div>
		<div region="south"
			style="height: 25px; padding: 5px; background: #efefef; text-align: center;overflow: hidden;">
			<%
			Calendar d = Calendar.getInstance();
			%>
			CopyRight © 2012-<%=d.get(Calendar.YEAR)%>
			reserved by Can2DO Information Technology Ltd. 南京凯之渡信息技术有限公司版权所有
		</div>
	</body>
</html>

