<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<head>
<script type="text/javascript">
	
		$(function(){
			$('#tt').datagrid({
				title:'广告图片',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'getAjaxDatacads.action?cctype=${memid}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'标题',field:'name',width:100},
				    {title:'展示号',field:'sequ',width:100},
				    {title:'创建时间',field:'createDate',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec.id+")'></span>"+
							   "<span style='padding-right:10px;'><img src='themes/icons/view.gif'\ title='查看' style='cursor:pointer' onclick='getInfoById2(\"view\","+rec.id+")' ></span>";
						}
						
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			initbuttons();
		});
		
				
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
								saveOrUpdate('saveOrUpdatecads.action?opt='+opt+'&cctype=${memid}');
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
						$('#tt').datagrid('reload');	// reload the ads data
						
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
		         var strinfo = opt=='edit'?'修改广告图片':'查看广告图片';
		         loadEdit(strinfo,'getInfoByIdcads.action?opt='+opt+'&id='+ rows[0].id+'&cctype=${memid}' ,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改广告图片':'查看广告图片'
	         loadEdit(strinfo,'getInfoByIdcads.action?opt='+opt+'&id='+id+'&cctype=${memid}',opt);
		     
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
						$.post('deletecads.action',{ids:res},function(result){
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
		
		    var query={name:$('#nameid').val(),cctype:${memid}}; 
		    
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
		
		 function initbuttons(){
	      var arr =["icon-search","icon-add","icon-edit","icon-view","icon-remove"]
	      $('.easyui-linkbutton').each(function(i){
	           $(this).linkbutton({  
			     iconCls: arr[i],
			     plain:true 
			  });  
	      })
	    }
		
		
		
	</script>
</head>
<body>
<h4 class="widget-title2">${title}</h4>
<hr />

    <table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			名称: <input name="ads.name" id="nameid">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadEdit('广告图片','loadEditcads.action?cctype=${memid}','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dele()">删除</a>
		</div>
		<div>
			
			
		</div>
	</div>
	

	