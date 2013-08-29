<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript">
		$(function(){
			$('#tt').datagrid({
				title:'产品列表',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'getProductList.action?memid=${memid}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'名称',field:'name',width:100},
				    {title:'分类',field:'sortname',width:100},
				    {title:'产地',field:'proarea',width:150},
					{title:'状态',field:'state',width:80,
					    formatter:function(value,rec){
						    if(value==0){
						       return "待审核";
						    }
							else if(value==1){
							   return "审核通过";
							}
							else if(value==2){
							   return "审核不通过";
							}
							else
							{
							   return "";
							}
						}
					},
					{title:'货架状态',field:'linestate',width:80,
					    formatter:function(value,rec){
						    if(value==0)
						    {
						       return "上架";
						    }
							else if(value==1){
							   return "下架";
							}
							else
							{
							   return "";
							}
						}
					},
					{title:'发布时间',field:'createDate',width:80},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span style='padding-right:10px;'><img src='themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getInfoById2(\"view\","+rec.id+")' ></span>";
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
								saveOrUpdate('saveOrUpdateProduct.action?opt='+opt);
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
		     var rows = $('#tt').datagrid('getSelections');
		     alert(rows.length);
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'产品修改':'产品查看';
		         loadEdit(strinfo,'loadProduct.action?memid=${memid}&id='+ rows[0].id+'&opt='+opt,opt);
		        
		     }
		}
		
		
		function getInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改产品修改':'产品查看';
	         loadEdit(strinfo,'loadProduct.action?memid=${memid}&id='+id+'&opt='+opt,opt);
		     
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
						$.post('deleteProduct.action',{ids:res},function(result){
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
		
		function lineOpt(state){
		
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
		        var info = state==0?"上架":"下架";
		        $.messager.confirm('信息','确认'+info,function(r){
					if (r){
						$.post('lineOpt.action',{ids:res,state:state},function(result){
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
		    var query={name:$('#nameid').val(),sort:productsort}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		
	    function initbuttons(){
	      var arr =["icon-search","icon-add","icon-edit","icon-view","icon-up","icon-down","icon-remove"]
	      $('.easyui-linkbutton').each(function(i){
	           $(this).linkbutton({  
			     iconCls: arr[i],
			     plain:true 
			  });  
	      })
	    }
		
	</script>
<h4 class="widget-title2">${title}</h4>
<hr />

	<table id="tt"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			产品名称: <input name="product.name" id="nameid">
			产品分类: <s:select list="prodcutsort" headerKey="-1" headerValue="--全部--" listKey="dictId" listValue="dictName" name="product.sort" ></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadEdit('产品新增','loadProduct.action?memid=${memid}','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-up" plain="true" onclick="lineOpt(0);">上架</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-down" plain="true" onclick="lineOpt(1);">下架</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dele();">删除</a>
		</div>
		<div>
			
			
		</div>
	</div>
	
	