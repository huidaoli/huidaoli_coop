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
		<!-- 
	    <link rel="stylesheet" type="text/css" href="../codebase/GooUploader.css"/>
		<script type="text/javascript" src="../codebase/GooUploader.js"></script>
		<script type="text/javascript" src="../codebase/swfupload.js"></script>
		 -->
	<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = "";
			}
		$(function(){
			$('#tt').datagrid({
				title:'学习班信息',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'openclass/getAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'班级名称',field:'name',width:100},
				    {title:'方向',field:'classType',width:100},
				    {title:'满员人数',field:'sumnum',width:100},
					{title:'开班时间',field:'createDate',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getOpenClassInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getOpenClassInfoById2(\"view\","+rec.id+")' ></span>"+
							       "<span><img src='../themes/icons/group_green.png'\ title='报名人员' style='cursor:pointer'onclick='getMemByClassId("+rec.id+")' ></span>";
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
		                 $('#h_classid').val('');
		                 $('#h_state').val('');
					     $('#h_remark').val('');
					},
					  buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveState('openclass/saveState.action');
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
					    $('#dlg22').dialog('refresh','openclass/getMemByClassId.action?classid='+id);
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
		
		
		function getMemByClassId(id)
		{
		    clearSelections();
		    var $div = $('<div id="dlg22" class="easyui-dialog" style="width:800px;height:450px;padding:10px 20px" closed="true">');
			var options = {
	                title: '报名人员',
					modal: true,
					shadow: false,
					href:'openclass/getMemByClassId.action?classid='+id,
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
		
		 function openUmheckDio(o,id,cid)
		 {
		      $('#h_id').val(id);
		      $('#h_classid').val(cid);
		      if(o=='no')
		      {
		         $('#h_state').val(2);
		         $('#ttt').dialog('open');
		      }
		      else
		      {
		         $('#h_state').val(1);
		         $('#h_remark').val('通过');
		         saveState('openclass/saveState.action');
		      }
		     
		 }
		
		
				
		function loadOpenClassInfo(tit,url,opt){
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
								saveOpenClass('openclass/saveOpenClass.action?opt='+opt);
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
		
		function saveOpenClass(url){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the OpenClass data
						
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
		
		function getOpenClassInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改用户':'查看用户';
		         loadOpenClassInfo(strinfo,'openclass/loadOpenClassInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getOpenClassInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改开班信息':'查看开班信息'
	         loadOpenClassInfo(strinfo,'openclass/loadOpenClassInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteOpenClass(){
		
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
						$.post('openclass/deleteOpenClasss.action',{ids:res},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the OpenClass data
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
		
		    var typeval = $('#openClass_classType').val();
		    var query={name:$('#nameid').val(),type:typeval}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
	
		
	</script>
</head>
<body>
<div id="ttt" data-options="iconCls:'icon-save'" style="padding:5px;width:400px;height:200px;margin-left:50px;">
		<form id="fmpass" method="post">
		<input type="hidden" id="h_id" name="id"/> 
		<input type="hidden" id="h_classid" name="classid"/>
		<input type="hidden" id="h_state" name="state"/>
		<textarea  name="remark" style="width:280px;height:60px;"id="h_remark" class="easyui-validatebox" required="required"></textarea>
	    </form>
	</div>

		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			学习班名称: <input name="openClass.name" id="nameid">
			班级类型:   <s:select list="listDictBuss" headerKey="-1" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="openClass.classType"></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadOpenClassInfo('开班','openclass/loadOpenClass.action','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getOpenClassInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getOpenClassInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteOpenClass()">删除</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>