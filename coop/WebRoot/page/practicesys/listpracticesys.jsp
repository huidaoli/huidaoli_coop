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
		<script src="../js/jquery.Jcrop.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../themes/jquery.Jcrop.css" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
	<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = "";
			}
		$(function(){
			$('#tt').datagrid({
				title:'研发体系',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'practicesys/getAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'标题',field:'name',width:100},
				    {title:'分类',field:'type',width:100},
				    {title:'创建时间',field:'createDate',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer' onclick='getInfoById2(\"view\","+rec.id+")' ></span>"+
							       "<span><img src='../themes/icons/folder_modernist_stuffed_edit.png'\ title='编辑图解' style='cursor:pointer;border:1px solid #7eabcd;' onclick='editImg("+rec.id+")' ></span>";
						}
						
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
		});
		
				
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
								saveOrUpdate('practicesys/saveOrUpdate.action?opt='+opt);
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
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the practicesys data
						
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
		         var strinfo = opt=='edit'?'修改研发体系':'查看研发体系';
		         loadEdit(strinfo,'practicesys/getInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改研发体系':'查看研发体系'
	         loadEdit(strinfo,'practicesys/getInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function editImg(id)
		{
		    clearSelections();
	        
			  $('#ccid').val(id);
		    //alert(id);
	        
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:900px;height:550px;padding:10px 20px" closed="true">');
			var options = {
	                title: '编辑体系图解',
					modal: true,
					shadow: false,
					href:'practicesys/getImgsById.action?id='+id,
					closed: false,
					maximizable:true,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy')
					},
					buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveImgPro('../trainingsys/saveImgPro.action');
							}
						},{
							text:'重新编辑',
							handler:function(){
								reset();
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
		
		function reset()
	    {
             var id = $('#imgid').val();
             $.post('../trainingsys/resImg.action',{id:id},function(result){
                            var result = eval('('+result+')');
							if (result.result){
							     var ccid = $('#ccid').val();
								$('#dlg').dialog('refresh','practicesys/getImgsById.action?id='+ccid);
							} else {
								tAlert('信息','删除失败');
							}
						});
             	    
	    }
	    
	    
	    function checkpx()
		{
		   if($('#x1').val()=='')
		   {
		     tAlert('信息','还没有选择区域');
		     return false;
		   }
		   return true;
		}
	    
	    function saveImgPro(url){
		    var id = $('#ccid').val();
			$('#eidtimg').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate') && checkpx();
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						//$('#dlg').refresh();
						$('#dlg').dialog('refresh','practicesys/getImgsById.action?id='+id);
						//$('#tt').datagrid('reload');	// reload the trainingsys data
						
					} else {
						tAlert('信息','保存失败')
					}
				}
			});
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
						$.post('practicesys/delete.action',{ids:res},function(result){
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
		
		    var typeval = $('#practiceSys_type').val();
		    var query={name:$('#nameid').val(),type:typeval}; 
		    
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
		
		
		
	</script>
</head>
<body>
<input type="hidden" name="ccid" id="ccid">

		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			标题: <input name="practiceSys.name" id="nameid">
			分类:   <s:select list="listDictBuss" headerKey="-1" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="practiceSys.type"></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadEdit('研发体系','practicesys/loadEdit.action','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dele()">删除</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>