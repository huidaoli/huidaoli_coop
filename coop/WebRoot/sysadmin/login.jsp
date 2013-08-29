<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width:100%;height:100%;overflow:hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=com.base.frame.business.Init.getMap().get("title")%></title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
	<script type="text/javascript" src="../jquery.js"></script>
	<script type="text/javascript" src="../jquery-migrate.js"></script>
	<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		#fm{
			margin:0;
			padding:30px 30px;
		}
		
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
		.fitem input{
			width:150px;
		}
		
		body {
		    margin: 0;
		    text-align:center;
			background-color: #f8fcff;
			background-image: url(../images/b1.gif);
			background-repeat: repeat-x;
			background-position:0 -620px;
		}
		
		.bottom {
			background-image: url(../images/b1.gif);
			background-repeat: repeat-x;
			background-position: 0px -501px;
			height: 50px;
			width: 100%;
		}
		
	</style>
</head>

<script>
   function login(){
			$('#fm').form('submit',{
				url: 'login.action',
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
				    var result = eval('('+result+')');
					if (result.res=="1"){
					     //var width = parseInt(window.screen.availWidth);
    	                 //var height = parseInt(window.screen.availHeight);
    	                 //var spec = "resizable=yes,location=no,toolbar=no,status=yes,left=0,top=0,width=" + width + ",height=" + height;
    	                 //var newWindow = window.open("index.action","_blank",spec);
    	                 //newWindow.resizeTo(width + 5, height + 5);
    	                 //window.opener = "";
    	                 //window.open("","_self");
    	                 //window.close();
    	                 window.location ="index.action";
					  
					}
					else if (result.res=="2")
					{
					      $.messager.alert("信息","验证码错误");
					      $("#verify_img").click();
					}
					else
					{
					      $.messager.alert("信息","用户名或密码错误");
					      $("#verify_img").click();
					}
					
				}
			});
	}
	
	function reset(){
			$('#fm').form('clear');
	}
	
	//ff
	function fireFoxHandler(evt)
	{ 
	    if(evt.keyCode==13){  
	         $('#login_id').click();
        }  
	}
	

   function setPost()
   {
      var obj = $('#loginbg');
      
      var width = obj.width();
      
      var height = obj.height();
      
      var left = ($(window).outerWidth() - width) / 2 + $(document).scrollLeft();
      
      var top = ($(window).outerHeight() - height) / 2 + $(document).scrollTop();
      obj.offset({ top: top, left: left });
   
   }
	
   $(function(){	
       $('#win').window({
				title: '用户登录',
				shadow: false,
				modal: false,
				closable: false,
				minimizable: false,
				maximizable: false,
				resizable:false,
				draggable:false,
				collapsible: false
		});
		
		$(window).resize(function(){
		  $('#win').window("center");
		  setPost();
		});
		
		
		
		if(document.addEventListener)
		{
	        document.addEventListener("keypress",fireFoxHandler, true);   
	    }
	    else
	    {
	       if(window.event.keyCode==13)
           {
                $('#login_id').click();
           }
	    }
		
		$("#verify_img").bind('click', function() {
             $("#verify_img").attr("src", "../servlet/CheckCode?n=4&w=50&h=20&rd=" + Math.random());
        });
        
        setPost();
        
   });
   
   window.onload = function ()
   {
     if ( $.browser.msie ){
          if($.browser.version=='8.0' || $.browser.version=='7.0' || $.browser.version=='6.0')
          {
            setPost();
          }
     }
   }
  
   
   
   
</script>
<body style="height:100%;width:100%;overflow:hidden;border:none;">
	  <div class="loginbg" id="loginbg">
		    <div id="win" class="easyui-window" style="width:400px;height:260px;padding:5px;">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">
			<form id="fm" method="post">
				<div class="fitem">
					<label>用户名</label>
					<input name="username" type="text" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label style="letter-spacing:12px;">密码</label>
					<input name="password" type="password" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>验证码</label>
					<img id="verify_img" src="../servlet/CheckCode" style="width:50px;height:20px;vertical-align:middle;cursor:pointer" title="点击刷新"/>
				    <input name="code" type="text" class="easyui-validatebox" required="true" style="width:93px;" maxlength="4">
				</div>
			</form>
				</div>
				<div region="south" border="false" style="text-align:center;height:30px;line-height:30px;">
					<a class="easyui-linkbutton" id="login_id" iconCls="icon-ok" href="javascript:void(0)" onclick="login();">确定</a>
					<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="reset();">重置</a>
				</div>
			</div>
		  </div>
      </div> 
  <div class="bottom" style="left:0;bottom:0; position:absolute;">
		  <div style="padding-top:20px;font-size: 12px;">南京凯之渡信息技术有限公司</div>
 </div>
</body>
</html>