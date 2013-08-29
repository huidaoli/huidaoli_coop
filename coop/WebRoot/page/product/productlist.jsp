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
		<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
	<script type="text/javascript">
		$(function(){
			$('#tt').datagrid({
				title:'产品列表',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'product/getProductList.action?memid=${memid}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'名称',field:'name',width:150},
				    {title:'分类',field:'sortname',width:80},
				    {title:'产地',field:'proarea',width:150},
					{title:'发布时间',field:'createDate',width:80},
					{title:'合作伙伴',field:'coopname',width:80},
					{title:'货架',field:'linestate',width:80,
					    formatter:function(value,rec){
						    if(value==0){
						       return "上架";
						    }
							else if(value==1){
							   return "<font color='red'>下架</font>";
							}
							else
							{
							   return "";
							}
						}
					},
					{title:'状态',field:'state',width:80,
					    formatter:function(value,rec){
						    if(value==0){
						       return "<font color='red'>待审核</font>";
						    }
							else if(value==1){
							   return "审核通过";
							}
							else if(value==2){
							   return "<font color='red'>审核不通过</font>";
							}
							else
							{
							   return "";
							}
						}
					},
					{title:'同步',field:'sync',width:80,
					    formatter:function(value,rec){
						    if(value==0){
						       return "待同步";
						    }
							else if(value==1){
							   return "<font color='blue'>同步成功</font>";
							}
							else if(value==2){
							   return "<font color='red'>同步失败</font>";
							}
							else
							{
							   return "";
							}
						}
					},
					{field:'opt',title:'操作',width:120,align:'center', 
						formatter:function(value,rec){
						    var html ='';
						    if(rec.state==2 || rec.state==0)
						    {
						       html +="<span style='padding-right:10px;'><img src='../themes/icons/arrow_large_up.png'\ title='审核通过' style='cursor:pointer;' onclick='stateOpt("+rec.id+",1)'></span>";
						    }
						    if(rec.state==1)
						    {
						       html +="<span style='padding-right:10px;'><img src='../themes/icons/arrow_large_down.png'\ title='审核不通过' style='cursor:pointer;' onclick='stateOpt("+rec.id+",2)'></span>";
						    }
						    html+="<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec.id+")'></span>";
						    html+="<span style='padding-right:10px;'><img src='../themes/icons/application_go.png'\ title='同步' style='cursor:pointer'onclick='synctoshop("+rec.id+","+rec.state+")' ></span>";
						    html+="<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getInfoById2(\"view\","+rec.id+")' ></span>";
							return html;
							       
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			
		});
		
		function synctoshop(id,state)
		{
		    clearSelections();
		    if(state!=1)
		    {
		      tAlert('信息','审核通过才能同步');
		    }
		    else
		    {
		             
			    $.messager.confirm('信息','确认同步吗',function(r){
						if (r){
							$.post('product/synctoshop.action',{id:id,state:1},function(result){
							    var result = eval('('+result+')');
								if (result.result){
								    tAlert('信息','同步成功');
								} else {
									tAlert('信息','操作失败');
								}
								$('#tt').datagrid('reload');	// reload the  data
							});
						}
				});
		    }
		}
		
				
		function loadEdit(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:800px;height:550px;padding:10px 20px" closed="true">');
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
							plain:true,
							handler:function(){
								saveOrUpdate('product/saveOrUpdateProduct.action?opt='+opt);
							}
						},{
							text:'关闭',
							plain:true,
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
				    var city = $('#city').val();
				    var dist = $('#dist').val();
				    var val = $('#prov').val()+(city==null?'':' '+city)+(dist==null?'':' '+dist);
				    $("#proarea").val(val);
				    var vs = arrdeleids.join(",");
				    //alert(vs);
				    $("#tempdeleids").val(vs);
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
		     //clearSelections();
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'产品修改':'产品查看';
		         loadEdit(strinfo,'product/loadProduct.action?memid=${memid}&id='+ rows[0].id+'&opt='+opt,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改产品修改':'产品查看';
	         loadEdit(strinfo,'product/loadProduct.action?memid=${memid}&id='+id+'&opt='+opt,opt);
		     
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
						$.post('product/deleteProduct.action',{ids:res},function(result){
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
		
		function stateOpt(id,state){
		
		    var rows = $('#tt').datagrid('getSelections');
		     if(rows.length==0 && id=='')
		     {
		          tAlert('信息','请选择数据');
		     }
		     else{
		        
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
						$.post('product/stateOpt.action',{ids:res,state:state},function(result){
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
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		
		    var productsort = $('#product_sort').val();
		    var linestate = $('#linestate').val();
		    var state = $('#state').val();
		    var sync = $('#sync').val();
		      
		    var query={name:$('#nameid').val(),sort:productsort,linestate:linestate,state:state,sync:sync}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
	
		
	</script>
</head>
<body>
	<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			产品名称: <input name="product.name" id="nameid">
			货架状态:<select name="product.linestate" id="linestate">
			           <option value="-1">--全部--</option>
			           <option value="0">上架</option>
			           <option value="1">下架</option>
			        </select>
			审核状态: <select name="product.state" id="state">
			           <option value="-1">--全部--</option>
			           <option value="0">待审核</option>
			           <option value="1">审核通过</option>
			           <option value="2">审核不通过</option>
			        </select>
			
			同步状态: <select name="product.sync" id="sync">
			           <option value="-1">--全部--</option>
			           <option value="0">待同步</option>
			           <option value="1">同步成功</option>
			           <option value="2">同步失败</option>
			        </select>
			产品分类: <s:select list="prodcutsort" headerKey="-1" headerValue="--全部--" listKey="dictId" listValue="dictName" name="product.sort" ></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-up" plain="true" onclick="stateOpt('',1);">审核通过</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-down" plain="true" onclick="stateOpt('',2);">审核不通过</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
</body>
</html>