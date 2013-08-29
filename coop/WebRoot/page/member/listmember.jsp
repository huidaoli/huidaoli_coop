<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
		<script type="text/javascript" src="../page/upload/gener.js"></script>
		<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
	<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = "";
			}
		$(function(){
			$('#tt').datagrid({
				title:'合作伙伴信息',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'member/getAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'注册手机',field:'userName',width:100},
				    {title:'姓名',field:'realName',width:100},
				    {title:'公司',field:'companyname',width:100},
				    {title:'创建日期',field:'createDate',width:100},
				    {title:'状态',field:'state',width:50,
				        formatter:function(value,rec){
							if(value==0)
							{
							  return "待审核";
							}
							if(value==1)
							{
							  return "审核通过";
							}
							if(value==2)
							{
							  return "审核不通过";
							}
						}},
					{field:'opt',title:'操作',width:100,align:'center', 
						formatter:function(value,rec){
						    var html = ''
						    if(rec.state==2 || rec.state==0)
						    {
						       html +="<span style='padding-right:10px;'><img src='../themes/icons/arrow_large_up.png'\ title='审核通过' style='cursor:pointer;' onclick='stateOpt("+rec.id+",1)'></span>";
						    }
						    if(rec.state==1)
						    {
						       html +="<span style='padding-right:10px;'><img src='../themes/icons/arrow_large_down.png'\ title='审核不通过' style='cursor:pointer;' onclick='stateOpt("+rec.id+",2)'></span>";
						    }
						    html += "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getInfoById2(\"view\","+rec.id+")' ></span>";
							html += "<span><img src='../themes/icons/contact_blue_edit.png'\ title='密码重置' style='cursor:pointer'onclick='passDia("+rec.id+")' ></span>";
							return html;     
						}
						
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			//----------------
			var options = {
	                title: '重置密码',
					modal: true,
					shadow: false,
					//content:"手工输入：<input type='text' name='respass'>",
					closed: true,
					maximizable:true,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    //$('#ttt').dialog('destroy')
					     $('#respass').val('');
					     $('#mem_id').val('');
					     $("input:radio").each(function(i){
							   if(this.value==0)
							   { 
							      this.checked = true;
							   }
							 });
					    
					},
					  buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								savepass('member/resetPass.action');
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#ttt').dialog('close');
							}
						}]
	         }
	         $('#ttt').dialog(options);
			//-----------------
			
			
			
		});
		
		
		
		function lockorunlock(id,op)
		{
		     var mes = op=='lock'?"解冻":"冻结";
		     $.messager.confirm('信息','确认 '+mes+' 操作吗',function(r){
					if (r){
			     $.post('member/lockorunlock.action',{id:id,type:op},function(result){
								if (result.success){
									$('#tt').datagrid('reload');	// reload the  data
								} else {
									tAlert('信息','失败');
								}
							},'json');
				}
				});
						
		}
		
		function passDia(id){
			//alert(id);
			clearSelections();
			$('#mem_id').val(id);
			$('#ttt').dialog('open');
            //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
            //$div.dialog('refresh',url);
		}
				
		function loadEdit(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:800px;height:450px;padding:10px 20px" closed="true">');
			var options = {
	                title: tit,
					modal: true,
					shadow: false,
					href:url,
					closed: false,
					maximizable:true,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy')
					}
	         }
			if(opt=='edit' || opt=='add')
			{
				settings = {
				    buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveOrUpdate('member/saveOrUpdate.action?opt='+opt);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg').dialog('close');
							}
						}]
				}
			    $.extend(options,settings); 
			}
			
			$div.dialog(options)
            //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
            //$div.dialog('refresh',url);
		}
		
		function savepass(url,id){
		    //$('#mem_id').val(id);
			$('#fmpass').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						//$('#dlg').dialog('close');
						//$('#tt').datagrid('reload');	// reload the member data
						
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
		
		function getInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改合作伙伴信息':'查看合作伙伴信息';
		         loadEdit(strinfo,'member/getInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改合作伙伴信息':'查看合作伙伴信息'
	         loadEdit(strinfo,'member/getInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function dele(){
		
		    var rows = $('#tt').datagrid('getSelections');
		     if(rows.length==0){
		          tAlert('信息','请选择数据');
		     }else{
		        
		        var idarr = [];
		        for(var i=0;i<rows.length;i++)
		        {
		             idarr.push(rows[i].id);
		        }
		        var res = '['+idarr.join(",")+']';
		        $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('member/delete.action',{ids:res},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the  data
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
				});
		        
		     }
		}
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		    var username = $('#userNameid').val();
		    var companyname = $('#companynameid').val();
		    var realname = $('#realNameid').val();
		    var state = $('#state_id').val();
		    var query={username:username,companyname:companyname,realname:realname,state:state}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		
	 function swit(val)
	 {
	    if(val==0)
	    {
	     $('#respass').val('');
	    }
	    if(val==1)
	    {
	      
		  
		  $.post('member/generPass.action',function(result){
		                    var result = eval('('+result+')');
							if (result.res){
							    //alert(result.mess);
							    //document.getElementById("mem_id").value=result.mess;
								$('#respass').val(result.mess);
							} else {
								tAlert('信息','删除失败');
							}
						});
	    }
	 }
		
		function stateOpt(id,state){
		
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length==0 && id==''){
		          tAlert('信息','请选择数据');
		     }else{
		        
		        var idarr = [];
		        
		        if(id=='')
		        {
		           for(var i=0;i<rows.length;i++)
			        {
			             idarr.push(rows[i].id);
			        }
		        }
		        else
		        {
		           idarr.push(id);
		        }
		        var res = '['+idarr.join(",")+']';
		        var info = state==1?"审核通过":"审核不通过";
		        $.messager.confirm('信息','确认'+info,function(r){
					if (r){
						$.post('member/stateOpt.action',{ids:res,state:state},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the  data
							} else {
								tAlert('信息',info+'操作失败');
							}
						},'json');
					}
				});
		        
		     }
		}
	</script>
</head>
<body>

	<div id="ttt" data-options="iconCls:'icon-save'" style="padding:5px;width:400px;height:200px;margin-left:50px;">
		<form id="fmpass">
		新密码：<input type="text" id="respass" name="respass" class="easyui-validatebox" required="required"><br><br>
		<input type="hidden" name="id" id="mem_id"/>
		<input type="radio" style="border:none;" name="s2" value="0" onclick="swit(this.value);" checked>手工输入 
		<input type="radio" style="border:none;" name="s2" value="1" onclick="swit(this.value);">系统生成
	    </form>
	</div>
	
		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto"> 
		<div style="margin-bottom:5px">
			
			注册手机: <input name="member.userName" id="userNameid">   
			姓名: <input name="member.realName" id="realNameid">
			公司名称: <input name="member.companyname" id="companynameid">
			状态： <select id="state_id" name="state_name">
			        <option value="">--请选择--</option>
			        <option value="0">待审核</option>
			        <option value="1">审核通过</option>
			        <option value="2">审核不通过</option>
			      </select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-up" plain="true" onclick="stateOpt('',1);">审核通过</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-down" plain="true" onclick="stateOpt('',2);">审核不通过</a>
		</div>
	</div>
	
	
</body>
</html>