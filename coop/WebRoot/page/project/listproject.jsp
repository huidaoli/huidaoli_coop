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
				title:'项目信息',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'project/getAjaxData.action?cctype=${cctype}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'项目编号',field:'no',width:100},
				    {title:'项目名称',field:'name',width:100},
				    {title:'技术方向',field:'itfx',width:100},
					{title:'开始时间',field:'startTime',width:100},
					{title:'结束时间',field:'endTime',width:100},
					{title:'项目规模',field:'ry',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getInfoById2(\"view\","+rec.id+")' ></span>"+
							       "<span><img src='../themes/icons/group_green.png'\ title='报名人员' style='cursor:pointer'onclick='getMemByProjectId("+rec.id+")' ></span>";
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			var options = {
	                title: '审核不通过信息',
					modal: true,
					shadow: false,
					//content:"手工输入：<input type='text' name='respass'>",
					closed: true,
					maximizable:false,
					onClose:function(){
					     $('#h_id').val('');
		                 $('#h_projectid').val('');
		                 $('#h_state').val('');
					     $('#h_remark').val('');
					},
					  buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveState('project/saveState.action');
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
			
		});
		
		function openUmheckDio(o,id,cid)
		 {
		      $('#h_id').val(id);
		      $('#h_projectid').val(cid);
		      if(o=='no')
		      {
		         $('#h_state').val(2);
		         $('#ttt').dialog('open');
		      }
		      else
		      {
		         $('#h_state').val(1);
		         $('#h_remark').val('通过');
		         saveState('project/saveState.action');
		      }
		     
		 }
		 
		 function saveState(url){
			$('#fmpass').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
					    var id = result.mess;
					    $('#dlg22').dialog('refresh','project/getMemByProjectId.action?projectid='+id);
						tAlert('信息','保存成功');
						
					} else {
					    if(result.mess)
					    {
					       tAlert('信息',decodeURI(result.mess));
					    }
					    else
					    {
					      tAlert('信息','保存失败')
					    }
						
					}
				}
			});
		}
		
		
		function getMemByProjectId(id)
		{
		    clearSelections();
		    var $div = $('<div id="dlg22" class="easyui-dialog" style="width:900px;height:650px;padding:10px 20px" closed="true">');
			var options = {
	                title: '报名人员',
					modal: true,
					shadow: false,
					href:'getMemByProjectId/getMemByProjectId.action?projectid='+id,
					closed: false,
					maximizable:true,
					onClose:function(){
					    $('#dlg22').dialog('destroy')
					},
					buttons:[{
							text:'关闭',
							handler:function(){
							    $('#dlg22').dialog('close');
							}
						}]
	         }
			
			$div.dialog(options)
		}
		
				
		function loadEdit(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:900px;height:550px;padding:10px 20px" closed="true">');
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
								saveOrUpdate('project/saveOrUpdate.action?opt='+opt+'&cctype=${cctype}');
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
		
		function saveOrUpdate(url){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the project data
						
					} else {
					    if(result.mess)
					    {
					       tAlert('信息',decodeURI(result.mess));
					    }
					    else
					    {
					      tAlert('信息','保存失败')
					    }
						
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
		         var strinfo = opt=='edit'?'修改用户':'查看用户';
		         loadEdit(strinfo,'project/getInfoById.action?opt='+opt+'&id='+ rows[0].id+'&cctype=${cctype}' ,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改开班信息':'查看开班信息'
	         loadEdit(strinfo,'project/getInfoById.action?opt='+opt+'&id='+id+'&cctype=${cctype}',opt);
		     
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
						$.post('project/delete.action',{ids:res},function(result){
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
		
		    var qno = $('#noid').val();
		    var qstartTime = $('#starttimeid').datebox('getValue');
		    var qendTime = $('#endtimenameid').datebox('getValue');
		    var qtypeval = $('#project_itfx').val();
		    var query={name:$('#nameid').val(),itfx:qtypeval,no:qno,startTime:qstartTime,endTime:qendTime}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		function clearinfo()
		{
		    $('#noid').val('');
		    $('#nameid').val('');
		    $('#starttimeid').datebox('setValue','');
		    $('#endtimenameid').datebox('setValue','');
		
		}
		
		function inportexcel()
		{
		
		   var $div = $('<div id="dlg" class="easyui-dialog" style="width:400px;height:200px;padding:10px 20px" closed="true">');
			var options = {
	                title: '批量导入',
					modal: true,
					shadow: false,
					href:'project/toImport.action?cctype=${cctype}',
					closed: false,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy');
					},
					buttons:[{
					        id:'impid',
							text:'导入',
							iconCls:'icon-ok',
							handler:function(){
								impor();
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg').dialog('close');
							}
						}]
	         }
			
			$div.dialog(options)
		  
		}
		
		
		function clearUp()
		{
		
		   //document.getElementById('inpid').innerHTML = "<input type='file' name='attafile' id='attafilei'>";
		   //$('#inpid').html("<input type='file' name='attafile' id='attafilei'>")
		   //attfile.outerHTML=attfile.outerHTML;
		   $("#attafilei").after($("#attafilei").clone(true).val("")); 
           $("#attafilei").remove();
		
		}
		
		function checkempty()
		{
		    var attfile = document.getElementById("attafileid");
		    alert(attfile);
		    var val = document.getElementById("attafileid").value;
		    //var val = $('#attafilei').val();
		
		    if(val==null || val=='null' || val=='')
		    {
		        $('#updid').linkbutton('enable');
	            tAlert('信息','附件不能为空')
	            return false;
		    }
		    return true;
		}
		
		function impor(){
			$('#fmattaexce').form('submit',{
				url: 'project/importExcel.action?cctype=${cctype}',
				onSubmit: function(){
				   return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
						tAlert('信息','导入成功');
						//$('#dlg').dialog('close');
						$('#tt').datagrid('reload');
						//clearUp();
					    $('#impid').linkbutton('enable');
						
					} else {
					    //alert((result.mess))
					    //alert(decodeURI('%E6%A8%A1%E6%9D%BF%E9%94%99%E8%AF%AF'));
						tAlert('信息',decodeURI(result.mess));
					}
				}
			});
		}
	
		
	</script>
</head>
<body>

<div id="ttt" data-options="iconCls:'icon-save'" style="padding:5px;width:400px;height:200px;margin-left:50px;">
		<form id="fmpass" method="post">
		<input type="hidden" id="h_id" name="id"/> 
		<input type="hidden" id="h_projectid" name="projectid"/>
		<input type="hidden" id="h_state" name="state"/>
		<textarea  name="remark" style="width:280px;height:60px;"id="h_remark" class="easyui-validatebox" required="required"></textarea>
	    </form>
	</div>
		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			项目编号: <input name="project.no" id="noid">
			项目名称: <input name="project.name" id="nameid">
			技术方向:   <s:select list="listDictBussitfx" headerKey="-1" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="project.itfx"></s:select>
			<br><br>
			开始时间: <input name="project.startTime" id="starttimeid" class="easyui-datebox">
			结束时间: <input name="project.endTime" id="endtimenameid" class="easyui-datebox">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-clear" onclick="clearinfo()">清空</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadEdit('项目信息','project/loadEdit.action?cctype=${cctype}','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dele()">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-inport" plain="true" onclick="inportexcel()">批量导入</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>