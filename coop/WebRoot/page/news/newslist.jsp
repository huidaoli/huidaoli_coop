<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>行业资讯</title>
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
				title:'行业资讯',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'news/getAjaxData.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
				//rowStyler: function(index,row){
				//	if (row.zhiding == 1){
				//		return 'background-color:#FF0000;font-weight:bold;';
				//	}
				//},
				columns:[[
				    {title:'标题',field:'name',width:100,
				        formatter:function(value,rec){
							if(rec.zhiding==1)
							{
							  return "<img src='../themes/icons/m00.gif'>"+rec.name;
							}
							return rec.name;
					}},
				    {title:'分类',field:'typename',width:100},
				    {title:'创建时间',field:'createDate',width:100},
				    {title:'发布者',field:'coopname',width:100,
				          formatter:function(value,rec){
							if(rec.coopid==-1)
							{
							  return "MMPro平台";
							}
							return rec.coopname;
						}},
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
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getNewsInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getNewsInfoById2(\"view\","+rec.id+")' ></span>";
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
		});
     
		function loadNewsInfo(tit,url,opt){
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
								saveNews('News/saveNews.action?opt='+opt);
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
		
		function saveNews(url){
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
						$('#tt').datagrid('reload');	// reload the News data
						
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
		
		function getNewsInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改行业资讯':'查看行业资讯';
		         loadNewsInfo(strinfo,'news/loadNewsInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getNewsInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改行业资讯':'查看行业资讯'
	         loadNewsInfo(strinfo,'news/loadNewsInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteNews(){
		
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
						$.post('news/deleteNews.action',{ids:res},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the News data
								clearSelections();
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
		
		    var typeval = $('#news_type').val();
		    var state = $('#state_id').val();
		    var query={name:$('#nameid').val(),type:typeval,state:state}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		function stateOpt(state){
		
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
		        var info = state==1?"审核通过":"审核不通过";
		        $.messager.confirm('信息','确认'+info,function(r){
					if (r){
						$.post('news/stateOpt.action',{ids:res,state:state},function(result){
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
		
		function setTop(state)
		{
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
		        var info = state==1?"置顶":"取消置顶";
		        $.messager.confirm('信息','确认'+info,function(r){
					if (r){
						$.post('news/setTop.action',{ids:res,state:state},function(result){
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


		<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			标题: <input name="news.name" id="nameid">
			分类: <s:select list="listDictBuss" headerKey="-1" headerValue="--请选择--" listKey="dictId" listValue="dictName" name="news.type"></s:select>
			状态: <select id="state_id" name="state_name">
			        <option value="">--请选择--</option>
			        <option value="0">待审核</option>
			        <option value="1">审核通过</option>
			        <option value="2">审核不通过</option>
			      </select>  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadNewsInfo('新闻资讯','news/loadNews.action','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getNewsInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getNewsInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteNews()">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-up" plain="true" onclick="stateOpt(1);">审核通过</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-down" plain="true" onclick="stateOpt(2);">审核不通过</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ding" plain="true" onclick="setTop(1);">置顶</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-xiading" plain="true" onclick="setTop(0);">取消置顶</a>
			
		</div>
		<div>
			
			
		</div>
	</div>
	
	
</body>
</html>